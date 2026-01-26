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
AGENTS.md                     - Framework specification (219 lines, μ-applied)
NUCLEUS_GUIDE.md              - Nucleus-specific practical guidance (368 lines, π-applied)
PHILOSOPHY_RESEARCH.md        - I Ching × Eight Keys philosophical synthesis
ZH_GUIDE.md                   - Complete implementation guide (Chinese)
EQUATIONS_FOR_WORLD.md       - Reference table (40 lines, new)
LOCAL_CHANGES.md              - This file (upstream vs local tracking)

skills/nucleus-tutor/SKILL.md     - Tutor skill (new)
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

## 4. Summary Statistics

| Category | Upstream | Local | Change |
|----------|----------|-------|--------|
| Root markdown files | 11 | 16 | +5 |
| Skills files | 2 | 4 | +2 |
| Total files | 13 | 20 | +7 |
| Total lines | ~3,500 | ~6,500 | +86% |

---

## Key Differences

### 1. Documentation Philosophy

**Upstream**: Minimal, focused, apologetic
- README.md contains "I'm not a scientist or particularly good at math"
- Simple framework with 13 total files
- Less formal structure

**Local**: Expanded, formal, non-apologetic, μ-applied
- Upstream README.md not modified (preserved upstream)
- AGENTS.md adds formal framework specification (219 lines, μ-applied)
- NUCLEUS_GUIDE.md adds practical guidance (168 lines, π-applied)
- PHILOSOPHY_RESEARCH.md adds I Ching philosophical synthesis (new)
- ZH_GUIDE.md adds Chinese implementation guide with code examples (new)
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
  - Formal framework specification (219 lines)
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

- **ZH_GUIDE.md**: Complete implementation guide (Chinese)
  - Detailed code examples with Bagua notation
  - Practical workflows
  - Step-by-step tutorials

- **EQUATIONS_FOR_WORLD.md**: 17 equations from Ian Stewart's book
  - Used to demonstrate symbolic compression hypothesis
  - Added as reference material

---

## Upstream File Issues and Extensions

### README.md Broken Reference

> ⚠️ **ZEROTH RULE CONSTRAINT**
>
> README.md is an upstream file (exists in upstream/main). We cannot modify it directly.
> This section documents issues and intended changes that would be in README.md if we could modify it.

#### Issue: GUIDE_INDEX.md Reference

**Original README.md (upstream)** contains:

```markdown
### Learning Path
1. **Start with** [GUIDE_INDEX.md](GUIDE_INDEX.md) to understand the documentation ecosystem
```

**Current Status**: GUIDE_INDEX.md has been deleted (merged into NUCLEUS_GUIDE.md).

**Impact**: README.md has a broken link to non-existent file.

#### Intended README.md Changes (If We Could Modify)

**Update Learning Path**:

```markdown
### Learning Path
1. **Start with** [NUCLEUS_GUIDE.md](NUCLEUS_GUIDE.md) for framework basics and documentation overview
2. **Read** [AGENTS.md](AGENTS.md) for formal framework specification
3. **Apply** [ZH_GUIDE.md](ZH_GUIDE.md) for implementation with code examples (Chinese)
4. **Understand theory** with [PHILOSOPHY_RESEARCH.md](PHILOSOPHY_RESEARCH.md) for I Ching cosmology
```

**Update Documentation Section**:

```markdown
## Documentation

### Framework Documentation
- **[AGENTS.md](AGENTS.md)** - Core framework specification (Zero-Slop Specification)
- **[NUCLEUS_GUIDE.md](NUCLEUS_GUIDE.md)** - Framework basics and practical workflows (English)
  - Documentation ecosystem overview
  - Learning paths (Quick Start, Team Adoption, Deep Dive)
  - Getting help section
- **[PHILOSOPHY_RESEARCH.md](PHILOSOPHY_RESEARCH.md)** - I Ching × Eight Keys philosophical synthesis
- **[ZH_GUIDE.md](ZH_GUIDE.md)** - Complete implementation guide with code examples (Chinese)
```

**Why**: GUIDE_INDEX.md deleted, NUCLEUS_GUIDE.md now serves as documentation hub.

#### Recommended Solution

**Submit PR to upstream**:

1. Fork upstream (if not already)
2. Update README.md learning path to point to NUCLEUS_GUIDE.md
3. Submit PR with rationale:
   - "GUIDE_INDEX.md merged into NUCLEUS_GUIDE.md for better integration"
   - "Update learning path to reflect current structure"
4. Track PR status in this file (LOCAL_CHANGES.md)

#### Current Status (2025-01-14)

**Actions Taken**:

