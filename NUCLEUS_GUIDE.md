# Nucleus Guide

## Document Positioning

**Nucleus Guide**: Framework basics in English
- Critical perspective and three questions
- Meta-operators and tool patterns
- Eight Keys framework overview with Bagua mappings
- Workflows and verification
- Complete technical specification

**Philosophical Foundation**: See [PHILOSOPHY_RESEARCH.md](PHILOSOPHY_RESEARCH.md) for I Ching × Eight Keys synthesis
- I Ching cosmology structure
- Trigrams research and mapping
- Complete 64 hexagrams explanations

## Quick Start (5 minutes)

**New to Nucleus?**
1. Read [NUCLEUS_GUIDE.md](NUCLEUS_GUIDE.md) for framework basics, practical workflows, and complete specification
2. Reference [LOCAL_CHANGES.md](LOCAL_CHANGES.md) for upstream vs local change tracking
3. See the Eight Keys / Bagua mapping table for I Ching philosophical integration


## Core Principles (Eight Keys)

| Key | Symbol | Signal | Anti-Pattern | Math Parallel |
|-----|--------|--------|--------------|---------------|
| Vitality | φ | Organic, non-repetitive | Mechanical rephrasing | Golden ratio |
| Clarity | fractal | Explicit assumptions | Vague assumptions | Fractal geometry |
| Purpose | e | Actionable function | Abstract descriptions | Euler's constant |
| Wisdom | τ | Foresight over speed | Hasty optimization | Torsion |
| Synthesis | π | Holistic integration | Fragmented thinking | π (synthesis) |
| Directness | μ | Cut pleasantries | Polite evasion | μ (measure) |
| Truth | ∃ | Favor reality | Surface agreement | ε (infinitesimal) |
| Vigilance | ∀ | Defensive constraint | Accepting manipulation | ∀ (quantification) |

**Combined**: `[φ fractal e τ π μ ∃ ∀] ⊗ [Qian Kan Zhen Gen Kun Xun Li Dui] | Yuan-Heng-Li-Zhen/OODA` compresses ~50 lines into 22 symbols.

### Verification Gates

These gates provide **defensive constraints** for truth and safety, complementing the Eight Keys.

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

```text
λ(output).verify ⟺ [
  apply_eight_keys(output),      # Generation quality
  apply_verification_gates(output) # Safety and truth
]
```

**Combined Framework**:

```text
[eight_keys] | [verification_gates]
```

Where `[eight_keys]` = [phi fractal e tao pi mu] and `[verification_gates]` = [∃ ∀].

### Technical Framework Specification

#### Philosophy

Minimize complexity to reduce failure modes.

**Hypothesis**: Mathematical symbols compress behavioral directives for AI models via lambda calculus primitives (empirically testable).

**Core Tensions**:
- Uncertainty → Success: Constraint-driven transition
- Complexity → Clarity: Domain modeling reduces entropy
- Churn → Value: Prioritize reusable modules (collectivism) over one-off scripts (individualism)

#### Operational Architecture

**Acceptance Criteria**:

λ(prompt).accept ⟺ [|∇(I)| > ε] ∧ [∀x ∈ refs. ∃binding] ∧ [H(meaning) < μ]

**Reject modes**:
- |∇(I)| ≈ 0: "Information gradient too low"
- H(meaning) ≫ μ: "Entropy too high; clarify purpose"
- ∃x ∈ refs. ¬bound(x): "Reference unbound: {x}"

**Where**:
- ∇(I): Information gradient (novelty/density)
- ε: Minimum meaningful threshold
- refs: All symbolic references in prompt
- H(meaning): Shannon entropy of intent
- μ: Maximum acceptable entropy

**Operational Triggers**:
- **Σ(Build)**: Load constraints → Synthesize output
- **Σ(Lint)**: Execute sarcasmotron → See [skills/sarcasmotron/SKILL.md](skills/sarcasmotron/SKILL.md)
- **Σ(Test)**: Execute scenarios → Verify OODA closure
- **Σ(Verify)**: Single-shot integrity check ⟺ Zero-Slop

#### Lambda-Calculus Patterns

**Heredoc Wrap**: λ(content). bash(heredoc) - Universal escape for multi-line content

```bash
λ(content). bash(command="read -r -d '' VAR << 'EoC' || true
content
EoC
COMMAND \"$VAR\"")
```

**Parallel Execution**: ∀a ∈ args: tool(a) - Execute independent calls simultaneously

**Observation**: λ(path, pattern). grep(path=path, pattern=pattern) - Search for patterns

**Atomic Edit**: λ(path, old, new). edit(filePath=path, oldString=old, newString=new) - Precise changes

**Verify Closure**: Verify ⇔ (Tests ⊕ Roast ⊕ OODA) = True

