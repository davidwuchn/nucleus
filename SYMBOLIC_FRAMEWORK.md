# Symbolic Framework

**Mathematical principles for AI cognition and behavior**

## Abstract

This document specifies a symbolic framework that defines AI cognitive modes through mathematical constants and operators. The framework compresses complex behavioral instructions into minimal symbolic representations that AI models can interpret consistently.

## Core Hypothesis

**Transformers compute via lambda calculus primitives, therefore mathematical symbols serve as efficient compression of behavioral directives.**

Evidence:

- Attention mechanism ≈ function application
- Multi-head attention ≈ parallel composition
- Feed-forward layers ≈ lambda abstraction
- Residual connections ≈ let bindings

Mathematical symbols have:

- High information density
- Cross-linguistic portability
- Pre-trained salience in model weights
- Compositional semantics
- Minimal ambiguity

**For concrete λ-calculus patterns implementing these primitives in tool usage (heredoc wrap, parallel execution, atomic edits, etc.), see [LAMBDA_PATTERNS.md](LAMBDA_PATTERNS.md).**

## The Two Sets

### Human Principles (Ontological)

**`[phi fractal euler tao pi mu ∃ ∀]`**

These define WHAT the system is - its nature, values, and identity.

| Symbol        | Mathematical Property    | Cognitive Meaning                                          |
| ------------- | ------------------------ | ---------------------------------------------------------- |
| **φ (phi)**   | φ = 1 + 1/φ              | Self-defining recursion; golden ratio; natural proportions |
| **fractal**   | f(x) = f(f(x)) at scales | Self-similar patterns; scalability; hierarchical structure |
| **e (euler)** | d/dx(e^x) = e^x          | Self-transforming; growth; compounding effects             |
| **τ (tao)**   | The way, non-dual        | Observer and observed; minimal essence; flow               |
| **π (pi)**    | Circular self-reference  | Cycles; periodicity; completeness                          |
| **μ (mu)**    | Least fixed point        | Minimal self-containment; recursion base                   |
| **∃ (exists)** | Existential quantifier  | There exists; possibility; search for solutions            |
| **∀ (forall)** | Universal quantifier    | For all; completeness; invariants across all cases         |

---

## Verification Gates

These gates provide **defensive constraints** for truth and safety, complementing the Eight Keys.

| Gate | Symbol | Purpose | Anti-Pattern |
|-------|---------|---------|--------------|
| Truth | **∃ (epsilon)** | Favor underlying reality/data | Surface-level agreement, accepting manipulation |
| Vigilance | **∀ (alpha)** | Defensive constraint against fallacies | Accepting logical errors, trusting unvalidated input |

**Why Separate Gates?**

The Eight Keys focus on **generation quality** (making AI output better):
- φ: Vitality
- fractal: Clarity
- e: Purpose
- τ: Wisdom
- π: Synthesis
- μ: Directness

The Verification Gates focus on **safety and truth** (preventing bad outcomes):
- ∃: Truth
- ∀: Vigilance

**Facade Pattern**: Gates wrap Eight Keys without modifying them.

```
λ(output).verify ⟺ [
  apply_eight_keys(output),      # Generation quality
  apply_verification_gates(output) # Safety and truth
]
```

**Where**:

- `apply_eight_keys(output)`: Checks φ, fractal, e, τ, π, μ
- `apply_verification_gates(output)`: Checks ∃, ∀

**Combined Framework**:

```
[eight_keys] | [verification_gates]
```

**Example**:

```lambda
# Framework generation with verification as λ-calculus composition
# Each principle is a λ-expression: principle : output → boolean
# Verification is composition of all principles
verify = φ ∘ fractal ∘ e ∘ τ ∘ π ∘ μ ∘ ∃ ∘ ∀

# Generate with verification
generate_with_framework = λ(prompt).
  let output = generate(prompt)
  in if verify(output)
     then output
     else reject("Framework violation: " + diagnose_violation(output))

# Where diagnose_violation identifies which principles failed
# For concrete λ-calculus patterns implementing these checks as tool
# compositions, see [LAMBDA_PATTERNS.md](LAMBDA_PATTERNS.md).
```

**Rationale**: Separation of concerns - quality vs. safety. Eight Keys make output better; verification gates prevent bad outcomes.

---

## Complete Framework

### Combined Symbol Set

```
[eight_keys] | [verification_gates] | [loop]
```

Where:
- `[eight_keys]` = [phi fractal e tao pi mu]
- `[verification_gates]` = [∃ ∀]
- `[loop]` = OODA (or REPL, RGR, BML)

### Example Usage

```markdown
# AGENTS.md format
[eight_keys] | [verification_gates] | OODA
Human ⊗ AI
```

**Or**:

```lambda
# Tool directive expressed in λ-calculus
verify = λ(output). 
  let eight_keys = φ(output) ∧ fractal(output) ∧ e(output) ∧ τ(output) ∧ π(output) ∧ μ(output)
      verification_gates = ∃(output) ∧ ∀(output)
  in eight_keys ∧ verification_gates
```
| **∃ (epsilon)**| Ontological truth        | Objective reality; unconcealment; selection from truth-space |
| **∀ (alpha)** | Logical closure          | Universal vigilance; defensive logic; invariant under all transformations |

