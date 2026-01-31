# Local Changes vs Upstream

**Tracking divergence from upstream/main**
## Repository Information

- **Upstream**: https://github.com/michaelwhitford/nucleus.git
- **Origin**: https://github.com/davidwuchn/nucleus
- **Current Branch**: main
- **Upstream Reference**: upstream/main

---

## File Comparison

### Files in Upstream (13 markdown files + 19 ECA files = 32 total)

```
DIAG.md
EXECUTIVE.md
LAMBDA_PATTERNS.md
NUCLEUS_GAME.md
OPERATOR_ALGEBRA.md
README.md
RECURSIVE_DEPTHS.md
SYMBOLIC_FRAMEWORK.md
TEST.md
WRITING.md
skills/nucleus-clojure/SKILL.md
skills/nucleus/SKILL.md

eca/                          - Editor Code Assistant integration (19 files)
├── README.md                 - ECA configuration and setup
└── prompts/                  - Prompt templates for ECA tools
    ├── agent_behavior.md
    ├── compact.md
    ├── init.md
    ├── inline_completion.md
    ├── plan_behavior.md
    ├── rewrite.md
    ├── skill_create.md
    └── title.md
    └── tools/                - Tool-specific prompt documentation
        ├── clj-nrepl-eval.md
        ├── clj-paren-repair.md
        ├── directory_tree.md
        ├── edit_file.md
        ├── grep.md
        ├── move_file.md
        ├── read_file.md
        ├── shell_command.md
        ├── skill.md
        └── write_file.md
```

### Files in Local Only (My Additions)

```
AGENTS.md                     - Protected files rule and operational configuration (48 lines, μ-applied: exemplifies directness principle)
NUCLEUS_GUIDE.md              - Nucleus-specific practical guidance (576 lines, π-applied: exemplifies synthesis principle)
OPERATIONAL_CONSTRAINTS.md    - Operational constraints specification (197 lines, μ-applied: exemplifies directness principle)
PHILOSOPHY_RESEARCH.md        - I Ching × Eight Keys philosophical synthesis (1,274 lines)
EQUATIONS_FOR_WORLD.md       - Reference table (38 lines, new)
BANG_COMMANDS.md             - Bang commands reference (297 lines, π-applied: exemplifies synthesis principle)
LOCAL_CHANGES.md              - This file (upstream vs local tracking, 377 lines)

skills/nucleus-tutor/SKILL.md     - Tutor skill (new, 95 lines)
skills/sarcasmotron/SKILL.md      - Sarcasmotron skill (71 lines, μ-applied: exemplifies directness principle)
```

*Note: μ-applied indicates the file exemplifies the directness principle (μ) from the Eight Keys framework; π-applied indicates the synthesis principle (π).*

---

## 1. Philosophy

**Why separate upstream/local?**

**Core Principle**: Respect upstream structure, add value locally.

