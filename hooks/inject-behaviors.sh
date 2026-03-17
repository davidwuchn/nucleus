#!/bin/bash
# inject-behaviors.sh - Extract hashtags and inject behavior prompts
# Integrates with pre-commit hooks

BEHAVIORS_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)/behaviors"

inject_behaviors() {
    local input="$1"
    local hashtags=$(echo "$input" | grep -oE '#[a-z-]+' | sort -u)
    
    if [ -z "$hashtags" ]; then
        echo "$input"
        return
    fi
    
    local injected=""
    
    for tag in $hashtags; do
        local name=${tag#\#}
        
        for category in modes qualities techniques; do
            local prompt_file="$BEHAVIORS_DIR/$category/$name/prompt.md"
            if [ -f "$prompt_file" ]; then
                injected="$injected"$'\n'"$(cat "$prompt_file")"$'\n'
            fi
        done
    done
    
    if [ -n "$injected" ]; then
        echo "$input"
        echo ""
        echo "---"
        echo "## Active Behaviors"
        echo "$injected"
    else
        echo "$input"
    fi
}

# If called directly with input
if [ -p /dev/stdin ]; then
    inject_behaviors "$(cat)"
fi