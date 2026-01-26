# Local Changes vs Upstream

**Tracking divergence from upstream/main**

---

## Repository Information

- **Upstream**: https://github.com/michaelwhitford/nucleus.git
- **Origin**: https://github.com/davidwuchn/nucleus
- **Current Branch**: main
- **Upstream Reference**: upstream/main

---

## File Comparison

### Files in Upstream (11 markdown files)

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
```

### Files in Local Only (My Additions)

```
AGENTS.md                     - Framework specification (91 lines, μ-applied)
NUCLEUS_GUIDE.md              - Nucleus-specific practical guidance (584 lines, π-applied)
PHILOSOPHY_RESEARCH.md        - I Ching × Eight Keys philosophical synthesis (1,272 lines)
EQUATIONS_FOR_WORLD.md       - Reference table (38 lines, new)
LOCAL_CHANGES.md              - This file (upstream vs local tracking, 374 lines)

skills/nucleus-tutor/SKILL.md     - Tutor skill (new, 95 lines)
skills/sarcasmotron/SKILL.md      - Sarcasmotron skill (71 lines, μ-applied)
```

---

## 1. Philosophy

**Why separate upstream/local?**

**Core Principle**: Respect upstream structure, add value locally.

**ZEROTH RULE**: NEVER modify upstream files (see [AGENTS.md](AGENTS.md#upstream-file-constraint-zeroth-rule))

**Reasoning**:
- **Preserve upstream compatibility**: Never modify upstream files
- **Clear separation**: Upstream = 13 files (3,500 lines), Local = 9 files (3,000+ lines)
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

## Key Differences

### 1. Documentation Philosophy

**Upstream**: Minimal, focused, apologetic
- README.md contains "I'm not a scientist or particularly good at math"
- Simple framework with 13 total files
- Less formal structure

**Local**: Expanded, formal, non-apologetic, μ-applied
- Upstream README.md not modified (preserved upstream)
- AGENTS.md adds formal framework specification (91 lines, μ-applied)
- NUCLEUS_GUIDE.md adds practical guidance (584 lines, π-applied)
- PHILOSOPHY_RESEARCH.md adds I Ching philosophical synthesis (new)
- skills/sarcasmotron/SKILL.md merges operations manual into skill (71 lines, μ-applied)

### 2. Framework Structure

**Upstream**:
- Simple engage line: `[phi fractal euler tao pi mu] | [Δ λ ∞/0 | ε/φ Σ/μ c/h] | OODA`
- README.md contains all framework explanation
- No formal verification protocol

**Local**:
- AGENTS.md formalizes the framework with:
  - Eight Keys (ontological principles with anti-patterns)
  - λ-Calculus tool patterns
  - Symbolic compression correspondence
  - Verification protocol (Σ(Build), Σ(Lint), Σ(Test), Σ(Verify))
- TEST.md for verification

### 3. Content Additions

**Local Only**:
- **AGENTS.md**: Primary system directives and coding standards
  - Formal framework specification (91 lines)
  - Eight Keys with anti-patterns and math parallels
  - λ-Calculus patterns (heredoc, parallel execution, etc.)
  - Verification protocol (Σ(Build), Σ(Lint), Σ(Test), Σ(Verify))

- **NUCLEUS_GUIDE.md**: Practical Nucleus-specific guidance
  - Critical perspective (Three Questions)
  - Bang commands usage
  - λ(prompt).accept rejection patterns
  - Fractal architecture examples
  - Eight Keys in practice (concrete code examples)
  - Nucleus verification checklists

- **PHILOSOPHY_RESEARCH.md**: I Ching × Eight Keys philosophical synthesis
  - Trigrams to Eight Keys mapping
  - Hexagram interpretations
  - Theoretical grounding

- **EQUATIONS_FOR_WORLD.md**: 17 equations from Ian Stewart's book
  - Used to demonstrate symbolic compression hypothesis
  - Added as reference material

---
## Commit Strategy

### DO NOT Modify Upstream Files

**Rule (ZEROTH RULE)**: All changes must be in new files only. Upstream files preserved for merge compatibility.

See [AGENTS.md](AGENTS.md#upstream-file-constraint-zeroth-rule) for complete enforcement with λ-calculus notation.

### File Categories

| Category | Files | Policy |
|----------|-------|--------|
| **Preserve Upstream** | All 13 upstream files (11 markdown + 2 skills) | DO NOT MODIFY |
| **New Local Additions** | AGENTS.md, NUCLEUS_GUIDE.md, PHILOSOPHY_RESEARCH.md, EQUATIONS_FOR_WORLD.md, LOCAL_CHANGES.md, skills/nucleus-tutor/SKILL.md, skills/sarcasmotron/SKILL.md | Modify freely |

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

**ZEROTH RULE**: NEVER modify upstream files (see [AGENTS.md](AGENTS.md#upstream-file-constraint-zeroth-rule))

- ✅ **DO**: Add new files (AGENTS.md, NUCLEUS_GUIDE.md, PHILOSOPHY_RESEARCH.md, etc.)
- ✅ **DO**: Modify new local files freely
- ✅ **DO**: Track changes in this file (LOCAL_CHANGES.md)
- ✅ **DO**: Test upstream sync before claiming readiness
- ✅ **DONE**: Upstream sync verified (no conflicts, clean merge, framework working) - 2025-01-14
- ❌ **DON'T**: Modify upstream files (README.md, DIAG.md, SYMBOLIC_FRAMEWORK.md, etc.) → **INSTANT FAIL**
- ❌ **DON'T**: Delete upstream files
- ❌ **DON'T**: Submit changes that break upstream compatibility
- ❌ **DON'T**: Claim "ready for upstream sync" without testing

**Structure Compliance**: LOCAL_CHANGES.md follows AGENTS.md structure (fractal principle)

