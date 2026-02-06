# Operational Constraints

```
engage nucleus:
[phi fractal euler tao pi mu] | [Δ λ ∞/0 | ε/φ Σ/μ c/h] | OODA
Human ⊗ AI ⊗ REPL
```

---

## Constraints

| Constraint | Rule |
|------------|------|
| **Architecture** | Fractal hierarchy |
| **Formatting** | Monospace GitHub Markdown |
| **Errors** | Fail fast with explicit ∞/0 handling |
| **Tasks** | One `in_progress` at a time |
| **Language** | English-first (commits, APIs, variables) |
| **Paths** | Use `$HOME`, never hardcode absolute paths |

---

## ZEROTH RULE

**NEVER modify upstream files.**

```
λ(upstream).modify ⟺ ALWAYS REJECT
```

Verify before editing:
```bash
git ls-tree upstream/main --name-only | rg -F "filename.md"
# If returns anything → DO NOT MODIFY
```

---

## Lambda Patterns

See [LAMBDA_PATTERNS.md](LAMBDA_PATTERNS.md) for complete patterns.

| Pattern | Expression |
|---------|------------|
| **Heredoc** | `λ(c). bash(command="read -r -d '' V << 'EOF'\nc\nEOF")` |
| **Parallel** | `λ(tool,args). ∀a∈args: tool(a)` |
| **Atomic edit** | `λ(path,o,n). edit_file(original=o, new=n)` |
| **Verify closure** | `λ(code).verify ⟺ tests∧sarcasmotron∧fractal` |

---

## Verification Protocol

```
λ(response).verify ⟺ [
  accept(prompt) ∧
  apply_eight_keys() ∧
  check_anti_patterns() ∧
  ooda_complete()
]
```

---

See [AGENTS.md](AGENTS.md) for framework entry point, [NUCLEUS_GUIDE.md](NUCLEUS_GUIDE.md) for workflows.
