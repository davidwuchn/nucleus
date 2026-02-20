# Pre-Commit Hook - Complete Setup

**Date**: 2026-02-20
**Status**: ✅ **COMPLETE - INSTALLED**

---

## Executive Summary

Pre-commit hook successfully installed at `.git/hooks/pre-commit`.

**Current Mode**: ✅ **Non-blocking** (warns, doesn't block commits)

**Alternative Mode**: ✅ **Blocking** available (see below)

---

## What Was Installed

### 1. Pre-Commit Hook

**Location**: `.git/hooks/pre-commit` (non-blocking mode)

**Features**:
- ✅ Runs framework validation on every commit
- ✅ Runs skills validation on every commit
- ✅ Shows validation output
- ✅ Allows commit to proceed (non-blocking)
- ✅ Provides tips for fixing issues

### 2. Alternative Hook Versions

**Non-blocking version** (current):
- `.git/hooks/pre-commit` (symlink to non-blocking)
- `.git/hooks/pre-commit.nonblocking` (standalone copy)

**Blocking version** (alternative):
- `.git/hooks/pre-commit.blocking` (standalone copy)

### 3. Documentation

**Created**:
- [PRE_COMMIT_HOOK_GUIDE.md](PRE_COMMIT_HOOK_GUIDE.md) - Complete setup guide

---

## How It Works

### On Every Commit

```bash
1. git commit
2. Pre-commit hook runs
3. Framework validation executes
4. Skills validation executes
5. Results displayed
6. Commit proceeds (non-blocking mode)
```

### Validation Checks

**Framework Validation**:
- AGENTS.md framework header
- Required symbols present
- Eight Keys defined
- Document map references
- Protected files section
- Upstream file constraint
- Symbol tables
- Meta Operators documented
- Research citations format
- Documentation links resolve

**Skills Validation**:
- Frontmatter present (all 9 skills)
- Name matches directory
- Description present
- Version present (X.Y.Z format)
- Framework header present
- Eight Keys section present
- Required sections present
- Line count optimal (200-350)

---

## Using the Pre-Commit Hook

### Daily Development (Recommended)

**Current mode**: Non-blocking

```bash
# Normal commit - validation runs but doesn't block
git add .
git commit -m "Your commit message"

# Validation runs, shows output, allows commit
```

**Benefits**:
- Doesn't interrupt workflow
- Provides visibility into issues
- Allows incremental fixes

### Before Releases (Optional)

**Switch to blocking mode**:

```bash
# Use blocking version
cp .git/hooks/pre-commit.blocking .git/hooks/pre-commit
chmod +x .git/hooks/pre-commit

# Now commit will be blocked if validation fails
git add .
git commit -m "Release commit"
```

**Benefits**:
- Enforces quality standards
- Prevents committing issues
- Guarantees compliance before release

### Bypassing Validation (Not Recommended)

```bash
# Temporary bypass
git commit --no-verify -m "Hotfix"

# Permanent bypass (not recommended)
rm .git/hooks/pre-commit
```

---

## Switching Modes

### To Switch to Blocking Mode

```bash
cp .git/hooks/pre-commit.blocking .git/hooks/pre-commit
chmod +x .git/hooks/pre-commit

echo "✓ Switched to blocking mode"
```

### To Switch to Non-Blocking Mode

```bash
cp .git/hooks/pre-commit.nonblocking .git/hooks/pre-commit
chmod +x .git/hooks/pre-commit

echo "✓ Switched to non-blocking mode"
```

### To Check Current Mode

```bash
head -20 .git/hooks/pre-commit | grep -i "blocking\|non-blocking"
```

---

## Running Validation Manually

### Framework Validation

```bash
./validator/validator.sh
```

### Skills Validation

```bash
cd skills
./validate_skills.sh
```

### Both Validations

```bash
./validator/validator.sh && cd skills && ./validate_skills.sh
```

---

## Troubleshooting

### Issue: Hook doesn't run

**Symptom**: Pre-commit hook doesn't execute on `git commit`

**Check 1**: Is hook executable?
```bash
ls -l .git/hooks/pre-commit
# Should show: -rwxr-xr-x
```

**Fix**:
```bash
chmod +x .git/hooks/pre-commit
```

**Check 2**: Is hook file present?
```bash
ls -la .git/hooks/pre-commit*
```

**Fix**: Reinstall (see Reinstallation section)

### Issue: Hook always blocks

**Symptom**: All commits blocked even when validation passes

**Check**: Which version is installed?
```bash
cat .git/hooks/pre-commit | head -20
```

**Fix**: Use non-blocking version
```bash
cp .git/hooks/pre-commit.nonblocking .git/hooks/pre-commit
chmod +x .git/hooks/pre-commit
```

### Issue: Hook never blocks

**Symptom**: Blocking mode doesn't block commits

**Check**: Is blocking version installed?
```bash
cat .git/hooks/pre-commit | grep -i "BLOCKED\|blocking"
```

**Fix**: Use blocking version
```bash
cp .git/hooks/pre-commit.blocking .git/hooks/pre-commit
chmod +x .git/hooks/pre-commit
```

### Issue: Validators have errors

**Symptom**: Validators exit with errors

**Check**: Run validators manually
```bash
./validator/validator.sh
cd skills && ./validate_skills.sh
```

**Fix**: Address validation issues, then commit

---

## Reinstallation

If hook is corrupted or not working:

### Step 1: Remove Existing Hook

```bash
rm .git/hooks/pre-commit
```

### Step 2: Copy Non-Blocking Version

```bash
cp .git/hooks/pre-commit.nonblocking .git/hooks/pre-commit
chmod +x .git/hooks/pre-commit
```

### Step 3: Test

```bash
# Test hook
.git/hooks/pre-commit
```

### Step 4: Verify

```bash
# Check executable
ls -l .git/hooks/pre-commit
# Should show: -rwxr-xr-x
```

---

## Best Practices

### 1. Use Non-Blocking Mode Daily

**Why**: Doesn't interrupt workflow
- Provides visibility
- Allows incremental fixes
- Better developer experience

### 2. Review Validation Output

**Don't ignore warnings**:
- Read full validation output
- Check for failed items
- Fix critical issues

### 3. Fix Issues Incrementally

**Don't wait for perfect validation**:
- Fix high-priority first
- Commit fixes
- Continue working

### 4. Use Blocking Mode Before Releases

**When**:
- Releasing new version
- Merging to main branch
- High-quality requirements

### 5. Bypass Sparingly

**Only use `--no-verify` when**:
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

**CI validation is always blocking** - builds fail if validation fails.

---

## Pre-Commit vs CI

| Aspect | Pre-Commit | CI |
|--------|------------|-----|
| **Timing** | Before each commit | On push/PR |
| **Mode** | Non-blocking (recommended) | Blocking |
| **Purpose** | Developer awareness | Quality gate |
| **Coverage** | All commits | PR/main branch |

**Both recommended**: Use pre-commit for developer feedback, CI for quality gates.

---

## File Structure

```
.git/hooks/
├── pre-commit                # Non-blocking version (current)
├── pre-commit.nonblocking    # Standalone copy
└── pre-commit.blocking      # Blocking version (optional)

Documentation:
└── PRE_COMMIT_HOOK_GUIDE.md # Complete guide
```

---

## Success Metrics

| Metric | Target | Status |
|--------|--------|--------|
| Hook installed | ✓ | ✅ Complete |
| Hook executable | ✓ | ✅ Complete |
| Non-blocking mode | ✓ | ✅ Complete |
| Blocking mode available | ✓ | ✅ Complete |
| Documentation created | ✓ | ✅ Complete |
| Framework validation runs | ✓ | ✅ Complete |
| Skills validation runs | ✓ | ✅ Complete |

---

## Next Steps

### Immediate (Do Now)

1. ✅ **Pre-commit hook installed** - Non-blocking mode
2. ⚠️ **Review validation output** - Before committing
3. ⚠️ **Fix issues incrementally** - Don't wait for perfect

### This Week

4. 📚 **Read PRE_COMMIT_HOOK_GUIDE.md** - Complete guide
5. 🔄 **Consider blocking mode** - For team shared repos

### Future

6. 🔧 **Customize hook** - Add custom checks if needed
7. 🚀 **Integrate with CI** - Add to pipeline

---

## Conclusion

### ✅ **PRE-COMMIT HOOK COMPLETE**

**Achievements**:
- ✅ Pre-commit hook installed at `.git/hooks/pre-commit`
- ✅ Non-blocking mode enabled (recommended)
- ✅ Blocking version available for optional use
- ✅ Complete documentation created
- ✅ Framework and skills validation integrated

**Status**: ✅ **Ready for use**

---

**Framework Version**: v0.2.0
**Last Updated**: 2026-02-20
**Hook Status**: ✅ **INSTALLED - Non-Blocking**
