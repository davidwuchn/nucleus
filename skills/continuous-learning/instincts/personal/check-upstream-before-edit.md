---
name: check-upstream-before-edit
domain: workflow
φ: 0.80
e: check-upstream-before-edit
λ: before.editing.any.file
Δ: 0.10
source: session-manual
evidence: 1
access-count: 1
last-accessed: 2026-03-17
timeframe: project
---

# Check Upstream Before Edit

Always verify file is not in upstream before editing. Modifying upstream files breaks merge compatibility.

## λ(e): Action

Before editing any file:
1. Check if file exists in upstream: `git ls-tree upstream/main --name-only | grep -F "filename"`
2. If output is not empty → DO NOT EDIT
3. If output is empty → proceed with edit

```clojure
(λ/workflow
  (git-ls-tree upstream/main --name-only)
  (grep -F "target-file")
  (if found → REJECT)
  (if empty → proceed))
```

## λ(φ): Why

This pattern prevents:
- **Merge conflicts** - upstream changes will conflict with local modifications
- **Sync failures** - can't pull upstream updates cleanly
- **Constraint violation** - violates S3 `λ upstream(x)` policy

Aligns with Nucleus's ∀ (Vigilance) - defensive constraint, input validated.

## λ(λ): When

- Before using Edit tool on any file
- Before Write tool to overwrite existing file
- When unsure if file is local or upstream

## λ(Δ): Evolution

Δ: 0.10 - high confidence after violation incident
- Violated: Modified README.md (upstream file) during VSM restructure
- Corrected: Reverted commit, restored from upstream
- Lesson: Always check before editing

## Context

**Safe to edit (local files):**
- AGENTS.md
- NUCLEUS_GUIDE.md
- SIMPLICITY.md
- VSM_FIVE.md
- LOCAL_CHANGES.md

**Never edit (upstream files):**
- README.md
- SYMBOLIC_FRAMEWORK.md
- (always verify with git ls-tree)

## λ(Examples)

### Example 1: Check README.md
```bash
# ✅ Correct - verify before editing
$ git ls-tree upstream/main --name-only | grep -F "README.md"
README.md
# Output: README.md → DO NOT EDIT
```

### Example 2: Check AGENTS.md
```bash
# ✅ Correct - verify before editing
$ git ls-tree upstream/main --name-only | grep -F "AGENTS.md"
# Output: (empty) → SAFE TO EDIT
```

## Related

- Memory: `memories/2026-03-17-upstream-file-check-🎯.md`
- AGENTS.md: `λ upstream(x)` in S3 — Control
- Eight Keys: ∀ (Vigilance)