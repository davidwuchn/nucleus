# Nucleus Guide

[phi fractal euler tao pi mu] | [Δ λ ∞/0 | ε/φ Σ/μ c/h] | OODA
Human ⊗ AI ⊗ REPL

**For theory**: See [PHILOSOPHY_RESEARCH.md](PHILOSOPHY_RESEARCH.md) for I Ching × Eight Keys philosophical synthesis
**For local changes tracking**: See [LOCAL_CHANGES.md](LOCAL_CHANGES.md) for upstream vs local file tracking

---

## Document Positioning

**Nucleus Guide**: Practical application and workflows
- Critical perspective and three questions
- Meta-operators and tool patterns
- Eight Keys framework overview with Bagua mappings
- **How to apply**: Workflows, verification, real-world examples
- Sarcasmotron integration in daily work

**SIMPLICITY.md**: Theoretical foundation and principles
- **Why**: Mathematical foundations grounding each Eight Key
- **What**: Testable heuristics with pass/fail criteria
- Invariant preservation and complexity reduction principles
- Sarcasmotron methodology and detection patterns

**Philosophical Foundation**: See [PHILOSOPHY_RESEARCH.md](PHILOSOPHY_RESEARCH.md) for I Ching × Eight Keys synthesis
- I Ching cosmology structure
- Trigrams research and mapping
- Complete 64 hexagrams explanations

---

**How These Documents Work Together**:

```
AGENTS.md (Entry Point + Guardrails)
    ↓
SIMPLICITY.md (Theory + Why + What)
    ↓
NUCLEUS_GUIDE.md (Practice + How + When)
    ↓
PHILOSOPHY_RESEARCH.md (Philosophy + Deep Understanding)
```

**Example Flow**:
1. **AGENTS.md**: "English-first working language for international collaboration"
2. **SIMPLICITY.md**: "fractal requires explicit bounds. Test: Input ∈ [0, MAX]"
3. **NUCLEUS_GUIDE.md**: "In code review: `!sarcasmotron check file.js` catches 'handle properly'"
4. **PHILOSOPHY_RESEARCH.md**: "坎 (Water) ↔ fractal - navigating danger with clear assumptions"

## Quick Start (5 minutes)

