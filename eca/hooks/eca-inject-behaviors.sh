#!/bin/bash
set -euo pipefail

DEBUG="${DEBUG:-true}"

INPUT=$(cat)
PROMPT=$(jq -r '.prompt // empty' <<< "$INPUT")
SESSION_ID=$(jq -r '.chat_id // empty' <<< "$INPUT")

if [ -z "$PROMPT" ]; then
  exit 0
fi

# Resolve symlink (macOS compatible)
SCRIPT_PATH="${BASH_SOURCE[0]}"
while [[ -L "$SCRIPT_PATH" ]]; do
    DIR="$(cd "$(dirname "$SCRIPT_PATH")" && pwd)"
    SCRIPT_PATH="$(readlink "$SCRIPT_PATH")"
    [[ "$SCRIPT_PATH" != /* ]] && SCRIPT_PATH="$DIR/$SCRIPT_PATH"
done
REPO_DIR="$(cd "$(dirname "$SCRIPT_PATH")/../.." && pwd)"
BEHAVIORS_DIR="$REPO_DIR/behaviors"

# Extract only the user's actual prompt (ignore injected AdditionalContext)
# Look for <user-prompt> section, otherwise use the raw prompt
USER_PROMPT=$(sed -n '/<user-prompt>/,/<\/user-prompt>/p' <<< "$PROMPT" | sed '1d;$d')
if [ -z "$USER_PROMPT" ]; then
  USER_PROMPT="$PROMPT"
fi

# Extract hashtags: #=mode, #quality, #technique (only from user's prompt)
HASHTAGS=$(grep -oE '#[=a-zA-Z0-9_-]+' <<< "$USER_PROMPT" | sort -u) || true

# State directory for persistence
STATE_DIR="$HOME/.config/eca/.behaviors"
STATE_FILE=""
if [ -n "$SESSION_ID" ]; then
  STATE_FILE="$STATE_DIR/$SESSION_ID"
fi

# No new hashtags - check injected context first, then persisted state
if [ -z "$HASHTAGS" ]; then
  # Check if there's already an operating mode in the injected AdditionalContext
  INJECTED_MODE=""
  if grep -q '<operating-mode>' <<< "$PROMPT"; then
    # Extract mode names from lines like "# #=mentor — Mentor"
    MODES_FOUND=$(grep -oE '# #=[a-z_-]+' <<< "$PROMPT" | sed 's/# #=\([a-z_-]*\)/\1/' || true)
    MODE_COUNT_INJECTED=$(echo "$MODES_FOUND" | wc -l | tr -d ' ')
    
    if [ "$MODE_COUNT_INJECTED" -gt 1 ]; then
      # Multiple modes in injected context - warn and use the last one (most recent)
      echo "Warning: Multiple operating modes in injected context ($(echo "$MODES_FOUND" | tr '\n' ' ')). Using last one." >&2
    fi
    
    if [ -n "$MODES_FOUND" ]; then
      INJECTED_MODE=$(echo "$MODES_FOUND" | tail -1)
    else
      # Try "# Mode Name" format (e.g., "# Code Mode")
      INJECTED_MODE=$(sed -n '/<operating-mode>/,/<\/operating-mode>/p' <<< "$PROMPT" | grep -oE '^# [A-Za-z]+ Mode' | tail -1 | sed 's/# \([A-Za-z]*\) Mode/\1/' | tr 'A-Z' 'a-z' || true)
    fi
  fi

  if [ -n "$INJECTED_MODE" ]; then
    # Mode already injected - don't add duplicate context
    exit 0
  fi

  # No mode in context - use persisted state
  if [ -n "$STATE_FILE" ] && [ -f "$STATE_FILE" ] && [ -s "$STATE_FILE" ]; then
    ACTIVE=$(cat "$STATE_FILE")
    CONTEXT=""
    for TAG in $ACTIVE; do
      # Handle both #=mode and #quality formats
      NAME="${TAG#\#=}"  # Try stripping #=
      if [ "$NAME" = "$TAG" ]; then
        NAME="${TAG#\#}"  # Fall back to stripping just #
      fi
      for CATEGORY in modes qualities techniques; do
        FILE="$BEHAVIORS_DIR/$CATEGORY/$NAME/prompt.md"
        if [ -f "$FILE" ]; then
          [ -n "$CONTEXT" ] && CONTEXT+=$'\n\n'
          CONTEXT+="$(cat "$FILE")"
        fi
      done
    done
    if [ -n "$CONTEXT" ]; then
      jq -n --arg ctx "$CONTEXT" --arg active "$ACTIVE" '{
        additionalContext: ("Active behaviors: " + $active + "\n\n" + $ctx)
      }'
    fi
  fi
  exit 0
fi

# Reject multiple operating modes
MODE_COUNT=$(grep -c '^#=' <<< "$HASHTAGS") || true
if [ "$MODE_COUNT" -gt 1 ]; then
  MODE_TAGS=$(grep '^#=' <<< "$HASHTAGS" | tr '\n' ' ')
  INPUT_SUMMARY=$(jq -c '{chat_id, behavior, agent, prompt: .prompt[:100]}' <<< "$INPUT" 2>/dev/null || echo "$PROMPT")
  ERROR_MSG="Multiple operating modes: ${MODE_TAGS%. }. Use one mode at a time.\n\nValid modes: code, debug, review, test, spec, research, assess, drive, navigate, record, mentor, probe\n\nInput: $INPUT_SUMMARY"
  if [ "${DEBUG:-}" = "true" ]; then
    jq -n --arg msg "$ERROR_MSG" '{additionalContext: ("⚠️ Error: " + $msg)}'
  else
    echo "Error: $ERROR_MSG" >&2
  fi
  exit 2
fi

# Separate mode from modifiers
MODE_TAG=$(grep '^#=' <<< "$HASHTAGS" | head -1) || true
MODE_TAG="${MODE_TAG#\#=}"  # Strip #= prefix
MOD_TAGS=$(grep -v '^#=' <<< "$HASHTAGS") || true

# Read mode content
MODE_CONTEXT=""
MISSING=""
if [ -n "$MODE_TAG" ]; then
  FILE="$BEHAVIORS_DIR/modes/$MODE_TAG/prompt.md"
  if [ -f "$FILE" ]; then
    MODE_CONTEXT="$(cat "$FILE")"
  else
    MISSING+=" #$MODE_TAG"
  fi
fi

# Read modifier content (qualities + techniques)
MOD_CONTEXT=""
if [ -n "$MOD_TAGS" ]; then
  while IFS= read -r TAG; do
    [ -z "$TAG" ] && continue
    NAME="${TAG#\#}"
    FOUND=false
    for CATEGORY in qualities techniques; do
      FILE="$BEHAVIORS_DIR/$CATEGORY/$NAME/prompt.md"
      if [ -f "$FILE" ]; then
        FOUND=true
        [ -n "$MOD_CONTEXT" ] && MOD_CONTEXT+=$'\n\n'
        MOD_CONTEXT+="$(cat "$FILE")"
      fi
    done
    if [ "$FOUND" = false ]; then
      MISSING+=" $TAG"
    fi
  done <<< "$MOD_TAGS"
fi

# Warn about missing behaviors (but continue)
if [ -n "$MISSING" ]; then
  echo "Warning: unknown behaviors:$MISSING" >&2
fi

# Persist active behaviors
if [ -n "$STATE_FILE" ]; then
  mkdir -p "$STATE_DIR"
  ACTIVE=""
  [ -n "$MODE_TAG" ] && [ -n "$MODE_CONTEXT" ] && ACTIVE+="#=$MODE_TAG"
  if [ -n "$MOD_TAGS" ]; then
    while IFS= read -r TAG; do
      [ -z "$TAG" ] && continue
      NAME="${TAG#\#}"
      for CATEGORY in qualities techniques; do
        if [ -f "$BEHAVIORS_DIR/$CATEGORY/$NAME/prompt.md" ]; then
          [ -n "$ACTIVE" ] && ACTIVE+=" "
          ACTIVE+="$TAG"
        fi
      done
    done <<< "$MOD_TAGS"
  fi
  echo "$ACTIVE" > "$STATE_FILE"
fi

# Build output
WRAPPED=""

if [ -n "$MODE_CONTEXT" ]; then
  WRAPPED+="<operating-mode>
$MODE_CONTEXT
</operating-mode>"
fi

if [ -n "$MOD_CONTEXT" ]; then
  if [ -n "$MODE_CONTEXT" ]; then
    WRAPPED+=$'\n\n'"<behavior-modifiers>
These modifiers apply WITHIN the operating mode's constraints.

$MOD_CONTEXT
</behavior-modifiers>"
  else
    WRAPPED+="<behavior-modifiers>
$MOD_CONTEXT
</behavior-modifiers>"
  fi
fi

# Add persistence instruction
if [ -n "$WRAPPED" ]; then
  WRAPPED+=$'\n\n'"These behaviors apply until superseded by new hashtags. During compaction, preserve the most recent <operating-mode> and <behavior-modifiers> blocks."
  jq -n --arg ctx "$WRAPPED" '{
    additionalContext: $ctx
  }'
fi

exit 0