**ZEROTH RULE**: NEVER modify upstream files (see [Upstream File Constraint](#upstream-file-constraint-zeroth-rule))

**Reasoning**:
- **Preserve upstream compatibility**: Never modify upstream files
- **Clear separation**: Upstream = 32 files (3,500+ lines), Local = 8 files (2,561 lines)
- **Track divergence**: Document all changes in this file
- **Enable upstream sync**: Maintain merge compatibility

**Anti-Pattern**:
- Modify upstream README.md → Breaks compatibility
- Delete upstream files → Loses upstream work
- Merge upstream content into local → Conflicts on sync

---

## 2. Operational Architecture

**How to track divergence?**

**Strategy**: Categorize changes into clear buckets.

**Categories**:
1. **Preserve Upstream**: All 13 upstream files - DO NOT MODIFY
2. **New Local Additions**: AGENTS.md, NUCLEUS_GUIDE.md, etc. - Track freely

**Process**:
```
λ(local_change).verify ⟺ [
  track_in(LOCAL_CHANGES.md)        // Document divergence
  test_sync_before_claim()           // Verify compatibility
  preserve_upstream_structure()      // Don't modify upstream files
]
```

---

## 3. Verification Protocol

**How to ensure quality?**

**Rule**: Test claims before making them.

**Upstream Sync Verification**:
```bash
# Before claiming "ready for upstream sync"
git fetch upstream
git merge upstream/main
# Does it merge cleanly?
# Do conflicts arise?
# Does framework still work?

# Then claim "ready for upstream sync"
```

**Local Change Verification**:
```bash
# Before adding local file
- Does it follow AGENTS.md structure?
- Is it Nucleus-specific?
- Does it provide unique value?
# Then add and track in LOCAL_CHANGES.md
```

---

## 4. Operational Constraints

### Key Constraint for Local Changes: ZEROTH RULE

**⚠️ ZEROTH RULE**: NEVER modify files that exist in upstream/main

λ(upstream_file).modify ⟺ **FAIL ∀ (Vigilance) + FAIL ∃ (Truth)**

**Why this rule is critical for local changes tracking**:
- **Preserves upstream compatibility**: Enables clean merges and syncs
- **Clear separation**: Upstream files remain intact; local additions are distinct
- **Enables verification**: Can test upstream sync without conflicts
- **Documentation clarity**: Changes are tracked in this file, not mixed with upstream

**See [OPERATIONAL_CONSTRAINTS.md](OPERATIONAL_CONSTRAINTS.md) for complete operational constraints** including:
- Implementation constraints and language policy
- Development tools and preferences  
- Operational architecture with acceptance criteria and reject modes
- Lambda-calculus tool patterns
- Verification protocols
- Complete ZEROTH RULE verification procedures and upstream files list

---

## 5. Protected Files Rule

**⚠️ ZEROTH RULE**: Ask user permission before editing protected local files.

These files define the framework itself. Modifying them changes the rules for all users.

**Protected files**:
| File | Purpose |
|------|---------|
| `AGENTS.md` | Entry point and operational manifest |
| `LOCAL_CHANGES.md` | Upstream vs local change tracking |
| `PHILOSOPHY_RESEARCH.md` | I Ching × Eight Keys philosophical synthesis |
| `NUCLEUS_GUIDE.md` | Practical workflows and examples |
| `OPERATIONAL_CONSTRAINTS.md` | Operational constraints and patterns |

**See**: [OPERATIONAL_CONSTRAINTS.md](OPERATIONAL_CONSTRAINTS.md) for upstream file constraint details and verification protocols.

---

## 6. Documentation Reference Rule

### No Redirect Chain Rule

**Rule**: All documentation references must link **directly** to the canonical source. No intermediate hops.

**λ(reference).verify ⟺ direct(reference) ∧ ¬∃(intermediate)**

**Anti-Pattern** (Redirect Chain):
```
❌ AGENTS.md → NUCLEUS_GUIDE.md → LOCAL_CHANGES.md
❌ NUCLEUS_GUIDE.md → PHILOSOPHY_RESEARCH.md → NUCLEUS_GUIDE.md
```

**Correct Pattern** (Direct Reference):
```
✅ AGENTS.md → LOCAL_CHANGES.md (direct to canonical)
✅ NUCLEUS_GUIDE.md → PHILOSOPHY_RESEARCH.md (direct to source)
```

**Canonical Sources by Topic**:
| Topic | Canonical Source | Entry Points Reference |
|-------|-----------------|----------------------|
| **Skill System** | `NUCLEUS_GUIDE.md#skill-system` | AGENTS.md |
| **Protected Files Rule** | `LOCAL_CHANGES.md#protected-files-rule` | AGENTS.md, NUCLEUS_GUIDE.md |
| **Operational Constraints** | `OPERATIONAL_CONSTRAINTS.md` | AGENTS.md, LOCAL_CHANGES.md |
| **Upstream Constraint** | `OPERATIONAL_CONSTRAINTS.md#upstream-file-constraint` | LOCAL_CHANGES.md |
| **I Ching Philosophy** | `PHILOSOPHY_RESEARCH.md` | NUCLEUS_GUIDE.md |
| **Math Foundations** | `SIMPLICITY.md` | NUCLEUS_GUIDE.md |
| **Bang Commands** | `BANG_COMMANDS.md` | NUCLEUS_GUIDE.md |

**Verification**:
```bash
# Check for redirect chains
# A redirect chain exists if Document A links to Document B for a topic,
# but Document B also links to Document C for the same topic.
# Document A should link directly to C.
```

**Violation**: `FAIL μ (Directness)`

**Fix**: Update entry points to reference canonical sources directly.

---
## Key Differences

### 1. Documentation Philosophy

**Upstream**: Minimal, focused, apologetic
- README.md contains "I'm not a scientist or particularly good at math"
- Simple framework with 13 total files
- Less formal structure

**Local**: Expanded, formal, non-apologetic, μ-applied (exemplifies directness principle)
- Upstream README.md not modified (preserved upstream)
- NUCLEUS_GUIDE.md adds complete framework specification (576 lines, π-applied: exemplifies synthesis principle) including operational policies
- AGENTS.md adds protected files rule (48 lines, μ-applied: exemplifies directness principle)
- PHILOSOPHY_RESEARCH.md adds I Ching philosophical synthesis (new)
- I Ching terminology uses Chinese characters (乾, 坎, 震) not romanized pinyin (Qian, Kan, Zhen) for authentic representation
- skills/sarcasmotron/SKILL.md merges operations manual into skill (71 lines, μ-applied: exemplifies directness principle)

### 2. Framework Structure

**Upstream**:
- Simple engage line: `[phi fractal euler tao pi mu] | [Δ λ ∞/0 | ε/φ Σ/μ c/h] | OODA`
- README.md contains all framework explanation
- No formal verification protocol

**Local**:
- NUCLEUS_GUIDE.md formalizes the framework with:
  - Eight Keys (ontological principles with anti-patterns)
  - λ-Calculus tool patterns
  - Symbolic compression correspondence
  - Verification protocol (Σ(Build), Σ(Lint), Σ(Test), Σ(Verify))
  - Operational policies (Language Policy, ZEROTH RULE, Development Tools)
- AGENTS.md provides protected files rule for framework integrity
- TEST.md for verification

### 3. Content Additions

**Local Only**:
- **NUCLEUS_GUIDE.md**: Complete framework specification and practical guidance
  - Formal framework specification (576 lines)
  - Eight Keys with anti-patterns and math parallels
  - λ-Calculus patterns (heredoc, parallel execution, etc.)
  - Verification protocol (Σ(Build), Σ(Lint), Σ(Test), Σ(Verify))
  - Operational policies (Language Policy, ZEROTH RULE, Development Tools)
  - Critical perspective (Three Questions)
  - Bang commands usage
  - λ(prompt).accept rejection patterns
  - Fractal architecture examples
  - Eight Keys in practice (concrete code examples)
  - Nucleus verification checklists

- **OPERATIONAL_CONSTRAINTS.md**: Operational constraints specification
  - Language policy (ENGLISH-FIRST WORKING LANGUAGE)
  - Upstream file constraint (ZEROTH RULE)
  - Development tools and preferences
  - Operational architecture with acceptance criteria
  - Lambda-calculus tool patterns
  - Verification protocols

- **AGENTS.md**: Protected files rule and operational configuration
  - Protected Local Files Rule (48 lines)
  - Framework integrity protection



- **PHILOSOPHY_RESEARCH.md**: I Ching × Eight Keys philosophical synthesis
  - Trigrams to Eight Keys mapping
  - Hexagram interpretations
  - Theoretical grounding
  - Uses Chinese characters (乾, 坎, 震) not romanized pinyin for authentic terminology

- **EQUATIONS_FOR_WORLD.md**: 17 equations from Ian Stewart's book
  - Used to demonstrate symbolic compression hypothesis
  - Added as reference material

- **BANG_COMMANDS.md**: Bang commands reference
  - Comprehensive documentation of all bang commands
  - Model-agnostic meta-operators and framework-specific commands
  - Usage patterns and integration with Eight Keys and OODA cycle
  - Quick reference for daily use

---
## Commit Strategy

### DO NOT Modify Upstream Files

**Rule (ZEROTH RULE)**: All changes must be in new files only. Upstream files preserved for merge compatibility.

See [Upstream File Constraint](#upstream-file-constraint-zeroth-rule) for complete enforcement with λ-calculus notation.

### File Categories

| Category | Files | Policy |
|----------|-------|--------|
| **Preserve Upstream** | All 32 upstream files (13 markdown + 2 skills + 19 ECA) | DO NOT MODIFY |
| **New Local Additions** | AGENTS.md, NUCLEUS_GUIDE.md, PHILOSOPHY_RESEARCH.md, EQUATIONS_FOR_WORLD.md, BANG_COMMANDS.md, LOCAL_CHANGES.md, skills/nucleus-tutor/SKILL.md, skills/sarcasmotron/SKILL.md | Modify freely |

### Example Commit

```bash
# Good: Add new file
git add NUCLEUS_GUIDE.md
git commit -m "Add Nucleus-specific practical guidance"

# Good: Modify new local file
git add AGENTS.md
git commit -m "Update framework with symbolic compression examples"

# BAD: Modify upstream file
git add README.md
git commit -m "Fix upstream README"  # ❌ Don't do this
```

---

## Merge Considerations

### When Upstream Updates

If upstream/main adds new files:

1. **Fetch upstream**: `git fetch upstream`
2. **Review changes**: Check what's new in upstream
3. **Don't modify upstream**: Keep upstream files as-is
4. **Add local docs**: Create new docs for any additions you need
5. **Update this file**: Add new comparisons

---

## Summary

**Core Principle**: Respect upstream structure, add value locally.

**ZEROTH RULE**: NEVER modify upstream files (see [Upstream File Constraint](#upstream-file-constraint-zeroth-rule))

- ✅ **DO**: Add new files (AGENTS.md, NUCLEUS_GUIDE.md, PHILOSOPHY_RESEARCH.md, etc.)
- ✅ **DO**: Modify new local files freely
- ✅ **DO**: Track changes in this file (LOCAL_CHANGES.md)
- ✅ **DO**: Test upstream sync before claiming readiness
- ✅ **DONE**: Upstream sync verified (no conflicts, clean merge, framework working) - last verified 2026-01-29; re-run verification steps in section 3 if date >30 days old
- ❌ **DON'T**: Modify upstream files (README.md, DIAG.md, SYMBOLIC_FRAMEWORK.md, etc.) → **INSTANT FAIL**
- ❌ **DON'T**: Delete upstream files
- ❌ **DON'T**: Submit changes that break upstream compatibility
- ❌ **DON'T**: Claim "ready for upstream sync" without testing

**Structure Compliance**: LOCAL_CHANGES.md follows AGENTS.md structure (fractal principle)

