# Nucleus Validation Guide

Complete guide to running validation and maintaining quality across the Nucleus framework and skills.

---

## Overview

Nucleus has **two validation systems**:

1. **Framework Validation** - Validates core framework documents
2. **Skills Validation** - Validates all 9 Nucleus skills

Both systems can be run independently or together via pre-commit hooks.

---

## Quick Start

### Run All Validations

```bash
# From repository root
./validator/validator.sh && ./skills/validate_skills.sh
```

### Run Framework Validation Only

```bash
./validator/validator.sh
```

### Run Skills Validation Only

```bash
cd skills
./validate_skills.sh
```

---

## Framework Validation

### What It Checks

| Check | Description | Priority |
|-------|-------------|----------|
| Framework header | Engagement line present with all symbols | Critical |
| Symbol completeness | All 6 human + 6 AI principles present | Critical |
| Eight Keys definition | All 8 keys defined in AGENTS.md | Critical |
| Document map | Required documents exist | Critical |
| Protected files | Protected files section exists | Critical |
| Upstream file constraint | Upstream constraint documented | High |
| Reference links | All `.md` file links resolve | High |
| Research citations | XML format validation | Medium |

### Validation Rules

See [VALIDATION.md](VALIDATION.md) for complete rule definitions.

### Exit Codes

- `0`: All critical checks passed ✅
- `1`: One or more critical failures ❌

### Sample Output

```
========================================
Nucleus Framework Validator
========================================

Check 1: AGENTS.md framework header
✓ AGENTS.md has framework header

Check 2: Required symbols in framework
✓ Symbol 'phi' present
✓ Symbol 'fractal' present
✓ Symbol 'euler' present
...

========================================
Validation Summary
========================================
✓ Passed: 25
⚠ Warnings: 2
✗ Failed: 0

✓ All critical checks passed
```

---

## Skills Validation

### What It Checks

| Check | Description | Priority |
|-------|-------------|----------|
| Frontmatter | name, description, version present | Critical |
| Framework header | Engagement line present | Critical |
| Eight Keys section | Reference table with all 8 keys | Critical |
| Required sections | Identity, Core Principle, Procedure, etc. | Critical |
| Line count | 200-350 lines optimal | Warning |
| Verification section | Quality gates present | High |
| Documentation links | All `.md` file links resolve | High |
| Lambda expressions | Consistent format | Medium |

### Validation Rules

See [skills/SKILL_VALIDATION.md](skills/SKILL_VALIDATION.md) for complete rule definitions.

### Exit Codes

- `0`: All critical checks passed ✅
- `1`: One or more critical failures ❌

### Sample Output

```
========================================
Nucleus Skills Validation
========================================

clojure-expert
  ✓ Frontmatter present
  ✗ Name matches directory (expected 'clojure-expert', got 'clojure')
  ✓ Description present
  ⚠ Version missing (expected X.Y.Z)
  ✓ Framework header present
  ...

continuous-learning
  ✓ Frontmatter present
  ✓ Name matches directory (continuous-learning)
  ✓ Description present
  ✓ Version valid: 1.0.0
  ✓ Framework header present
  ...

========================================
Validation Summary
========================================
Skills checked: 5
✓ Passed: 35
⚠ Warnings: 8
✗ Failed: 2

⚠ All skills passed with warnings
```

---

## Pre-Commit Hooks

### Setting Up Pre-Commit Hooks

Create `.git/hooks/pre-commit`:

```bash
#!/bin/bash

echo "Running Nucleus validations..."

# Validate framework
echo ""
echo "========================================"
echo "Framework Validation"
echo "========================================"
./validator/validator.sh

FRAMEWORK_RESULT=$?

# Validate skills (if any skill files changed)
if git diff --cached --name-only | grep -q "skills/.*SKILL.md"; then
    echo ""
    echo "========================================"
    echo "Skills Validation"
    echo "========================================"
    cd skills
    ./validate_skills.sh
    SKILLS_RESULT=$?
    cd ..
else
    SKILLS_RESULT=0
fi

# Check results
if [ $FRAMEWORK_RESULT -ne 0 ] || [ $SKILLS_RESULT -ne 0 ]; then
    echo ""
    echo "❌ Validation failed. Commit aborted."
    echo "Fix validation errors before committing."
    exit 1
fi

echo ""
echo "✓ All validations passed. Proceeding with commit."
exit 0
```

