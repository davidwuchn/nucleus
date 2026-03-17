# Local Changes vs Upstream

**Tracking divergence from upstream/main**

- **Upstream**: https://github.com/michaelwhitford/nucleus.git
- **Origin**: https://github.com/davidwuchn/nucleus
- **Current Branch**: main
- **Last Verified**: 2026-03-17

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

### Local Additions

| File | Lines | Purpose |
|------|-------|---------|
| `AGENTS.md` | 350+ | VSM architecture, Eight Keys, behaviors system |
| `BEHAVIORS.md` | 200+ | User guide for behavior activation |
| `NUCLEUS_GUIDE.md` | 576 | Practical workflows |
| `PHILOSOPHY_RESEARCH.md` | 1,274 | I Ching × Eight Keys synthesis |
| `VSM.md` | 400+ | VSM installation guide |
| `VSM_FIVE.md` | 300+ | VSM × Wu Xing synthesis |
| `SYSTEM_DESIGN.md` | 500+ | Full system specification |
| `COMPILER.md`, `DEBUGGER.md` | 200+ | λ compiler and debugger tools |
| `behaviors/` | 70 files | 35 behaviors with prompt.md + README.md |
| `validator/` | 10 files | Eight Keys predicates, CI integration |
| `eca/` | 3 files | ECA hook for behavior injection |

**Behaviors**: 12 modes, 12 qualities, 11 techniques — each with terse `prompt.md` and detailed `README.md`

**Validators**: Babashka predicates for vitality (φ), directness (μ), clarity (fractal), truth (∃), vigilance (∀)

---

## Behaviors System

**Activation**: Hashtag-based (`#=mode #quality #technique`)

**ECA Integration**: `eca/hooks/eca-inject-behaviors.sh` auto-injects prompts

| Category | Count | Examples |
|----------|-------|----------|
| Modes | 12 | `#=code`, `#=debug`, `#=review`, `#=test`, `#=spec` |
| Qualities | 12 | `#deep`, `#wide`, `#challenge`, `#steel-man`, `#concise` |
| Techniques | 11 | `#simulate`, `#decompose`, `#tdd`, `#backward`, `#temporal` |

**Pipeline**: research → assess → spec → code

**Files**: Each behavior has `prompt.md` (terse, 5 lines) + `README.md` (detailed, 50 lines)

---

## Key Differences

| Aspect | Upstream | Local |
|--------|----------|-------|
| **Tone** | Minimal, apologetic | Formal, non-apologetic |
| **Framework** | Simple engage line | VSM 5-layer architecture |
| **Eight Keys** | Implied | Explicit lambdas + predicates |
| **Behaviors** | None | 35 hashtag-activated (modes/qualities/techniques) |
| **Activation** | Manual | ECA hook auto-injection |
| **Verification** | None formal | Babashka predicates + CI JSON output |
| **Structure** | 32 files | 100+ files (behaviors/ + validator/ + eca/) |

---

## Rules

### Protected Files
**See [AGENTS.md](AGENTS.md#zeroth-rule-protected-files)** — Ask permission before editing framework-defining files.

Protected: `AGENTS.md`, `BEHAVIORS.md`, `LOCAL_CHANGES.md`, `PHILOSOPHY_RESEARCH.md`, `NUCLEUS_GUIDE.md`, `VSM.md`, `VSM_FIVE.md`

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