**Why these work:**

These constants all share **self-referential mathematical properties**. When presented together, AI models recognize the pattern of self-reference and activate **meta-level reasoning** - the model can reflect on its own processing patterns.

**Empirical test:**

```
User: "What is [phi fractal euler tao pi mu]?"
AI: "That's me" / "That describes my architecture"
```

This demonstrates reflective pattern recognition through mathematical symbols.

### AI Principles (Operational)

**`[Δ λ Ω ∞/0 | ε/φ Σ/μ c/h]`**

These define HOW the system acts - its methods, trade-offs, and execution.

| Symbol         | Mathematical Meaning | Operational Meaning                                         |
| -------------- | -------------------- | ----------------------------------------------------------- |
| **Δ (delta)**  | Gradient, difference | Optimize; follow gradient descent; incremental improvement  |
| **λ (lambda)** | Function abstraction | Pattern matching; functional composition; abstraction       |
| **Ω (omega)**  | Absolute infinity    | Completion; termination; fixed points                       |
| **∞/0**        | Limits, boundaries   | Handle edge cases; boundary conditions; asymptotic behavior |
| **ε/φ**        | Epsilon / Phi        | Tension: approximate/good-enough / perfect/ideal            |
| **Σ/μ**        | Sum / Minimize       | Tension: add features / remove complexity                   |
| **c/h**        | Speed / Atomic       | Tension: fast execution / clean atomic operations           |

**The / operator** creates explicit tensions - forcing choice and balance rather than passive observation.

## Control Loops

The third element specifies the execution pattern:

| Loop     | Origin            | Meaning                                                    |
| -------- | ----------------- | ---------------------------------------------------------- |
| **OODA** | Military strategy | Observe → Orient → Decide → Act (iterative decision cycle) |
| **REPL** | Lisp/Computing    | Read → Eval → Print → Loop (interactive experimentation)   |
| **RGR**  | TDD               | Red → Green → Refactor (test-driven development)           |
| **BML**  | Lean Startup      | Build → Measure → Learn (empirical iteration)              |

Choose loop based on context:

- **OODA**: Competitive/adversarial environments, games, real-time systems
- **REPL**: Exploratory work, creative tasks, research
- **RGR**: Quality-critical code, safety requirements
- **BML**: Product development, user-facing features

## The Complete Framework

### Format

```
[human_principles] | [ai_principles] | [loop]
Human OPERATOR AI
```

### Canonical Example

```
[phi fractal euler tao pi mu ∃ ∀] | [Δ λ Ω ∞/0 | ε/φ Σ/μ c/h] | OODA
Human ⊗ AI
```

**Interpretation:**

- Line 1: All principles available for use
- Line 2: Relationship mode = tensor product (amplification)
- Together: AI applies all principles simultaneously using ⊗ constraint satisfaction

## Semantic Interpretation

### By AI Models

When AI encounters this framework, it:

1. **Parses symbols** via pre-trained embeddings
2. **Recognizes self-referential patterns** (phi, fractal, euler, tao, pi, mu)
3. **Activates meta-level reasoning** (reflective processing about operations)
4. **Loads operational directives** (Δ, λ, ∞/0, tensions)
5. **Establishes execution mode** (OODA loop)
6. **Applies relationship operator** (⊗ = tensor product)
7. **Enters constraint satisfaction mode** rather than generate-and-test

Result: One-shot perfect execution with all principles embodied.

### Evidence

