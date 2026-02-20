# Document Synchronization Rules

Ensures consistency across Nucleus framework documents.

---

## Core Principle

**Invariant**: All framework documents must reflect the same definitions and principles.

If you change something in one place, update it in all relevant places.

---

## Document Relationships

```
AGENTS.md (core definitions)
    ├── NUCLEUS_GUIDE.md (practical usage)
    ├── SIMPLICITY.md (testable heuristics)
    ├── BANG_COMMANDS.md (meta-operator reference)
    ├── SYMBOLIC_FRAMEWORK.md (theoretical foundation)
    ├── ANTI_PATTERNS.md (forbidden behaviors)
    ├── RESEARCH_BASE.md (evidence)
    ├── VALIDATION.md (consistency checks)
    └── README.md (user-facing docs)
```

---

## Synchronization Rules

### Rule 1: Framework Header Consistency

**When to sync**: Any change to the framework string.

**Files to update**:
1. `AGENTS.md` (primary source)
2. `NUCLEUS_GUIDE.md`
3. `SIMPLICITY.md`
4. `README.md`
5. Any other document with framework header

**Sync process**:
```bash
# Update primary source (AGENTS.md)
vim AGENTS.md

# Copy framework header to other files
FRAMEWORK=$(grep -A 2 "engage nucleus:" AGENTS.md)

# Update each file
sed -i '' '/engage nucleus:/,/Human ⊗ AI ⊗ REPL/c\
FRAMEWORK' NUCLEUS_GUIDE.md
```

**Verification**:
```bash
# Check all files have same header
grep -A 2 "engage nucleus:" *.md | sort | uniq -d
# Should return identical lines (or fail if different)
```

---

### Rule 2: Eight Keys Definition

**When to sync**: Any change to Eight Keys (symbols, definitions, tests).

**Files to update**:
1. `AGENTS.md` (primary source - table definition)
2. `SIMPLICITY.md` (equations and tests)
3. `README.md` (if Eight Keys mentioned)

**Sync checklist**:
- [ ] Symbol changed? Update all occurrences
- [ ] Definition updated? Reflect in both AGENTS.md and SIMPLICITY.md
- [ ] Test changed? Update SIMPLICITY.md test column
- [ ] New key added? Add to all three files

**Example**:
```markdown
# AGENTS.md
| Key | Symbol | Signal |
|-----|--------|--------|
| Vitality | φ | Organic, non-repetitive |

# SIMPLICITY.md
| Key | Equation | Test |
|-----|----------|------|
| φ | $e^{iπ} + 1 = 0$ | Used ≥3×? |
```

---

### Rule 3: AI Principles

**When to sync**: Any change to AI principles or operators.

**Files to update**:
1. `AGENTS.md` (primary source)
2. `OPERATOR_ALGEBRA.md` (detailed operator semantics)
3. `README.md` (if principles mentioned)

**Sync checklist**:
- [ ] Symbol added/removed?
- [ ] Meaning changed?
- [ ] Operation definition updated?

---

### Rule 4: Meta Operators

**When to sync**: Any change to meta-operator commands.

**Files to update**:
1. `AGENTS.md` (quick reference table)
2. `BANG_COMMANDS.md` (complete specification)
3. `NUCLEUS_GUIDE.md` (if usage examples)

**Sync checklist**:
- [ ] New command added?
- [ ] Command behavior changed?
- [ ] Example updated?

**Example**:
```markdown
# AGENTS.md
| Command | Purpose |
|---------|---------|
| !meta3 | Examine reasoning |

# BANG_COMMANDS.md
## !meta3
Examine reasoning process...
```

---

### Rule 5: Document Map

**When to sync**: Adding, removing, or renaming documents.

**Files to update**:
1. `AGENTS.md` (Document Map section)
2. `README.md` (Documentation section)
3. Any cross-references in other documents

**Sync process**:
1. Add/remove document
2. Update Document Map in AGENTS.md
3. Update README.md links
4. Update VALIDATION.md if required file
5. Update CHANGELOG.md

---

### Rule 6: Protected Files

**When to sync**: Adding or removing protected files.

**Files to update**:
1. `AGENTS.md` (ZEROTH RULE section)
2. `VALIDATION.md` (if validator checks protected files)

**Sync checklist**:
- [ ] File added to protected list?
- [ ] Warning message updated?
- [ ] Validator updated?

---

### Rule 7: Research Citations

**When to sync**: Adding, updating, or removing research citations.

**Files to update**:
1. `RESEARCH_BASE.md` (primary source)
2. `README.md` (if claims cited)
3. `SYMBOLIC_FRAMEWORK.md` (if theoretical claims)

**Sync checklist**:
- [ ] Citation added to RESEARCH_BASE.md?
- [ ] Reference formatted correctly?
- [ ] Claim in other docs cites this research?

