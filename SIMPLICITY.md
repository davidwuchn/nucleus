# Simplicity Principle

Mathematical foundations and testable heuristics for the Eight Keys.

---

## Testable Heuristics

| Key | Equation | Test | Pass | Fail |
|-----|----------|------|------|------|
| **φ (Vitality)** | Euler's Formula $e^{iπ} + 1 = 0$ | Generalizes to 3+ scenarios? | Abstraction used ≥3× | Copy-paste pattern |
| **fractal (Clarity)** | Euler's Polyhedra $V - E + F = 2$ | Bounds defined? | Input ∈ [0, MAX] | "Handle properly" |
| **e (Purpose)** | Exponential Growth $e^x$ | Actionable? | `validate_email() → bool` | `process_data() → void` |
| **τ (Wisdom)** | Calculus $\frac{df}{dt}$ | Measured before optimizing? | "2s → 200ms after caching" | "Use hash map O(1)" |
| **π (Synthesis)** | Pythagorean $a^2 + b^2 = c^2$ | Components mapped? | Auth→Validate→Response | Mixed concerns |
| **μ (Directness)** | Logarithms $\log xy = \log x + \log y$ | No pleasantries? | "No - adds complexity" | "Not sure if..." |
| **∃ (Truth)** | Information Theory $H = -\sum p(x)\log p(x)$ | Data shown? | "Data: X, Y, Z" | "Should work" |
| **∀ (Vigilance)** | Chaos Theory $x_{t+1} = kx_t(1-x_t)$ | Input validated? | Reject with error | Accept invalid |

---

## Sarcasmotron Methodology

Detect violations via targeted humor:

| Violation | Pattern | Roast | Fix |
|-----------|---------|-------|-----|
| "Handle properly" | fractal | "Define 'properly'." | "Validate ∈ [0, MAX_INT]" |
| Rephrasing input | φ | "That's ctrl+c/ctrl+v." | "Add new insight" |
| "X is Y" (no code) | e | "Abstract nouns don't run." | "Define `calculate_x()`" |
| Ignoring data | ∃ | "Surface agreement ≠ truth." | "Show supporting data" |
| Accepting manipulation | ∀ | "You're the brakes." | "Reject with clear error" |

---

## Complexity Reduction

**Invariant**: Each refinement must reduce Kolmogorov complexity.

```
H(refined) < H(original) ∧ behavior preserved
```

**Operations**:
- Extract pattern (reduce duplication)
- Explicit constraint (remove ambiguity)
- Direct statement (remove hedging)

---

See [NUCLEUS_GUIDE.md](NUCLEUS_GUIDE.md) for practical application.