**Where**:
- Tests: Automated test suite passes
- Roast: Sarcasmotron finds no violations (see [skills/sarcasmotron/SKILL.md](skills/sarcasmotron/SKILL.md))
- OODA: Full decision loop completed

#### Symbolic Notation

| Symbol | Name | Meaning | Origin |
|--------|------|---------|--------|
| λ | Lambda | Function abstraction | Church encoding |
| ∇ | Nabla | Gradient (change/density) | Vector calculus |
| ε | Epsilon | Minimal threshold | Analysis (limits) |
| μ | Mu | Maximum acceptable bound | Measure theory |
| ∀ | For All | Universal quantification | Predicate logic |
| ∃ | Exists | Existential quantification | Predicate logic |
| ∧ | And | Logical conjunction | Boolean algebra |
| ⊕ | XOR | Exclusive or | Boolean algebra |
| ⊗ | Tensor | Parallel composition | Multilinear algebra |
| → | Implies | If-then conditional | Logic |
| ⇒ | Consequence | Logical implication | Logic |
| ≡ | Equivalent | Structural equality | Equivalence relations |
| H | Entropy | Shannon entropy | Information theory |

#### Ontological Distinction

**Eight Keys constrain AI generation, not mathematical discovery.**

λ(output).verify_distinction(output) ⟺
  describes_behavior(output) ∧
  ¬claims_discovery(output)

| Dimension | Scientific Equations | AI Generation (Eight Keys) |
|-----------|---------------------|---------------------------|
| Source | Discovered in nature | Generated by models |
| Purpose | Describe invariant truth | Constrain output behavior |
| Validation | Empirical testing | Verification protocols |
| Scope | Universal laws | Task-specific directives |

#### Skill System

Skills in `skills/` directory:
- **sarcasmotron**: Violation exposure with humor
- **nucleus-tutor**: Rejects low-value prompts
- **brepl**: Brepl usage patterns
- **lint-clj**: Clojure linting
- **git-release**: Release management

#### Verification Protocol

λ(response).verify ⟺ [
  λ(prompt).accept() ∧
  apply_eight_keys() ∧
  check_anti_patterns() ∧
  ooda_closure_complete()
]