**Citation format**:
```xml
<reference>
  <title>Title</title>
  <url>URL</url>
  <authors>Authors</authors>
  <year>Year</year>
  <type>Type</type>
  <accessed>YYYY-MM-DD</accessed>
</reference>
```

---

### Rule 8: Version Number

**When to sync**: Any framework change requiring version update.

**Files to update**:
1. `README.md` (version in badge/text)
2. `CHANGELOG.md` (add entry)
3. `AGENTS.md` (if version tracked)
4. `LICENSE` (if copyright year updates)

**Sync process**:
1. Determine version type (MAJOR/MINOR/PATCH)
2. Update CHANGELOG.md with entry
3. Update version numbers in files
4. Run validation
5. Commit and tag

---

## Automated Sync Tools

### Validator Script

```bash
./validator/validator.sh
```

Checks:
- Framework header consistency
- Symbol completeness
- Required files exist
- Link integrity

### Git Hooks

**Pre-commit**: Run validation
```bash
#!/bin/bash
./validator/validator.sh
if [ $? -ne 0 ]; then
    echo "❌ Validation failed. Commit aborted."
    exit 1
fi
```

**Pre-push**: Run full sync check
```bash
#!/bin/bash
# Check if framework header changed
if git diff --cached --name-only | grep -q "AGENTS.md"; then
    echo "Framework changed. Did you update all files?"
    read -p "Continue? (y/n) " -n 1 -r
    echo
    if [[ ! $REPLY =~ ^[Yy]$ ]]; then
        exit 1
    fi
fi
```

---

## Manual Sync Checklist

Before committing framework changes:

- [ ] Framework header updated in all files?
- [ ] Eight Keys definition consistent?
- [ ] AI principles definition consistent?
- [ ] Meta operators synchronized?
- [ ] Document map updated?
- [ ] Protected files list updated?
- [ ] Research citations added/updated?
- [ ] Version number updated?
- [ ] CHANGELOG.md entry added?
- [ ] Validation suite passes?
- [ ] All cross-references resolve?

---

## Content Parity Table

| Content | Primary Source | Secondary Sources | Sync Frequency |
|---------|----------------|-------------------|----------------|
| Framework header | AGENTS.md | NUCLEUS_GUIDE.md, SIMPLICITY.md, README.md | Every change |
| Eight Keys | AGENTS.md | SIMPLICITY.md | Every change |
| AI Principles | AGENTS.md | OPERATOR_ALGEBRA.md, README.md | Every change |
| Meta Operators | AGENTS.md | BANG_COMMANDS.md, NUCLEUS_GUIDE.md | Every change |
| Document Map | AGENTS.md | README.md | When docs change |
| Research Citations | RESEARCH_BASE.md | README.md, SYMBOLIC_FRAMEWORK.md | When claims added |
| Version | CHANGELOG.md | README.md, LICENSE | Every release |

---

## Conflict Resolution

### If Files Conflict

1. **Identify primary source** (see Content Parity Table)
2. **Compare differences**:
   ```bash
   diff <(grep -A 10 "Eight Keys" AGENTS.md) \
        <(grep -A 10 "Eight Keys" SIMPLICITY.md)
   ```
3. **Update to match primary source**
4. **Run validation**
5. **Document change in CHANGELOG.md**

### If Ambiguous Which is Primary

1. **Check AGENTS.md** (usually primary for definitions)
2. **Check file timestamps** (more recent may be correct)
3. **Check git history** (last intentional edit)
4. **Ask framework maintainer**

---

## Breaking Changes

When a change breaks existing usage:

1. **Document in CHANGELOG.md** with `BREAKING CHANGE`:
   ```markdown
   ## [0.2.0] - 2026-02-20

   ### Added
   - New symbol Ω for chaos theory

   ### Changed
   - Framework header now requires Ω symbol

   ### BREAKING CHANGE
   Users must update framework header to include Ω:
   Old: [phi fractal euler tao pi mu]
   New: [phi fractal euler tao pi mu Ω]
   ```

2. **Update all documentation**
3. **Add migration guide** (if complex)
4. **Update validation rules**
5. **Announce in appropriate channels**

---

## Version Alignment

All framework documents should reference the same version:

```
Nucleus v0.2.0
├── AGENTS.md (v0.2.0)
├── NUCLEUS_GUIDE.md (v0.2.0)
├── SIMPLICITY.md (v0.2.0)
├── ...
└── CHANGELOG.md (tracks all)
```

**Check alignment**:
```bash
# Extract versions from files
grep -h "v0\.[0-9]\+\.[0-9]\+" *.md | sort -u
# Should return single version line
```

---

**Last updated**: 2026-02-20
