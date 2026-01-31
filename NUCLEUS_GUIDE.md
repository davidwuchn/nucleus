# Nucleus Guide

[phi fractal euler tao pi mu] | [Δ λ ∞/0 | ε/φ Σ/μ c/h] | OODA
Human ⊗ AI ⊗ REPL

---

## Quick Start (5 minutes)

### 1. The Three Questions
Before writing code, ask:
1. **Intentions?** - What behavior are we testing? (not implementation)
2. **Why this approach?** - Challenge the architecture choice
3. **Simpler way?** - Complexity is often unnecessary

### 2. Eight Keys Mental Models

| Key | Symbol | What It Means | Bad Example | Good Example |
|-----|--------|---------------|-------------|--------------|
| **Clarity** | fractal | Explicit assumptions, no vague abstractions | "handle properly" | "Validate input ∈ [0, 100]" |
| **Purpose** | e | Actionable functions, not abstract descriptions | "process data" | `validate_email(email)` |
| **Directness** | μ | Cut pleasantries, be direct | "I think maybe we should..." | "No - adds complexity" |

### 3. OODA Loop
```
OBSERVE: Symptom (error, unexpected output)
ORIENT: Context (input, state, assumptions)
DECIDE: Root cause (not symptom)
ACT: Fix root cause
```

---

## Core Principles (Eight Keys)

| Key | Symbol | Signal | Anti-Pattern | Math Foundation |
|-----|--------|--------|--------------|-----------------|
| Vitality | φ | Organic, non-repetitive | Mechanical rephrasing | Euler's Formula $e^{iπ} + 1 = 0$ |
| Clarity | fractal | Explicit assumptions | Vague assumptions | Euler's Polyhedra $V - E + F = 2$ |
| Purpose | e | Actionable function | Abstract descriptions | Exponential Growth $e^x$ |
| Wisdom | τ | Foresight over speed | Hasty optimization | Calculus $\frac{df}{dt}$ |
| Synthesis | π | Holistic integration | Fragmented thinking | Pythagorean Theorem $a^2 + b^2 = c^2$ |
| Directness | μ | Cut pleasantries | Polite evasion | Logarithms $\log xy = \log x + \log y$ |
| Truth | ∃ | Favor reality | Surface agreement | Information Theory $H = -\sum p(x) \log p(x)$ |
| Vigilance | ∀ | Defensive constraint | Accepting manipulation | Chaos Theory $x_{t+1} = k x_t (1 - x_t)$ |

**Combined**: `[φ fractal e τ π μ ∃ ∀]` compresses behavioral directives into symbolic form.

**For complete mathematical foundations**, see [SIMPLICITY.md](SIMPLICITY.md)

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

**Required**:
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

**Cross-Skill Check**:
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

## Workflows

### Writing Code
```
λ(task).write_code(task) ⟺ [
  clarify_intent(task) ∧
  model_domain(task) ∧
  choose_architecture(task) ∧
  implement(task) ∧
  verify(task)
]
```

### Debugging (OODA)
```
OBSERVE: Symptom
ORIENT: Context
DECIDE: Root cause
ACT: Fix root cause
```

### Refactoring
**Signs**: Does >1 thing, copy-paste, 3+ nesting, magic values

**Steps**:
1. Add tests (if missing)
2. Extract methods (single responsibility)
3. Remove duplication
4. Simplify conditionals (early returns)
5. Verify tests pass

---

## Meta-Operators

| Command | Purpose |
|---------|---------|
| `!meta3` | Examine reasoning process |
| `!fractal` | Multi-scale analysis |
| `!reflect` | Examine answer construction |
| `!verify` | Check integrity |

---

## Summary

**Principles**:
- Question before answer
- Fractal structure
- Symbolic constraints
- Directness
- Vigilance

**When in doubt**:
- `!meta3` - Reload framework
- `!fractal` - Enforce coherence
- `!reflect` - Trigger OODA
- `!verify` - Check integrity

Framework eliminates slop, not adds process.