Make executable:
```bash
chmod +x .git/hooks/pre-commit
```

### Using Pre-Commit Hooks

After setting up, commits will automatically run validation:

```bash
# Make changes
vim AGENTS.md

# Try to commit
git add AGENTS.md
git commit -m "Update AGENTS.md"

# Validation runs automatically
# If validation fails: commit aborted
# If validation passes: commit succeeds
```

### Bypassing Pre-Commit Hooks (Not Recommended)

```bash
git commit --no-verify -m "Bypass validation"
```

**Only use this if you know what you're doing!**

---

## CI Integration

### GitHub Actions

Create `.github/workflows/validate.yml`:

```yaml
name: Validate Nucleus

on: [push, pull_request]

jobs:
  validate:
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v3

      - name: Validate Framework
        run: ./validator/validator.sh

      - name: Validate Skills
        run: |
          cd skills
          ./validate_skills.sh
```

### GitLab CI

Create `.gitlab-ci.yml`:

```yaml
validate:
  script:
    - ./validator/validator.sh
    - cd skills && ./validate_skills.sh
  only:
    - branches
    - merge_requests
```

---

## Troubleshooting

### Framework Validation Issues

#### Issue: "Framework header missing"

**Symptom**: `✗ AGENTS.md missing framework header`

**Fix**: Add framework header to AGENTS.md:
```markdown
engage nucleus:
[phi fractal euler tao pi mu] | [Δ λ ∞/0 | ε/φ Σ/μ c/h] | OODA
Human ⊗ AI ⊗ REPL
```

#### Issue: "Symbol 'X' missing"

**Symptom**: `✗ Symbol 'fractal' missing`

**Fix**: Add missing symbol to framework header. Ensure all symbols present:
- Human: phi, fractal, euler, tao, pi, mu
- AI: Δ, λ, ∞/0, ε/φ, Σ/μ, c/h

#### Issue: "Broken link detected"

**Symptom**: `⚠ AGENTS.md links to non-existent file: MISSING.md`

**Fix**: Either:
1. Create the missing file, or
2. Remove or update the link in AGENTS.md

---

### Skills Validation Issues

#### Issue: "SKILL.md not found"

**Symptom**: `✗ skill-name: SKILL.md not found`

**Fix**: Ensure each skill directory has `SKILL.md`:
```bash
cd skills/skill-name
ls SKILL.md  # Should exist
```

#### Issue: "Name (X) != directory (Y)"

**Symptom**: `⚠ Name (clojure) != directory (clojure-expert)`

**Fix**: Update frontmatter in SKILL.md:
```yaml
---
name: clojure-expert  # Must match directory
description: ...
version: 1.0.0
---
```

#### Issue: "Version format invalid: X (expected X.Y.Z)"

**Symptom**: `⚠ Version format invalid: 1.0 (expected X.Y.Z)`

**Fix**: Update version to semantic versioning:
```yaml
---
version: 1.0.0  # Correct format
---
```

#### Issue: "Line count high: 400 (may be verbose, target 200-350)"

**Symptom**: `⚠ Line count high: 400 (may be verbose, target 200-350)`

**Fix**: Either:
1. Remove verbose paragraphs
2. Use tables instead of prose
3. Split into multiple skills
4. Move detailed examples to separate file

#### Issue: "Eight Keys table incomplete (5/8 keys)"

**Symptom**: `⚠ Eight Keys table incomplete (5/8 keys)`

