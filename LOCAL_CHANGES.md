# Local Changes vs Upstream

**Tracking divergence from upstream/main**

- **Upstream**: https://github.com/michaelwhitford/nucleus.git
- **Origin**: https://github.com/davidwuchn/nucleus
- **Current Branch**: main
- **Last Verified**: 2026-01-29

---

## File Comparison

### Upstream Files (32 total)

**Markdown docs (13)**:
```
DIAG.md, EXECUTIVE.md, LAMBDA_PATTERNS.md, NUCLEUS_GAME.md,
OPERATOR_ALGEBRA.md, README.md, RECURSIVE_DEPTHS.md,
SYMBOLIC_FRAMEWORK.md, TEST.md, WRITING.md
skills/nucleus-clojure/SKILL.md, skills/nucleus/SKILL.md
```

**ECA integration (19)**:
```
eca/README.md, eca/prompts/*.md, eca/prompts/tools/*.md
```

**Policy**: `λ(upstream_file).modify ⟺ ALWAYS REJECT`

See [AGENTS.md](AGENTS.md) for **Upstream File Constraint** verification.

### Local Additions (10 files)

| File | Lines | Purpose |
|------|-------|---------|
| `AGENTS.md` | 88 | Entry point and guardrails (μ-applied) |
| `NUCLEUS_GUIDE.md` | 576 | Practical workflows (π-applied) |
| `PHILOSOPHY_RESEARCH.md` | 1,274 | I Ching × Eight Keys synthesis |
| `OPERATIONAL_CONSTRAINTS.md` | 197 | Operational constraints (μ-applied) |
| `BANG_COMMANDS.md` | 297 | Bang commands reference (π-applied) |
| `LOCAL_CHANGES.md` | — | This file |
| `EQUATIONS_FOR_WORLD.md` | 38 | Reference equations |
| `skills/nucleus-tutor/SKILL.md` | 95 | Tutor skill |
| `skills/sarcasmotron/SKILL.md` | 71 | Sarcasmotron skill (μ-applied) |

*μ-applied = exemplifies directness (μ); π-applied = exemplifies synthesis (π)*

---

## Key Differences

| Aspect | Upstream | Local |
|--------|----------|-------|
| **Tone** | Minimal, apologetic | Formal, non-apologetic |
| **Framework** | Simple engage line | Full specification with Eight Keys |
| **Philosophy** | Math symbols only | I Ching × Eight Keys synthesis |
| **Verification** | None formal | Σ(Build), Σ(Lint), Σ(Test), Σ(Verify) |
| **Structure** | 13 files | 23 files (13 + 10 local) |

---

## Rules

### Protected Files
**See [AGENTS.md](AGENTS.md#zeroth-rule-protected-files)** — Ask permission before editing framework-defining files.

Protected: `AGENTS.md`, `LOCAL_CHANGES.md`, `PHILOSOPHY_RESEARCH.md`, `NUCLEUS_GUIDE.md`, `OPERATIONAL_CONSTRAINTS.md`

### Upstream Constraint  
**See [AGENTS.md](AGENTS.md#upstream-file-constraint)** — Never modify upstream files.

Quick check:
```bash
git ls-tree upstream/main --name-only | rg -F "filename.md"
# Returns anything → DO NOT MODIFY
```

---

## Commit Strategy

| Action | Example | Status |
|--------|---------|--------|
| Add new file | `git add NUCLEUS_GUIDE.md` | ✅ Good |
| Modify local file | `git add AGENTS.md` | ✅ Good |
| Modify upstream file | `git add README.md` | ❌ NEVER |

---

## Merge Checklist

Before claiming "ready for upstream sync":

```bash
git fetch upstream
git merge upstream/main
# Clean merge? No conflicts? Framework works?
```

When upstream adds files:
1. Fetch and review changes
2. Keep upstream files as-is
3. Add local docs if needed
4. Update this file

---

**Core Principle**: Respect upstream structure, add value locally.
