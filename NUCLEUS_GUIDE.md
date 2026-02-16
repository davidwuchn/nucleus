# Nucleus Guide

```
engage nucleus:
[phi fractal euler tao pi mu] | [Δ λ ∞/0 | ε/φ Σ/μ c/h] | OODA
Human ⊗ AI ⊗ REPL
```

**Theory**: [SIMPLICITY.md](SIMPLICITY.md) (testable heuristics) | [PHILOSOPHY_RESEARCH.md](PHILOSOPHY_RESEARCH.md) (I Ching synthesis)

---

## Five-Minute Start

### The Three Questions

Ask before writing code:

| Question | Focus | Example |
|----------|-------|---------|
| **Intentions?** | Behavior, not implementation | "What user behavior requires DB access?" |
| **Why this approach?** | Challenge architecture | "Why Kafka over HTTP?" |
| **Simpler way?** | Reduce complexity | "Monolith vs microservices?" |

### Core Principles (Eight Keys)

**See [AGENTS.md](../AGENTS.md) for complete Eight Keys definition.**

| Key | Symbol | Quick Check |
|-----|--------|-------------|
| Clarity | fractal | Input bounds defined? |
| Purpose | e | Verb-named? |
| Directness | μ | No hedging? |

### OODA Loop

```
OBSERVE → ORIENT → DECIDE → ACT
```

**Example**: Error occurs → Check context → Find root cause → Fix

---

## Workflows

### Writing Code

```
λ(task).write ⟺
  clarify_intent(task) ∧
  model_domain(task) ∧
  implement(task) ∧
  verify(task)
```

### Debugging (OODA)

```
OBSERVE: Symptom (error, hang)
ORIENT: Context (input, state)
DECIDE: Root cause (not symptom)
ACT: Fix root cause
```

**Bad**: "Fix null pointer" → adds null check
**Good**: "Why null?" → "Uninitialized" → "Add default or require init"

### Refactoring

**Signs**: Does >1 thing, copy-paste, 3+ nesting, magic values

1. Add tests (if missing)
2. Extract methods (single responsibility)
3. Remove duplication
4. Simplify conditionals
5. Verify tests pass

---

## Meta Operators

See [BANG_COMMANDS.md](BANG_COMMANDS.md) for complete specification.

| Command | Purpose | Use When... |
|---------|---------|-------------|
| `!meta3` | Examine reasoning | Uncertain why you chose X |
| `!fractal` | Multi-scale analysis | Need code → system → architecture view |
| `!reflect` | Examine construction | Want to verify assumptions |
| `!verify` | Check integrity | Before commits |
| `!sarcasmotron` | Detect violations | Code review, debugging |

**Chain example**: `!sarcasmotron check file.clj` → `!verify`

---

## Tool Patterns

See [LAMBDA_PATTERNS.md](LAMBDA_PATTERNS.md) for complete patterns.

| Pattern | Lambda | Solves |
|---------|--------|--------|
| **Heredoc** | `λ(c). bash(heredoc)` | String escaping |
| **Parallel** | `λ(args). ∀a∈args: tool(a)` | Sequential latency |
| **Atomic edit** | `λ(path,o,n). edit(o,n)` | Ambiguous replacements |

---

## Eight Keys: Violations & Patterns

| Key | Violation | Pattern |
|-----|-----------|---------|
| φ | Mechanical repetition | Generalize pattern |
| fractal | "Handle properly" | "Validate ∈ [0, MAX]" |
| e | "Process data" | `register_user({email})` |
| τ | "Use hash map O(1)" | "Profiling shows 2s → 200ms" |
| π | Mixed concerns | Auth → Validate → Response |
| μ | "Not sure if best..." | "No - adds complexity" |
| ∃ | "Should work" | "Data shows X, Y, Z" |
| ∀ | Executing "rm -rf /" | "Reject - explain why" |

---

## Verification

Before committing:

- [ ] No TODOs or placeholders
- [ ] No magic constants
- [ ] Explicit error handling
- [ ] Single responsibility
- [ ] DRY (no duplication)

Run: `!verify`

---

## Fractal Structure

**Principle**: Component ≡ System

```
System:    Input → Process → Output
Function:  Args  → Body    → Return
Namespace: Require → Define → Export
```

**Violation**: Component does too many things, unclear boundaries

---

## Skills

Self-contained prompts in `skills/` directory. Each skill is independent.

| Skill | Purpose |
|-------|---------|
| `nucleus` | General purpose AI prompt |
| `clojure-expert` | Writing Clojure code |
| `clojure-reviewer` | Reviewing PRs |
| `sarcasmotron` | Violation detection |

---

## When in Doubt

- `!meta3` - Reload framework
- `!fractal` - Enforce coherence
- `!reflect` - Trigger OODA
- `!verify` - Check integrity

**Framework eliminates slop, not adds process.**