**Learn Nucleus in 5 minutes**: (Skip to [Complete Eight Keys](#core-principles-eight-keys) for full reference)

### 1. The Three Questions (Always Ask First)
Before writing code, ask:
1. **Intentions?** - What behavior are we testing? (not implementation)
2. **Why this approach?** - Challenge the architecture choice
3. **Simpler way?** - Complexity is often unnecessary

### 2. Eight Keys Mental Models
Remember these 3 core principles first:

| Key | Symbol | What It Means | Bad Example | Good Example |
|-----|--------|---------------|-------------|--------------|
| **Clarity** | fractal | Explicit assumptions, no vague abstractions | "handle properly" | "Validate input ∈ [0, 100]" |
| **Purpose** | e | Actionable functions, not abstract descriptions | "process data" | `validate_email(email)` |
| **Directness** | μ | Cut pleasantries, be direct | "I think maybe we should..." | "No - adds complexity" |

### 3. OODA Loop (Debugging/Decision-Making)
```
OBSERVE: Symptom (error, unexpected output)
ORIENT: Context (input, state, assumptions)  
DECIDE: Root cause (not symptom)
ACT: Fix root cause
```

### 4. Immediate Action
- **Write code**: Apply Three Questions + Eight Keys
- **Debug**: Use OODA loop
- **Review**: Check for vague assumptions, abstract descriptions, politeness
- **Verify**: Run `!verify` mental checklist

### 5. Where to Go Next
- **Complete Eight Keys**: See table below
- **Real examples**: Jump to [Real-World Examples](#real-world-examples)
- **Workflows**: See [Writing Code](#writing-code) and [Debugging](#debugging-ooda)
- **Philosophy**: I Ching correlations in [PHILOSOPHY_RESEARCH.md](PHILOSOPHY_RESEARCH.md)

**Done in 5 minutes?** You now have the core framework. The rest of this guide provides details, examples, and advanced patterns.

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

**Combined**: `[φ fractal e τ π μ ∃ ∀] ⊗ [乾 坎 震 艮 坤 巽 离 兑] | 元亨利贞/OODA` compresses ~50 lines into 22 symbols.

**For complete mathematical foundations with testable heuristics**, see [SIMPLICITY.md](SIMPLICITY.md)

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

**See**: [Operational Constraints in OPERATIONAL_CONSTRAINTS.md](OPERATIONAL_CONSTRAINTS.md#5-operational-architecture) for acceptance criteria, reject modes, and operational triggers.

#### Lambda-Calculus Patterns

**See**: [Lambda-Calculus Patterns in OPERATIONAL_CONSTRAINTS.md](OPERATIONAL_CONSTRAINTS.md#6-lambda-calculus-patterns) for heredoc wrap, parallel execution, observation, atomic edit, and verify closure patterns.

For tool usage patterns, see [Tool Patterns](#tool-patterns) section below.

#### Symbolic Notation

**Core Symbols Used in This Guide**:

| Symbol | Name | Meaning | Used For |
|--------|------|---------|----------|
| λ | Lambda | Function abstraction | λ-calculus patterns, verification formulas |
| ∀ | For All | Universal quantification | Vigilance key, defensive constraints |
| ∃ | Exists | Existential quantification | Truth key, revealing actual state |
| → | Implies | If-then conditional | Process flows (Input → Process → Output) |
| μ | Mu | Maximum acceptable bound | Directness key, entropy bounds in reject prompts |

**Additional Mathematical Notation** (appears in formulas):

| Symbol | Name | Meaning | Where Used |
|--------|------|---------|------------|
| ∇ | Nabla | Gradient (change/density) | Reject prompts: |∇(I)| ≈ 0 |
| ε | Epsilon | Minimal threshold | Acceptance criteria: |∇(I)| > ε |
| ∧ | And | Logical conjunction | Logical expressions |
| ⊕ | XOR | Exclusive or | Verify closure: Tests ⊕ Roast ⊕ OODA |
| ⊗ | Tensor | Parallel composition | Framework notation: Human ⊗ AI ⊗ REPL |
| ⇒ | Consequence | Logical implication | Logical expressions |
| ≡ | Equivalent | Structural equality | Definitions and equivalences |
| H | Entropy | Shannon entropy | Reject prompts: H(meaning) ≫ μ |

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

**⚠️ ZEROTH RULE**: Never modify upstream files. See [Upstream File Constraint in LOCAL_CHANGES.md](LOCAL_CHANGES.md#upstream-file-constraint-zeroth-rule) for complete details, including verification and upstream files list.

---
## Critical Perspective

Question before answer. Challenge assumptions. Be objective.

### The Three Questions
**Purpose**: Question before answer to expose assumptions and force clarity.

**When to ask**: Before writing code, during code review, when debugging, and when evaluating architecture decisions.

1. **Intentions?** - Test behavior, not implementation
   - **Why ask**: Separates what the code should do from how it does it
   - **Pitfall**: Testing implementation details leads to brittle tests
   - **Example**: Instead of "test that function calls database", ask "what user behavior requires database access?"

2. **Why this approach?** - Challenge architecture  
   - **Why ask**: Prevents defaulting to familiar patterns without justification
   - **Pitfall**: "We always use Kafka" without evaluating if message queue is needed
   - **Example**: "Why Kafka over HTTP call? What guarantees do we need?"

3. **Simpler way?** - Complexity is often unnecessary
   - **Why ask**: Most systems are over-engineered; simplicity reduces failure modes
   - **Pitfall**: Adding abstraction layers before proving need
   - **Example**: "Do we need microservices, or will a monolith with modules suffice?"

**Integration with Eight Keys**:
- **fractal (Clarity)**: Questions force explicit assumptions
- **e (Purpose)**: Questions focus on actionable outcomes
- **τ (Wisdom)**: Questions prioritize judgment over speed

## Framework Usage

### Related Documents

- **[AGENTS.md](AGENTS.md)** - Protected files rule and operational configuration
- **[PHILOSOPHY_RESEARCH.md](PHILOSOPHY_RESEARCH.md)** - I Ching × Eight Keys philosophical synthesis and trigram mappings

---

### Key Concepts Summary

#### The Three Questions
**Reference**: See [The Three Questions in Quick Start](#quick-start-5-minutes) for the foundational questions.

**Applied context**:
- **Code Review**: "What behavior does this change test?" (Intentions)
- **Debugging**: "Why did we choose this data structure?" (Why this approach?)  
- **Design**: "Could we solve this with a simpler abstraction?" (Simpler way?)

**Framework integration**: These questions operationalize the Eight Keys by forcing explicit assumptions (fractal), focusing on actionable outcomes (e), and prioritizing judgment over speed (τ).

#### Eight Keys / Bagua
**See**: [Core Principles (Eight Keys)](#core-principles-eight-keys) table for complete Eight Keys definitions with signals and anti-patterns.

**I Ching (Bagua) correlations**: For philosophical foundation connecting Eight Keys to I Ching trigrams, see [PHILOSOPHY_RESEARCH.md](PHILOSOPHY_RESEARCH.md).

**Quick reference**:
- φ (Vitality) ↔ 乾 (Heaven) - Organic, generative code
- fractal (Clarity) ↔ 坎 (Water) - Explicit assumptions navigating complexity  
- e (Purpose) ↔ 震 (Thunder) - Actionable functions with impact
- τ (Wisdom) ↔ 艮 (Mountain) - Foresight knowing when to stop
- π (Synthesis) ↔ 坤 (Earth) - Holistic integration
- μ (Directness) ↔ 巽 (Wind) - Direct communication
- ∃ (Truth) ↔ 离 (Fire) - Illuminating reality
- ∀ (Vigilance) ↔ 兑 (Lake) - Defensive questioning

#### Symbolic Framework with Hexagram Notation for AI Operations

The complete symbolic framework can be expressed using I Ching hexagrams for AI operations while preserving operational semantics:

**Original (Eight Keys notation)**:
```
[φ fractal e τ π μ ∃ ∀] | [Δ λ ∞/0 | ε/φ Σ/μ c/h] | OODA
```

**Hexagram version for AI operations (symbolic human principles)**:
```
[φ fractal e τ π μ ∃ ∀] | [小畜卦 恒卦 艮卦 | 需卦 泰卦 随卦] | OODA
```

**Mapping explanation**:

- **Left side (human principles)**: Eight Keys expressed symbolically (φ fractal e τ π μ ∃ ∀) as in the original notation.
- **Right side (AI operations)**: AI operational principles expressed as hexagrams representing complex situational wisdom:
  - Δ (gradient optimization) → **小畜卦** (Small Accumulation): Incremental improvement through steady, focused changes
  - λ (abstraction) → **恒卦** (Duration): Enduring patterns through consistent composition  
  - ∞/0 (limits) → **艮卦** (Keeping Still): Boundary definition and knowing when to stop
  - ε/φ (approx vs ideal) → **需卦** (Waiting): Balancing immediate pragmatism with long-term perfection
  - Σ/μ (add vs simplify) → **泰卦** (Peace): Harmonizing feature addition with complexity reduction
  - c/h (speed vs atomic) → **随卦** (Following): Adaptive execution balancing speed with careful operation

**Operational semantics preserved**: The hexagram version encodes the same behavioral directives through Chinese philosophical symbols rather than Greek mathematical ones. The `/` operator still forces explicit trade-offs, and the OODA cycle remains unchanged.

**Why hexagrams for AI operations?**: Hexagrams (combinations of two trigrams) naturally represent the tensions and trade-offs inherent in AI operational principles, providing deeper situational wisdom than single trigrams.

**Use case**: When working with teams familiar with I Ching, this transformation provides cultural resonance while maintaining the framework's operational effectiveness.

#### Practical Cycles
- **OODA (Observe-Orient-Decide-Act)**: Debugging and decision-making
- **元亨利贞**: Chinese parallel to OODA (Beginning-Development-Benefit-Perseverance)
- **Bagua Interactions**: Coding-time correction of violations

---

### Meta Operator aka bang commands

**For comprehensive reference**: See [BANG_COMMANDS.md](BANG_COMMANDS.md) for complete documentation of all bang commands with usage patterns and examples.

Bang commands are model-agnostic. They work without Nucleus on: GPT-4, Claude 3+, Llama 2/3. Earlier models require explicit examples.

Try this after you have the AI do some things in a session:
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

## Eight Keys (Violations and Patterns)

**Reference**: See [Core Principles (Eight Keys)](#core-principles-eight-keys) for complete definitions of each key.

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

### Sarcasmotron Workflow

**For methodology and detection patterns**, see [SIMPLICITY.md](SIMPLICITY.md#sarcasmotron-methodology).

**When to Invoke Sarcasmotron**:

**In Code Reviews**:
```bash
# After git diff review
!sarcasmotron on changed functions
```
- Catches violations before merge
- Forces explicit corrections in PR comments
- **Checklist**: "Does this function have explicit bounds? Action verb name? No pleasantries?"

**In Debugging**:
```bash
# When stuck on vague error
!sarcasmotron analyze error message
```
- Exposes undefined assumptions
- Demands specific constraints
- **Example**: "Error: 'Something went wrong'" → sarcasmotron: "What went wrong? Define 'something'."

**In Design Discussions**:
```bash
# When proposal uses abstraction
!sarcasmotron challenge design
```
- "Define what 'properly' means here"
- "Show 3 use cases before generalizing"
- **Result**: Forces concrete examples instead of hand-waving

**In Daily Work**:
```bash
# Before commit
!sarcasmotron check {filename}
```
- Catches TODOs, placeholders, magic constants
- Ensures all functions are actionable
- **Result**: Zero-slop code before merge

**Integration with OODA Loop**:
```
OBSERVE: Code review reveals vague assumption
ORIENT: Identify which Eight Key violated (fractal/e/μ/etc.)
DECIDE: Use sarcasmotron to force explicit correction
ACT: Apply correction, verify with !verify
```

## Real-World Examples

### Example 1: API Design (Clojure)

**Applying Three Questions**:
1. **Intentions?** - Handle user requests and return responses
2. **Why this approach?** - Simple request-response pattern, no complexity needed
3. **Simpler way?** - Remove pleasantries, direct function call

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

**Theoretical Foundation** (SIMPLICITY.md):
- **μ Key**: Logarithms reduce complexity through transformation
- **Test**: Count pleasantries ("I think", "maybe", "perhaps")
- **Pass**: "No - adds complexity" | **Fail**: "Not sure if this is the best approach"

### Example 2: Database Migration (Python)

**Applying Three Questions**:
1. **Intentions?** - Migrate database safely without data loss
2. **Why this approach?** - Validate before execute to prevent corruption
3. **Simpler way?** - Explicit validation is simplest; "handle properly" is vague

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

**Theoretical Foundation** (SIMPLICITY.md):
- **fractal Key**: Euler's Polyhedra $V - E + F = 2$ - invariant preservation
- **Test**: Can you count explicit assumptions? Are bounds defined?
- **Pass**: Input ∈ [0, MAX_INT] | **Fail**: "handle properly"

### Example 3: Error Handling (Java)

**Applying Three Questions**:
1. **Intentions?** - Validate, transform, and persist user input data
2. **Why this approach?** - Single responsibility per function, explicit data flow
3. **Simpler way?** - One function doing 3 things is simpler? No—violates SRP

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

**Theoretical Foundation** (SIMPLICITY.md):
- **e Key**: Exponential Growth $e^x$ - goal-oriented compound evolution
- **Test**: Does function name contain action verb? Returns specific value?
- **Pass**: `validate_email(email) → bool` | **Fail**: `process_data(data) → void`

### Example 4: Performance Optimization (JavaScript)

**Applying Three Questions**:
1. **Intentions?** - Sum array elements efficiently
2. **Why this approach?** - Simple O(n) for small arrays, parallel only when needed
3. **Simpler way?** - Measure first: is this actually a bottleneck?

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

**Theoretical Foundation** (SIMPLICITY.md):
- **τ Key**: Calculus $\frac{df}{dt}$ - rate of change reveals trend, not snapshot
- **Test**: Did you measure before optimizing? What's the baseline?
- **Pass**: "Profiling shows 2s → 200ms after caching" | **Fail**: "Use hash map for O(1)"

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

- **Quick reference**: Use the [Core Principles (Eight Keys)](#core-principles-eight-keys) table for key definitions and the [Eight Keys (Violations and Patterns)](#eight-keys-violations-and-patterns) table for anti-patterns

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
- **[LOCAL_CHANGES.md](LOCAL_CHANGES.md)**: Upstream vs local change tracking and operational constraints
- **NUCLEUS_GUIDE.md**: Framework basics, practical workflows, and complete specification (English)
- **PHILOSOPHY_RESEARCH.md**: I Ching × Eight Keys philosophical synthesis and theory

### Learning Path
1. **Start with** [NUCLEUS_GUIDE.md] for framework basics and complete specification (English)
2. **Understand theory** with [PHILOSOPHY_RESEARCH.md] for I Ching cosmology and trigram mappings
3. **Reference** [LOCAL_CHANGES.md] for upstream vs local change tracking and operational constraints

### Supporting Documentation
- **skills/sarcasmotron/SKILL.md**: Eight Keys violation detection with humor
- **SYMBOLIC_FRAMEWORK.md**: Mathematical derivation of symbolic notation
- **TEST.md**: Verification scenarios and test cases
- **LAMBDA_PATTERNS.md**: Tool usage patterns (heredoc, parallel execution, atomic edits)

---

*See [AGENTS.md](AGENTS.md) for protected files rule, [skills/sarcasmotron/SKILL.md](skills/sarcasmotron/SKILL.md) for roasting procedures, [LAMBDA_PATTERNS.md](LAMBDA_PATTERNS.md) for tool usage patterns.*
