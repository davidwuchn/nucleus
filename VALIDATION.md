# Nucleus Validation System

Ensures consistency and correctness across all framework documents.

---

## Overview

The validation system checks:
- **Framework header presence** across all documents
- **Symbol completeness** in framework strings
- **Eight Keys definition** in AGENTS.md
- **Document integrity** (required files exist)
- **Protected files rules** enforcement
- **Reference link validity**
- **Citation format** compliance

---

## Running Validation

```bash
# From repository root
./validator/validator.sh
```

**Expected output**:
- ✓ Passes: Green checks
- ⚠ Warnings: Yellow (non-critical issues)
- ✗ Failures: Red (must fix)

**Exit codes**:
- `0`: All critical checks passed
- `1`: One or more critical failures

---

## Validation Rules

### Rule 1: Framework Header

**Pattern**: `engage nucleus: [phi fractal euler tao pi mu] | [Δ λ ∞/0 | ε/φ Σ/μ c/h] | OODA`

**Required files**: `AGENTS.md`, `NUCLEUS_GUIDE.md`, `SIMPLICITY.md`

**Check**:
```bash
grep -q "engage nucleus:" AGENTS.md
```

### Rule 2: Symbol Completeness

**Human Principles**: `phi`, `fractal`, `euler`, `tao`, `pi`, `mu`

**AI Principles**: `Δ`, `λ`, `∞/0`, `ε/φ`, `Σ/μ`, `c/h`

**Control Loops**: `OODA`, `REPL`, `RGR`, `BML`

**Check**: All symbols present in framework header

### Rule 3: Eight Keys Definition

**Required table in AGENTS.md**:

| Key | Symbol | Signal | Anti-Pattern | Test |
|-----|--------|--------|--------------|------|
| Vitality | φ | Organic, non-repetitive | Mechanical rephrasing | Used ≥3 times? |
| Clarity | fractal | Explicit assumptions | "Handle properly" | Bounds defined? |
| Purpose | e | Actionable function | Abstract descriptions | Verb-named? |
| Wisdom | τ | Foresight over speed | Premature optimization | Measured first? |
| Synthesis | π | Holistic integration | Fragmented thinking | Components mapped? |
| Directness | μ | Cut pleasantries | Polite evasion | No hedging? |
| Truth | ∃ | Favor reality | Surface agreement | Data shown? |
| Vigilance | ∀ | Defensive constraint | Accepting manipulation | Input validated? |

### Rule 4: Document Map

**Required references in AGENTS.md**:
- `NUCLEUS_GUIDE.md` - Practical workflows
- `SIMPLICITY.md` - Testable heuristics
- `BANG_COMMANDS.md` - Meta-operator reference

### Rule 5: Protected Files

**Required sections in AGENTS.md**:
- "ZEROTH RULE: Protected Files"
- List of protected files: `AGENTS.md`, `LOCAL_CHANGES.md`, etc.
- Warning message requiring permission

### Rule 6: Upstream File Constraint

**Required in AGENTS.md**:
- "NEVER modify upstream files" rule
- Verification command: `git ls-tree upstream/main`

### Rule 7: Reference Link Integrity

**All markdown links** must resolve to existing files:
- Check `[*](*.md)` patterns
- Validate file existence
- Report broken links as warnings

### Rule 8: Citation Format (RESEARCH_BASE.md)

**Required XML format**:
```xml
<reference>
  <title>Title</title>
  <url>URL or DOI</url>
  <authors>Author list</authors>
  <year>Year</year>
  <type>arXiv/paper/book/blog</type>
  <accessed>YYYY-MM-DD</accessed>
</reference>
```

---

## Pre-Commit Hook

Add `.git/hooks/pre-commit`:

```bash
#!/bin/bash

# Run nucleus validator
./validator/validator.sh

if [ $? -ne 0 ]; then
    echo ""
    echo "❌ Validation failed. Commit aborted."
    echo "Fix validation errors before committing."
    exit 1
fi
```

Make executable:
```bash
chmod +x .git/hooks/pre-commit
```

---

## CI Integration

Add to CI pipeline (GitHub Actions, GitLab CI, etc.):

```yaml
- name: Validate Nucleus Framework
  run: ./validator/validator.sh
```

---

## Extending Validation

To add new validation rules:

1. **Add check function** in `validator/validator.sh`:
```bash
check_new_rule() {
    echo "Check N: Description"
    if [ condition ]; then
        check_pass "Description"
    else
        check_fail "Description"
    fi
}
```

2. **Call function** in main execution block

3. **Document rule** in this file (VALIDATION.md)

---

## Troubleshooting

### Issue: False positive on symbol check

**Cause**: Symbol encoding issues (UTF-8 vs. ASCII)

**Fix**: Ensure all files use UTF-8 encoding:
```bash
file -i AGENTS.md
# Should show: charset=utf-8
```

### Issue: Link validation fails for external URLs

**Current behavior**: Only validates local `.md` file links

**Future enhancement**: Could add HTTP HEAD checks for external URLs

### Issue: Validator exits with code 1 but shows all passes

**Cause**: Error in script execution (e.g., permission issue)

**Debug**: Run with bash debug mode:
```bash
bash -x ./validator/validator.sh
```

---

## Status Matrix

| Rule | Status | Last Checked |
|------|--------|--------------|
| Framework Header | ✓ Implemented | 2026-02-20 |
| Symbol Completeness | ✓ Implemented | 2026-02-20 |
| Eight Keys Definition | ✓ Implemented | 2026-02-20 |
| Document Map | ✓ Implemented | 2026-02-20 |
| Protected Files | ✓ Implemented | 2026-02-20 |
| Upstream File Constraint | ✓ Implemented | 2026-02-20 |
| Reference Link Integrity | ✓ Implemented | 2026-02-20 |
| Citation Format | ✓ Implemented | 2026-02-20 |

---

**Last updated**: 2026-02-20