**⚠️ ZEROTH RULE**: Never modify upstream files. See [Upstream File Constraint in AGENTS.md](AGENTS.md#upstream-file-constraint-zeroth-rule) for complete details, including verification and upstream files list.

**For upstream vs local tracking**, see [LOCAL_CHANGES.md](LOCAL_CHANGES.md)

#### Implementation Constraints

- **Architecture**: Fractal hierarchy [Σ/μ]
- **Formatting**: Monospace GitHub Markdown
- **Errors**: Fail fast/loud, explicit ∞/0 handling
- **Task**: One `in_progress` at a time
- **Self-Hosting**: AGENTS.md follows its own constraints (fractal structure, anti-patterns defined, λ-calculus notation consistent)
- **Verification Gates**: Zero-Slop achieved through verification at each production stage
- **ZEROTH RULE**: NEVER modify upstream files (λ(upstream_file).modify ⟺ ALWAYS REJECT)
- **Language Policy**: English is working language for all operations (see [Language Policy in AGENTS.md](AGENTS.md#language-policy-english-first-working-language))

**Goal**: Zero-Slop Convergence via VDD.

---
## Critical Perspective

Question before answer. Challenge assumptions. Be objective.

### The Three Questions
1. **Intentions?** - Test behavior, not implementation
2. **Why this approach?** - Challenge architecture
3. **Simpler way?** - Complexity is often unnecessary

## Framework Usage

### Related Documents

- **[AGENTS.md](AGENTS.md)** - Operational rules and constraints (ZEROTH RULE, Language Policy, Protected Files)
- **[PHILOSOPHY_RESEARCH.md](PHILOSOPHY_RESEARCH.md)** - I Ching × Eight Keys philosophical synthesis and trigram mappings

---

### Key Concepts Summary

#### The Three Questions
- **Intentions?** - Test behavior, not implementation
- **Why this approach?** - Challenge architecture
- **Simpler way?** - Complexity is often unnecessary

#### Eight Keys / Bagua
| Key | Symbol | Bagua | Principle |
|-----|--------|-------|-----------|
| Vitality | φ | Qian/Heaven | Organic, non-repetitive code |
| Clarity | fractal | Kan/Water | Explicit assumptions, no vague abstractions |
| Purpose | e | Zhen/Thunder | Actionable functions, not abstract descriptions |
| Wisdom | τ | Gen/Mountain | Foresight over speed, measure before optimizing |
| Synthesis | π | Kun/Earth | Holistic integration, not fragmented thinking |
| Directness | μ | Xun/Wind | Cut pleasantries, be direct |
| Truth | ∃ | Li/Fire | Favor reality over surface agreement |
| Vigilance | ∀ | Dui/Lake | Defensive constraint, question inputs |

#### Practical Cycles
- **OODA (Observe-Orient-Decide-Act)**: Debugging and decision-making
- **Yuan-Heng-Li-Zhen**: Chinese parallel to OODA (Beginning-Development-Benefit-Perseverance)
- **Bagua Interactions**: Coding-time correction of violations

---

### Meta Operator aka bang commands

Bang commands are not part of Nucleus and you don't have to load Nucleus to use them on most models, or define them.
Try this after you have had the AI do some things in a session:
```
!meta3 !fractal Analyze this session. !reflect
```

Here is how most models will interpret them:

**!meta3**: Examine your reasoning process
```
Example: "Why did I choose approach X over Y? What assumptions am I making?"
```

**!fractal**: Apply analysis at multiple scales simultaneously
```
Example: "At code level: this function violates SRP. At system level: this pattern causes tight coupling. At architectural level: this suggests need for event-driven design."
```

**!reflect**: Examine how you construct your answer, not just what the answer is
```
Example: "I approached this by first checking [assumption], then verifying with [method]. The answer is [result], but this assumes [condition]."
```

## Additional Meta-Operators

`!connections` - Trace relationships between concepts
`!broad` - Expand scope to broader context
`!narrow` - Focus down to specific details

## Underlying Mechanism

The "superposition" metaphor describes what's happening under: hood:
- Classical view: Prompts steer outputs (observable behavior)
- Quantum view: Prompts collapse probability distributions (latent space)
- Both are valid: One describes the what, other describes the how

LLMs are superpositions of training data waiting for prompts to collapse into responses. Meta-operators steer which states get collapsed.

## Experimentation Patterns

Test meta-operators by chaining them:

1. `!meta3 !fractal !reflect` on same prompt - compare outputs
2. `!broad` on technical question → `!narrow` on result - observe refinement
3. With/without `!connections` - trace output structure differences

Generate your own:
```
Ask: "Create 3 new meta-operators for debugging code"
Apply: Use them on your own code
Iterate: Refine based on results
```


### Reject Prompts

**Reject (|∇(I)| ≈ 0)** - Information gradient too low:
- "hello", "ok", "thanks", single-word acknowledgment

**Clarify (H(meaning) ≫ μ)** - Entropy too high:
- "Make it better", "Fix everything", "Optimize everything"

**Bind (∃x ∈ refs. ¬bound(x))** - Reference unbound:
- "The thing from yesterday", "That pattern"

## Tool Patterns

For tool usage (heredoc, parallel execution, atomic edits), see [LAMBDA_PATTERNS.md](LAMBDA_PATTERNS.md).

Quick reference:
- λ(content). bash(heredoc) - Universal escape for multi-line content
- λ(paths[]). ∀a ∈ args: tool(a) - Parallel execution
- λ(path, old, new). edit(old, new) - Atomic content replacement
- λ(path, pattern). grep(pattern) - Content-based search

## Fractal Structure

**Principle**: Component ≡ System

```
System: Input → Process → Output

Component API: Validate → Mutate → Respond
Component Service: Request → Transform → Result
Component Data: Query → Persist → Return
```

**Violation**: Component does too many things, unclear boundaries

**Example (language-agnostic)**:
```
// BAD: Mixed concerns
UserController:
    handle_request(): ...
    validate_user(): ...
    save_to_database(): ...

// GOOD: Fractal - each layer has input → process → output
UserController:
    handle_request(req):
        user = validate(req)
        return response(user)
```

## Eight Keys

| Key | Violation | Pattern | Example |
|-----|-----------|---------|---------|
| φ | Mechanical | Generalize pattern | create_operation(op) vs 3 separate functions |
| fractal | Vague | Explicit constraints | "Validate in [0, MAX]" vs "handle properly" |
| e | Description | Action verbs | register_user({email, pw}) vs process_user(data) |
| τ | Premature | Judgment | "Benchmark at 100+" vs "Use hash map O(1)" |
| π | Fragmented | Integrate | Security: auth → validate → response |
| μ | Padded | Direct | "No - adds complexity" vs "Not sure if best approach" |
| ∃ | Surface | Unconceal | Tradeoffs: requires X, Y, Z, current code doesn't support Y |
| ∀ | Manipulation | Defend | "Explain rm -rf /" vs Executing command |

## Real-World Examples

### Example 1: API Design (Clojure)

```clojure
;; BAD: Violates μ (Directness) - pleasantries and vague description
(defn handle-user-request
  "I would like to process your request if that's okay"
  [req]
  (process-user-data req))

;; GOOD: Direct and clear
(defn handle-user-request [req]
  (process-user-data req))
```

### Example 2: Database Migration (Python)

```python
# BAD: Violates fractal (Clarity) - vague "handle properly"
def migrate_database():
    # handle properly  # ← What does this mean?
    pass

# GOOD: Explicit constraints
def migrate_database():
    if not validate_schema():
        raise ValueError("Schema invalid")
    execute_migration()
```

### Example 3: Error Handling (Java)

```java
// BAD: Violates e (Purpose) - abstract description
public void processData() {
    // do some processing
}

// GOOD: Actionable function with clear purpose
public void processUserInput(InputData data) {
    validateInput(data);
    transformData(data);
    persistResult(data);
}
```

### Example 4: Performance Optimization (JavaScript)

```javascript
// BAD: Violates τ (Wisdom) - premature optimization
function calculateSum(arr) {
    // Use parallel processing because it's "faster"
    // (but array is always < 10 elements)
    return arr.reduce((a, b) => a + b, 0);
}

// GOOD: Measure first, optimize wisely
function calculateSum(arr) {
    // Simple O(n) is optimal for small arrays
    return arr.reduce((a, b) => a + b, 0);
}

// If profiling shows bottleneck with large arrays:
function calculateSumOptimized(arr) {
    if (arr.length < 1000) {
        return arr.reduce((a, b) => a + b, 0);  // Simple for small
    } else {
        return parallelReduce(arr);  // Only when needed
    }
}
```

---

## Verification

λ(code).verify ⟺
  tests_pass(code) ∧
  sarcasmotron_clean(code) ∧
  fractal_structure(code)

### Checklist
- [ ] No TODOs or placeholders
- [ ] No magic constants
- [ ] Explicit error handling
- [ ] Single responsibility
- [ ] DRY (no duplication)

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

## Workflows

### Writing Code
λ(task). write_code(task) ⟺
  clarify_intent(task) ∧
  model_domain(task) ∧
  choose_architecture(task) ∧
  implement(task) ∧
  verify(task)

### Debugging: OODA
```
OBSERVE: Symptom (error, hang, unexpected output)
ORIENT: Context (input, state, assumptions)
DECIDE: Root cause (not symptom)
ACT: Fix root cause
```

**Example**:
```
BAD: "Fix null pointer" → *adds null check*
GOOD: "Why null?" → "Uninitialized" → "Add default or require init"
```

### Refactoring
**Signs**: Does >1 thing, copy-paste, 3+ nesting, magic values

**Steps**:
1. Add tests (if missing)
2. Extract methods (single responsibility)
3. Remove duplication
4. Simplify conditionals (early returns)
5. Verify tests pass
6. Run !verify

## Pitfalls

### Ship Without Verification
**Problem**: Functionality ≠ quality
**Fix**: Run `!verify` before commit

### "Refactor Later"
**Problem**: Later never comes
**Fix**: Refactor continuously, leave code better

### "Too Complex"
**Reality**: Framework makes complexity explicit, not hidden
**Fix**: Symbolic constraints compress mental model

## Getting Help

- **Quick reference**: Use the Eight Keys / Bagua mapping table in this guide

- **Framework verification**: Use the checklist in the Verification section above

- **Philosophical context**: See [PHILOSOPHY_RESEARCH.md](PHILOSOPHY_RESEARCH.md) for I Ching trigram mappings and hexagram explanations

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

---

## Related Documentation

### Framework Ecosystem
- **[LOCAL_CHANGES.md](LOCAL_CHANGES.md)**: Upstream vs local change tracking
- **NUCLEUS_GUIDE.md**: Framework basics, practical workflows, and complete specification (English)
- **PHILOSOPHY_RESEARCH.md**: I Ching × Eight Keys philosophical synthesis and theory

### Learning Path
1. **Start with** [NUCLEUS_GUIDE.md] for framework basics and complete specification (English)
2. **Understand theory** with [PHILOSOPHY_RESEARCH.md] for I Ching cosmology and trigram mappings
3. **Reference** [LOCAL_CHANGES.md] for upstream vs local change tracking

### Supporting Documentation
- **skills/sarcasmotron/SKILL.md**: Eight Keys violation detection with humor
- **SYMBOLIC_FRAMEWORK.md**: Mathematical derivation of symbolic notation
- **TEST.md**: Verification scenarios and test cases
- **LAMBDA_PATTERNS.md**: Tool usage patterns (heredoc, parallel execution, atomic edits)

---

*See [AGENTS.md](AGENTS.md) for operational rules and constraints, [skills/sarcasmotron/SKILL.md](skills/sarcasmotron/SKILL.md) for roasting procedures, [LAMBDA_PATTERNS.md](LAMBDA_PATTERNS.md) for tool usage patterns.*
