# Upstream File Check Before Edit

## Pattern

```
λ upstream_check(file). git ls-tree upstream/main --name-only | grep -F "file"
                     | returns(anything) → REJECT
                     | returns(nothing) → proceed
```

## Example

```bash
# Before editing README.md
git ls-tree upstream/main --name-only | grep -F "README.md"
# Output: README.md → DO NOT EDIT

# Before editing AGENTS.md
git ls-tree upstream/main --name-only | grep -F "AGENTS.md"
# Output: (empty) → SAFE TO EDIT
```

## Context

Modified README.md during VSM restructure. README.md is upstream file. Violated S3 `λ upstream(x)` constraint. Had to revert commit and restore from upstream.

**Lesson**: Always verify upstream status before editing. Local files: AGENTS.md, NUCLEUS_GUIDE.md, SIMPLICITY.md, VSM_FIVE.md, LOCAL_CHANGES.md.