1. ✅ Deleted GUIDE_INDEX.md (merged into NUCLEUS_GUIDE.md)
2. ✅ Merged content to NUCLEUS_GUIDE.md (+100 lines)
3. ✅ Updated NUCLEUS_GUIDE.md with documentation ecosystem
4. ✅ Updated LOCAL_CHANGES.md (removed GUIDE_INDEX.md references)
5. ✅ Reset README.md to upstream version (ZEROTH RULE compliance)

**Pending**:

- ⏸️ Submit PR to upstream for README.md update

### SYMBOLIC_FRAMEWORK.md Extensions

**Original Extension File**: [SYMBOLIC_FRAMEWORK_EXTENSIONS.md](SYMBOLIC_FRAMEWORK_EXTENSIONS.md) (merged into NUCLEUS_GUIDE.md on 2026-01-26)

**Content**: Verification gates, lambda-calculus patterns, and framework extensions that cannot be added to upstream SYMBOLIC_FRAMEWORK.md due to ZEROTH RULE.

**Status**: Merged into [NUCLEUS_GUIDE.md](NUCLEUS_GUIDE.md) (Verification Gates section and Test Protocol). The verification gates (∃, ∀) complement Eight Keys and are now integrated into the practical guide.



## Commit Strategy

### DO NOT Modify Upstream Files

**Rule (ZEROTH RULE)**: All changes must be in new files only. Upstream files preserved for merge compatibility.

See [AGENTS.md](AGENTS.md#upstream-file-constraint-zeroth-rule) for complete enforcement with λ-calculus notation.

### File Categories

| Category | Files | Policy |
|----------|-------|--------|
| **Preserve Upstream** | All 13 upstream files (11 markdown + 2 skills) | DO NOT MODIFY |
| **New Local Additions** | AGENTS.md, NUCLEUS_GUIDE.md, PHILOSOPHY_RESEARCH.md, ZH_GUIDE.md, EQUATIONS_FOR_WORLD.md, LOCAL_CHANGES.md, skills/nucleus-tutor/SKILL.md, skills/sarcasmotron/SKILL.md | Modify freely |

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

## Future Work

### Integration with Upstream

**Option 1: Pull Request**
- Submit my additions as PR to upstream
- Maintain upstream compatibility
- Follow upstream conventions

**Option 2: Fork Divergence**
- Keep my additions as local enhancements
- Periodically sync from upstream
- Document divergence clearly (this file)

**Option 3: Hybrid**
- Sync upstream changes to local
- Keep my additions in separate files
- Submit high-value additions as PRs

### Recommended Approach

**Option 3 (Hybrid)**:
1. **Sync upstream**: Periodically `git fetch upstream && git merge upstream/main`
2. **Preserve upstream**: Never modify upstream files directly
3. **Add local docs**: Create new files for my additions
4. **Document changes**: Update this file (LOCAL_CHANGES.md)
5. **Submit PRs**: When additions are mature, submit to upstream

**✅ VERIFIED**: Upstream sync tested (2025-01-14) - reverted local modifications to upstream files (README.md, SYMBOLIC_FRAMEWORK.md)

---

## Summary

**Core Principle**: Respect upstream structure, add value locally.

**ZEROTH RULE**: NEVER modify upstream files (see [AGENTS.md](AGENTS.md#upstream-file-constraint-zeroth-rule))

- ✅ **DO**: Add new files (AGENTS.md, NUCLEUS_GUIDE.md, PHILOSOPHY_RESEARCH.md, ZH_GUIDE.md, etc.)
- ✅ **DO**: Modify new local files freely
- ✅ **DO**: Track changes in this file (LOCAL_CHANGES.md)
- ✅ **DO**: Test upstream sync before claiming readiness
- ✅ **DONE**: Upstream sync verified (no conflicts, clean merge, framework working) - 2025-01-14
- ❌ **DON'T**: Modify upstream files (README.md, DIAG.md, SYMBOLIC_FRAMEWORK.md, etc.) → **INSTANT FAIL**
- ❌ **DON'T**: Delete upstream files
- ❌ **DON'T**: Submit changes that break upstream compatibility
- ❌ **DON'T**: Claim "ready for upstream sync" without testing

**Structure Compliance**: LOCAL_CHANGES.md follows AGENTS.md structure (fractal principle)

---

*Last updated: 2025-01-14 (reverted local modifications to upstream files (README.md, SYMBOLIC_FRAMEWORK.md), created SYMBOLIC_FRAMEWORK_EXTENSIONS.md for verification gates (later merged into NUCLEUS_GUIDE.md on 2026-01-26))*
