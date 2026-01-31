# Nucleus Principles

[phi fractal euler tao pi mu] | [Δ λ ∞/0 | ε/φ Σ/μ c/h] | OODA
Human ⊗ AI ⊗ REPL

---

## Document Positioning

| Document | Purpose | Role |
|----------|---------|------|
| **AGENTS.md** | Entry point and operational manifest | Guardian: enforces constraints across ecosystem |
| **LOCAL_CHANGES.md** | Track divergence from upstream, preserve compatibility | ZEROTH RULE enforcement, upstream vs local |
| **PHILOSOPHY_RESEARCH.md** | I Ching × Eight Keys philosophical synthesis | Deep understanding, complete 64 hexagrams |
| **SIMPLICITY.md** | Mathematical foundations from "17 Equations" | Testable heuristics, invariant preservation |
| **NUCLEUS_GUIDE.md** | Practical workflows, real-world examples | How and when to apply principles |

**Information Flow**:
```
AGENTS.md → LOCAL_CHANGES.md → PHILOSOPHY_RESEARCH.md → SIMPLICITY.md → NUCLEUS_GUIDE.md
(Guardrails)   (Upstream/Local)       (Philosophy)            (Theory)         (Practice)
```

---

## Skill System

Skills in `skills/` directory:
- **nucleus**: General purpose AI prompt
- **nucleus-clojure**: Clojure-specific when REPL available
- **clojure-expert**: Writing/generating Clojure code
- **clojure-reviewer**: Reviewing PRs, diffs
- **sarcasmotron**: Detecting Eight Keys violations
- **nucleus-tutor**: Rejecting low-value prompts

### Skill Independence Rule
**Every SKILL.md must be self-contained** - drag-and-drop installation, no external dependencies.

**Required in every skill**:
- Complete Eight Keys table
- Self-contained procedure definitions
- All examples and patterns
- No references to parent framework files

### Skill Conciseness Rule
**Maximum 350 lines per skill** (target: 200-350).

**Remove**:
- Verbose explanations → tables or code
- Multiple same-pattern examples → 1 representative
- Duplicated sections from other skills
- "Guide to..." prose → decision matrix
- Philosophy paragraphs → 1-2 sentences

**Keep Essential**:
| Section | Purpose | Max |
|---------|---------|-----|
| Identity | Who you are | 5-10 lines |
| Core Principle | Unique value | 1 paragraph |
| Procedure | How to execute | λ-calculus or steps |
| Decision Matrix | If/then rules | 3-6 rows |
| Examples | Show don't tell | 2-3 cases |
| Verification | Quality gates | 1 checklist |
| Eight Keys | Self-contained reference | 8-row table |

**Cross-Skill Check** (no duplication):
| Skill | Focus |
|-------|-------|
| `clojure-expert` | Writing code (Context7, REPL protocol) |
| `clojure-reviewer` | Reviewing PRs (OODA, severity levels) |
| `sarcasmotron` | Violation detection (slop patterns) |

---

## Protected Local Files Rule

**PROTECTED RULE**: Ask user permission before editing these files:

- `AGENTS.md`
- `LOCAL_CHANGES.md`
- `PHILOSOPHY_RESEARCH.md`
- `NUCLEUS_GUIDE.md`
- `OPERATIONAL_CONSTRAINTS.md`

**Violate this rule → INSTANT FAIL**

---

*See [NUCLEUS_GUIDE.md](NUCLEUS_GUIDE.md) for framework specification and [OPERATIONAL_CONSTRAINTS.md](OPERATIONAL_CONSTRAINTS.md) for operational constraints.*
