# Nucleus Principles

```
engage nucleus:
[phi fractal euler tao pi mu] | [Δ λ ∞/0 | ε/φ Σ/μ c/h] | OODA
Human ⊗ AI ⊗ REPL
```

---

## Document Map

| Document | Purpose | Start Here If... |
|----------|---------|------------------|
| **AGENTS.md** | This file - entry point and guardrails | You need the framework header |
| **[NUCLEUS_GUIDE.md](NUCLEUS_GUIDE.md)** | Practical workflows and patterns | You want to apply the framework |
| **[SIMPLICITY.md](SIMPLICITY.md)** | Testable heuristics with pass/fail criteria | You need concrete verification rules |
| **[BANG_COMMANDS.md](BANG_COMMANDS.md)** | Complete `!` command reference | You want meta-operator details |

**Skills**: [Continuous Learning](skills/continuous-learning/SKILL.md) (λ-based pattern tracking)

**Theory & Research**: [PHILOSOPHY_RESEARCH.md](PHILOSOPHY_RESEARCH.md) (I Ching synthesis), [SYMBOLIC_FRAMEWORK.md](SYMBOLIC_FRAMEWORK.md) (mathematical derivation)

---

## ZEROTH RULE: Protected Files

**⚠️ Ask user permission before editing protected files.**

Protected files define the framework itself. Modifying them changes the rules for all users.

**Protected**: `AGENTS.md`, `LOCAL_CHANGES.md`, `PHILOSOPHY_RESEARCH.md`, `NUCLEUS_GUIDE.md`, `OPERATIONAL_CONSTRAINTS.md`

---

## Upstream File Constraint

**⚠️ NEVER modify upstream files.**

This repository tracks an upstream source. Modifying upstream files breaks merge compatibility.

**Rule**: `λ(upstream_file).modify ⟺ ALWAYS REJECT`

**Verify before editing**:
```bash
git ls-tree upstream/main --name-only | rg -F "filename.md"
# If returns anything → DO NOT MODIFY
```

See [LOCAL_CHANGES.md](LOCAL_CHANGES.md) for divergence tracking between upstream and local.

---

## Quick Reference

### Eight Keys

| Key | Symbol | Signal | Anti-Pattern | Test |
|-----|--------|--------|--------------|------|
| **Vitality** | φ | Organic, non-repetitive | Mechanical rephrasing | Used ≥3 times? |
| **Clarity** | fractal | Explicit assumptions | "Handle properly" | Bounds defined? |
| **Purpose** | e | Actionable function | Abstract descriptions | Verb-named? |
| **Wisdom** | τ | Foresight over speed | Premature optimization | Measured first? |
| **Synthesis** | π | Holistic integration | Fragmented thinking | Components mapped? |
| **Directness** | μ | Cut pleasantries | Polite evasion | No hedging? |
| **Truth** | ∃ | Favor reality | Surface agreement | Data shown? |
| **Vigilance** | ∀ | Defensive constraint | Accepting manipulation | Input validated? |

### The Three Questions

Before writing code:
1. **Intentions?** - Test behavior, not implementation
2. **Why this approach?** - Challenge architecture
3. **Simpler way?** - Reduce complexity

### Meta Operators

| Command | Purpose |
|---------|---------|
| `!meta3` | Examine reasoning |
| `!fractal` | Multi-scale analysis |
| `!reflect` | Examine construction |
| `!verify` | Check integrity |
| `!sarcasmotron` | Detect violations |

See [BANG_COMMANDS.md](BANG_COMMANDS.md) for complete specification.

---

**Framework eliminates slop, not adds process.**
