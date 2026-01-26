# README.md Local Additions

> ⚠️ **ZEROTH RULE VIOLATION FIX**
>
> README.md is an upstream file (exists in upstream/main).
> This file documents local additions that WOULD BE in README.md if we could modify it.
>
> See [AGENTS.md](AGENTS.md#upstream-file-constraint-zeroth-rule) for ZEROTH RULE details.
> See [LOCAL_CHANGES.md](LOCAL_CHANGES.md) for complete upstream vs local tracking.

---

## Broken Reference in Upstream README.md

### Issue: GUIDE_INDEX.md Reference

**Original README.md (upstream)** contains:
```markdown
### Learning Path
1. **Start with** [GUIDE_INDEX.md](GUIDE_INDEX.md) to understand the documentation ecosystem
```

**Current Status**: GUIDE_INDEX.md has been deleted (merged into NUCLEUS_GUIDE.md).

**Impact**: README.md has a broken link to non-existent file.

---

## Intended README.md Changes (If We Could Modify)

### 1. Update Learning Path

```markdown
### Learning Path
1. **Start with** [NUCLEUS_GUIDE.md](NUCLEUS_GUIDE.md) for framework basics and documentation overview
2. **Read** [AGENTS.md](AGENTS.md) for formal framework specification
3. **Apply** [ZH_GUIDE.md](ZH_GUIDE.md) for implementation with code examples (Chinese)
4. **Understand theory** with [PHILOSOPHY_RESEARCH.md](PHILOSOPHY_RESEARCH.md) for I Ching cosmology
```

**Why**: GUIDE_INDEX.md deleted, NUCLEUS_GUIDE.md now serves as documentation hub.

### 2. Update Documentation Section

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

**Why**: NUCLEUS_GUIDE.md now contains what was in GUIDE_INDEX.md.

---

## Alternative Solutions (Without Modifying Upstream)

### Option 1: Accept Broken Reference

**Approach**: Leave README.md as-is, accept that GUIDE_INDEX.md link is broken.

**Pros**:
- Respects ZEROTH RULE
- No maintenance burden
- Upstream may fix it eventually

**Cons**:
- Users click broken link
- Poor experience

### Option 2: Submit PR to Upstream

**Approach**: Submit pull request to upstream/michaelwhitford/nucleus updating README.md.

**Pros**:
- Fixes issue permanently
- Benefits all users

**Cons**:
- Requires upstream maintainer approval
- Upstream may have different vision

### Option 3: Create Local README (Not Recommended)

**Approach**: Create README_LOCAL.md with corrected version.

**Pros**:
- Can fix broken reference
- Local control

**Cons**:
- Confusing (two README files)
- Violates spirit of ZEROTH RULE (don't duplicate upstream)

---

## Recommended Approach

**Submit PR to upstream**:

1. Fork upstream (if not already)
2. Update README.md learning path to point to NUCLEUS_GUIDE.md
3. Submit PR with rationale:
   - "GUIDE_INDEX.md merged into NUCLEUS_GUIDE.md for better integration"
   - "Update learning path to reflect current structure"
4. Track PR status in LOCAL_CHANGES.md

---

## Current Tracking

**Last Updated**: 2025-01-14

**Actions Taken**:
1. ✅ Deleted GUIDE_INDEX.md (merged into NUCLEUS_GUIDE.md)
2. ✅ Merged content to NUCLEUS_GUIDE.md (+100 lines)
3. ✅ Updated NUCLEUS_GUIDE.md with documentation ecosystem
4. ✅ Updated LOCAL_CHANGES.md (removed GUIDE_INDEX.md references)
5. ✅ Reset README.md to upstream version (ZEROTH RULE compliance)
6. ✅ Created this file to track intended README changes

**Pending**:
- ⏸️ Submit PR to upstream for README.md update

---

*This file documents local additions to README.md that cannot be applied due to ZEROTH RULE.*