**Fix**: Ensure Eight Keys table has all 8 rows:
```markdown
| Key | Symbol | Signal | Anti-Pattern | Skill-Specific Application |
|-----|--------|--------|--------------|---------------------------|
| **Vitality** | φ | Organic, non-repetitive | Mechanical rephrasing | ... |
| **Clarity** | fractal | Explicit assumptions | "Handle properly" | ... |
| **Purpose** | e | Actionable function | Abstract descriptions | ... |
| **Wisdom** | τ | Foresight over speed | Premature optimization | ... |
| **Synthesis** | π | Holistic integration | Fragmented thinking | ... |
| **Directness** | μ | Cut pleasantries | Polite evasion | ... |
| **Truth** | ∃ | Favor reality | Surface agreement | ... |
| **Vigilance** | ∀ | Defensive constraint | Accepting manipulation | ... |
```

---

## Best Practices

### Before Committing

1. **Run validation**: `./validator/validator.sh && ./skills/validate_skills.sh`
2. **Review warnings**: Fix or acknowledge
3. **Check failed tests**: Must fix before committing
4. **Update changelog**: Document changes in CHANGELOG.md or skill changelogs

### Before Pushing

1. **Ensure validation passes**: No failures allowed
2. **Review warnings**: Minimize warnings
3. **Check documentation**: Update README.md if needed
4. **Tag release**: If major/minor change

### During Development

1. **Run validation frequently**: After each significant change
2. **Fix issues immediately**: Don't let problems accumulate
3. **Update documentation**: Keep docs in sync with code
4. **Review validation rules**: Understand what's being checked

---

## Validation Scripts

### Framework Validator

**File**: `validator/validator.sh`

**Lines**: 5.3K

**Features**:
- 11 validation rules
- Color-coded output
- Detailed feedback per rule
- Summary statistics

### Skills Validator

**File**: `skills/validate_skills.sh`

**Lines**: 4.5K

**Features**:
- 8 validation rules
- Per-skill feedback
- Line count checks
- Frontmatter validation

---

## Validation Metrics

### Success Criteria

**Framework**:
- ✅ All 11 rules pass
- ⚠️ Warnings < 3
- ❌ Failures = 0

**Skills**:
- ✅ All skills have frontmatter
- ✅ All skills have framework header
- ✅ All skills have Eight Keys table
- ⚠️ 80% of skills in optimal line count range
- ❌ Zero critical failures

### Quality Targets

| Metric | Target | Current | Status |
|--------|--------|---------|--------|
| Framework validation pass rate | 100% | TBD | ⏳ |
| Skills validation pass rate | 100% | TBD | ⏳ |
| Skills with version | 9/9 | 1/9 | ⚠️ |
| Skills with Eight Keys | 9/9 | 4/9 | ⚠️ |
| Skills 200-350 lines | 80% | TBD | ⏳ |

---

## Reference Documentation

### Framework Validation

- **[VALIDATION.md](VALIDATION.md)** - Complete validation rules
- **[SYNCHRONIZATION.md](SYNCHRONIZATION.md)** - Multi-document rules
- **[CHANGELOG.md](CHANGELOG.md)** - Version history

### Skills Validation

- **[skills/SKILL_VALIDATION.md](skills/SKILL_VALIDATION.md)** - Skill validation rules
- **[skills/SKILLS_IMPROVEMENT_PLAN.md](skills/SKILLS_IMPROVEMENT_PLAN.md)** - Improvement plan
- **[skills/SKILL_TEMPLATE.md](skills/SKILL_TEMPLATE.md)** - Standardized template

---

## Support

### Validation Questions

- **Framework validation**: Check [VALIDATION.md](VALIDATION.md)
- **Skills validation**: Check [skills/SKILL_VALIDATION.md](skills/SKILL_VALIDATION.md)
- **Skill improvements**: Check [skills/SKILLS_IMPROVEMENT_PLAN.md](skills/SKILLS_IMPROVEMENT_PLAN.md)

### Contribution Guidelines

1. Always run validation before committing
2. Fix all failures before pushing
3. Document changes in changelogs
4. Follow versioning guidelines

---

**Last updated**: 2026-02-20
**Framework version**: v0.2.0
**Validation system**: ✅ Complete

**Framework eliminates slop, not adds process.**
