# Pre-Commit Hook Setup Guide

**Date**: 2026-02-20
**Status**: ✅ **INSTALLED**

---

## Overview

The pre-commit hook automatically runs validation checks before each commit to ensure code quality and consistency.

**Current Mode**: Non-blocking (warns, doesn't block commits)

---

## What It Does

The pre-commit hook runs:

1. **Framework Validation** - Validates AGENTS.md and related docs
2. **Skills Validation** - Validates all 9 Nucleus skills

Both validations check for:
- Frontmatter completeness
- Framework headers
- Eight Keys tables
- Required sections
- Line counts
- Documentation links

---

## How It Works

### On Every Commit

When you run `git commit`, the hook automatically:

```bash
1. Runs framework validation
2. Runs skills validation
3. Shows validation output
4. Allows commit to proceed (non-blocking mode)
```

### Validation Output

**Successful**:
```
✅ All validations passed
🚀 Proceeding with commit...
```

**With Issues**:
```
⚠️  Framework validation has issues
🚀 Proceeding with commit...
💡 Tip: Review validation output above for any issues
```

---

## Installation Status

✅ **INSTALLED** at `.git/hooks/pre-commit`

The hook is:
- Executable (chmod +x)
- Non-blocking (warns but doesn't block)
- Runs both framework and skills validation

---

## Modes

### Mode 1: Non-Blocking (Current - Recommended)

**Behavior**: Runs validation, shows output, always allows commit

**Benefits**:
- Doesn't interrupt workflow
- Provides visibility into issues
- Allows quick fixes while committing

**When to use**: Day-to-day development

### Mode 2: Blocking (Optional)

**Behavior**: Runs validation, blocks commit if validation fails

**Benefits**:
- Enforces quality standards
- Prevents committing issues
- Guarantees compliance

**When to use**:
- Before releases
- Team shared repos
- High-quality codebases

### Switching Modes

**To switch to blocking mode**:
```bash
# Use the blocking version
cp .git/hooks/pre-commit.blocking .git/hooks/pre-commit
chmod +x .git/hooks/pre-commit
```

**To switch to non-blocking mode**:
```bash
# Use the non-blocking version
cp .git/hooks/pre-commit.nonblocking .git/hooks/pre-commit
chmod +x .git/hooks/pre-commit
```

---

## Bypassing Validation

**Temporary bypass** (not recommended):
```bash
git commit --no-verify -m "Your commit message"
```

**Permanent bypass** (not recommended):
```bash
# Remove the hook
rm .git/hooks/pre-commit
```

---

## Running Validation Manually

### Run Framework Validation

```bash
./validator/validator.sh
```

### Run Skills Validation

```bash
cd skills
./validate_skills.sh
```

### Run Both

```bash
./validator/validator.sh && cd skills && ./validate_skills.sh
```

---

## Troubleshooting

### Issue: Hook doesn't run

**Check**: Is the file executable?
```bash
ls -l .git/hooks/pre-commit
# Should show: -rwxr-xr-x
```

**Fix**: Make executable
```bash
chmod +x .git/hooks/pre-commit
```

### Issue: Hook always blocks

**Check**: Which version is installed?
```bash
cat .git/hooks/pre-commit | head -20
```

**Fix**: Switch to non-blocking version
```bash
cp .git/hooks/pre-commit.nonblocking .git/hooks/pre-commit
chmod +x .git/hooks/pre-commit
```

### Issue: Validators have errors

**Check**: Run validators manually
```bash
./validator/validator.sh
cd skills && ./validate_skills.sh
```

**Fix**: Address validation issues, then commit

---

## Customization

### Adding More Checks

Edit `.git/hooks/pre-commit` to add custom checks:

```bash
# Example: Add custom check
echo "Running custom validation..."
if [ ! -f "CUSTOM_FILE" ]; then
    echo "⚠️  CUSTOM_FILE missing"
fi
```

### Changing Validation Frequency

**Always run**: Keep as is
**Run only on certain files**: Add file check
```bash
# Only run if skills/ changed
if git diff --cached --name-only | grep -q "skills/"; then
    # Run skills validation
fi
```

---

## Best Practices

### 1. Review Validation Output

Before dismissing warnings:
- Read the full validation output
- Check for failed items
- Fix critical issues

### 2. Fix Issues Incrementally

Don't wait for perfect validation:
- Fix high-priority issues first
- Commit fixes
- Continue working

### 3. Use Bypass Sparingly

Only use `--no-verify` when:
- Urgent hotfix needed
- Validator has false positive
- Testing hook itself

---

## Integration with CI

### CI Pipeline

Add to CI (GitHub Actions, GitLab CI, etc.):

```yaml
- name: Validate Nucleus
  run: |
    ./validator/validator.sh
    cd skills && ./validate_skills.sh
```

CI validation is **always blocking** - builds fail if validation fails.

---

## Pre-Commit vs CI

| Aspect | Pre-Commit | CI |
|--------|------------|-----|
| **Timing** | Before each commit | On push/PR |
| **Mode** | Non-blocking | Blocking |
| **Purpose** | Developer awareness | Quality gate |
| **Coverage** | All commits | PR/main branch |

**Both recommended**: Use pre-commit for developer feedback, CI for quality gates.

---

## Success Metrics

| Metric | Target | Status |
|--------|--------|--------|
| Hook installed | ✓ | ✅ Complete |
| Hook executable | ✓ | ✅ Complete |
| Framework validation runs | ✓ | ✅ Complete |
| Skills validation runs | ✓ | ✅ Complete |
| Non-blocking mode | ✓ | ✅ Complete |

---

## Next Steps

1. ✅ **Pre-commit hook installed**
2. ✅ **Non-blocking mode enabled**
3. ⚠️ **Review validation output** before committing
4. ⚠️ **Fix issues incrementally**
5. 📚 **Read this guide** for customization

---

**Framework Version**: v0.2.0
**Last Updated**: 2026-02-20
**Hook Status**: ✅ **INSTALLED - Non-Blocking**