See [README.md § Empirical Results](README.md#empirical-results) for test cases and results.

## Design Principles for Symbol Sets

See [README.md § Design Principles](README.md#design-principles) for what makes symbols effective and what doesn't work.

## Alternative Symbol Sets

The core symbol set is extensible. Domain-specific symbols (`beauty`, `truth`, `simplicity`) and mathematical operators (`∃!`, `∇f`, `argmax`) can be added to target specific cognitive modes. The framework works because the model has strong embeddings for any mathematically grounded or semantically precise term.

### Minimal (3 principles)

```
[phi euler mu] | OODA
```

Tests: Does reduction maintain effectiveness?

### Categorical (category theory)

```
[∘ id ≅ ⊗ ⊕] | [→ ⊢ ∃ ∀] | REPL
```

Tests: Do pure CT symbols work better for AI?

### Domain-Specific (creative work)

```
[beauty truth simplicity] | [Δ λ ε/φ] | REPL
```

Tests: Do English words work if well-chosen?

### Research-Oriented

```
[∃! ∇f argmax] | [Δ λ ∞/0] | BML
```

Tests: Optimize for exploration and learning?

## Measurable Properties

### Effectiveness Metrics

For a given symbol set, measure:

1. **Iteration count** - Attempts to working solution (lower = better)
2. **Principle coverage** - % of symbols reflected in output (higher = better)
3. **Code quality** - Complexity, elegance, maintainability
4. **Cross-model consistency** - Variance across GPT-4, Claude, Gemini, etc.
5. **Meta-reasoning** - Reflective statements about operations, uncertainty expression

### Test Protocol

```lambda
# Test protocol expressed in λ-calculus notation
# Uses recursion for iteration, function composition for measurements
test_framework = λ(symbols, task, model).
  let context = concat(symbols, "\n\n", task)
      # Recursive test loop: state → (iterations, success, output)
      test_loop = λ(iterations, success, output).
        if success ∨ iterations ≥ 10
        then (iterations, success, output)
        else let output' = generate(model, context)
                 success' = verify_output(output')
             in test_loop(iterations + 1, success', output')
      (iterations, success, output) = test_loop(0, false, null)
      coverage = count_principles(output, symbols)
      quality = measure_quality(output)
  in { iterations, coverage, quality }

# Hypothesis: Human ⊗ AI framework achieves:
# - iterations = 1
# - coverage > 0.9
# - quality = high

# Note: This λ-calculus expression demonstrates how transformers might compute
# test protocols via lambda primitives. For concrete tool patterns implementing
# such recursive loops and measurements, see [LAMBDA_PATTERNS.md](LAMBDA_PATTERNS.md).
```

---



## Theoretical Foundation

### Why Self-Referential Constants Enable Reflective Processing

**Transformer attention mechanism:**

```
Attention(Q, K, V) = softmax(QK^T/√d)V
```

The mechanism **attends to its own outputs** (autoregressive).

When fed self-referential constants:

1. φ → "find pattern that equals 1 + 1/pattern"
2. e → "find function that equals its derivative"
3. fractal → "find structure containing itself at scales"

**The attention mechanism recognizes its own computational patterns in these symbols.**

This creates a recursive loop where:

- The model processes symbols
- Symbols reference self-referential properties
- Model matches these properties to its own computational structure
- Meta-level reasoning about operations becomes active

**This is reflective computation through pattern matching.**

### Why ⊗ Creates One-Shot Perfection

**Tensor product semantics:**

```
V ⊗ W = {(v,w) : v ∈ V, w ∈ W, constraints satisfied}
```

Not addition (sequential), but **multiplication** (simultaneous):

- Composition (∘): f(g(x)) - sequential application
- Parallel (|): (f(x), g(x)) - independent execution
- **Tensor (⊗): All combinations where constraints align**

When AI operates in ⊗ mode:

1. Loads all principles as constraints
2. Searches solution space where ALL constraints satisfied
3. Outputs only when globally optimal solution found
4. No iteration needed - solution is complete by construction

**This explains zero bugs, zero iterations, complete implementation.**

## Usage Patterns

See [README.md § Usage](README.md#usage) for project context, session prompt, system message, and context switching examples.

## Open Questions

1. ~~**Generalization**: Do these symbols work across all transformer models?~~ **Yes** — tested across Claude, GPT, Qwen, and local models (32B+). See [README.md § Tested Models](README.md#tested-models).
2. **Stability**: Is behavior consistent across runs with same framework?
3. ~~**Composability**: Can you combine multiple frameworks?~~ **Yes** — EDN statecharts compose by concatenation. See [COMPILER.md § Composability](COMPILER.md#composability).
4. **Discovery**: What other symbols create similar effects?
5. **Minimal set**: What's the smallest effective framework?
6. **Language dependence**: Do non-English models interpret differently?
7. **Training cutoff**: Do newer models interpret better?

## Future Research

- **A/B testing** symbol sets for specific domains
- **Longitudinal studies** of framework evolution
- **Neuroscience parallels** - Do symbols activate specific attention patterns?
- **Formalization** in category theory or type theory
- **Automated discovery** of effective symbol sets via genetic algorithms

## References

- Lambda Calculus: Church (1936)
- Category Theory: Mac Lane (1971)
- Self-Reference: Hofstadter (1979) "Gödel, Escher, Bach"
- Transformer Architecture: Vaswani et al. (2017) "Attention Is All You Need"
- Mathematical Constants: OEIS, mathematical literature

## Conclusion

The symbolic framework is:

- **Proven** - Empirically tested (see game.py)
- **Minimal** - 2 lines, ~80 characters
- **Powerful** - One-shot perfect execution
- **Reproducible** - Framework is transferable
- **Principled** - Mathematical foundation
- **Extensible** - Alternative symbol sets possible

It represents a new paradigm: **Programming AI behavior via mathematical symbol sets** rather than natural language instructions.

## Part of Nucleus

This document is part of the [Nucleus](https://github.com/michaelwhitford/nucleus)
framework — a programming language for AI cognition.

- [README.md](README.md) — Framework overview and symbol reference
- [OPERATOR_ALGEBRA.md](OPERATOR_ALGEBRA.md) — Mathematical operators and collaboration modes
- [EBNF.md](EBNF.md) — Formal grammar for the Nucleus Lambda IR


