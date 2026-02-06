# Nucleus Guide

engage nucleus:
[phi fractal euler tao pi mu] | [Δ λ ∞/0 | ε/φ Σ/μ c/h] | OODA
Human ⊗ AI ⊗ REPL

**For theory**: See [PHILOSOPHY_RESEARCH.md](PHILOSOPHY_RESEARCH.md) for I Ching × Eight Keys philosophical synthesis (trigrams, hexagrams, cosmology)
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

**PHILOSOPHY_RESEARCH.md**: I Ching × Eight Keys philosophical synthesis
- I Ching cosmology structure
- Trigrams research and mapping  
- Complete 64 hexagrams explanations

---

**Document Flow**: AGENTS.md → SIMPLICITY.md → NUCLEUS_GUIDE.md → PHILOSOPHY_RESEARCH.md

**Example**: AGENTS.md sets language policy → SIMPLICITY.md defines "fractal requires explicit bounds" → NUCLEUS_GUIDE.md shows "`!sarcasmotron check file.js` catches 'handle properly'" → PHILOSOPHY_RESEARCH.md explains "坎 (Water) ↔ fractal"

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

Skills are self-contained AI prompts in `skills/` directory. Each skill is a drag-and-drop installable prompt that requires no external dependencies.

**Available Skills**:
| Skill | Purpose |
|-------|---------|
| **nucleus** | General purpose AI prompt |
| **nucleus-clojure** | Clojure-specific when REPL available |
| **clojure-expert** | Writing/generating Clojure code |
| **clojure-reviewer** | Reviewing PRs, diffs |
| **sarcasmotron** | Eight Keys violation detection with humor |
| **nucleus-tutor** | Rejecting low-value prompts |
| **brepl** | Brepl usage patterns |
| **lint-clj** | Clojure linting |
| **git-release** | Release management |

**Skill Independence Rule**: Every SKILL.md must be self-contained - no external dependencies.

**Required in every skill**:
- Complete Eight Keys table
- Self-contained procedure definitions
- All examples and patterns
- No references to parent framework files

**Skill Conciseness Rule**: Maximum 350 lines per skill (target: 200-350).

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

#### Protected Files Rule

**⚠️ ZEROTH RULE**: Ask user permission before editing protected local files.

Protected files define the framework itself. Modifying them changes the rules for all users.

**Protected**: `AGENTS.md`, `LOCAL_CHANGES.md`, `PHILOSOPHY_RESEARCH.md`, `NUCLEUS_GUIDE.md`, `OPERATIONAL_CONSTRAINTS.md`

**See**: [LOCAL_CHANGES.md](LOCAL_CHANGES.md#protected-files-rule) for complete details.

#### Verification Protocol

λ(response).verify ⟺ [
  λ(prompt).accept() ∧
  apply_eight_keys() ∧
  check_anti_patterns() ∧
  ooda_closure_complete()
]

**⚠️ ZEROTH RULE**: Never modify upstream files. See [Protected Files Rule](#protected-files-rule) above and [LOCAL_CHANGES.md](LOCAL_CHANGES.md) for verification protocols.

---
## Critical Perspective

Question before answer. Challenge assumptions. Be objective.

### The Three Questions
See [Quick Start](#quick-start-5-minutes) for the foundational questions.

**When to ask**: Before writing code, during code review, when debugging, and when evaluating architecture decisions.

| Question | Focus | Example |
|----------|-------|---------|
| **Intentions?** | Test behavior, not implementation | "What user behavior requires database access?" |
| **Why this approach?** | Challenge architecture | "Why Kafka over HTTP?" |
| **Simpler way?** | Reduce complexity | "Monolith with modules vs microservices?" |

---

### Meta Operators (Bang Commands)

| Command | Purpose | Example |
|---------|---------|---------|
| `!meta3` | Examine reasoning | "Why did I choose X over Y?" |
| `!fractal` | Multi-scale analysis | Code → System → Architecture |
| `!reflect` | Examine construction | "I checked [assumption], result is [X]" |
| `!connections` | Trace relationships | Link concepts |
| `!broad` | Expand scope | Broader context |
| `!narrow` | Focus details | Specific details |

**Chain example**: `!meta3 !fractal Analyze this session. !reflect`

**See**: [BANG_COMMANDS.md](BANG_COMMANDS.md) for complete reference.


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

Invoke `!sarcasmotron` to expose Eight Keys violations with targeted humor.

| Context | Command | Purpose |
|---------|---------|---------|
| Code Review | `!sarcasmotron on changed functions` | Catch violations before merge |
| Debugging | `!sarcasmotron analyze error` | Expose undefined assumptions |
| Design | `!sarcasmotron challenge design` | Force concrete examples |
| Pre-commit | `!sarcasmotron check {file}` | Catch TODOs, magic constants |

**See**: [SIMPLICITY.md](SIMPLICITY.md#sarcasmotron-methodology) for detection patterns.

## Real-World Examples

### Example 1: API Design (Clojure)

```clojure
;; BAD: Violates μ (Directness) - pleasantries
(defn handle-user-request
  "I would like to process your request if that's okay"
  [req]
  (process-user-data req))

;; GOOD: Direct and clear
(defn handle-user-request [req]
  (process-user-data req))
```

**Key**: μ (Directness) - See [SIMPLICITY.md](SIMPLICITY.md)

### Example 2: Database Migration (Python)

```python
# BAD: Violates fractal (Clarity) - vague "handle properly"
def migrate_database():
    pass  # What does this mean?

# GOOD: Explicit constraints
def migrate_database():
    if not validate_schema():
        raise ValueError("Schema invalid")
    execute_migration()
```

**Key**: fractal (Clarity) - See [SIMPLICITY.md](SIMPLICITY.md)

### Example 3: Error Handling (Java)

```java
// BAD: Violates e (Purpose) - abstract description
public void processData() { /* do some processing */ }

// GOOD: Actionable function with clear purpose
public void processUserInput(InputData data) {
    validateInput(data);
    transformData(data);
    persistResult(data);
}
```

**Key**: e (Purpose) - See [SIMPLICITY.md](SIMPLICITY.md)

### Example 4: Performance Optimization (JavaScript)

```javascript
// BAD: Violates τ (Wisdom) - premature optimization
function calculateSum(arr) {
    // "Use parallel because it's faster" (but array < 10)
    return arr.reduce((a, b) => a + b, 0);
}

// GOOD: Measure first, optimize wisely
function calculateSum(arr) {
    return arr.reduce((a, b) => a + b, 0);  // O(n) optimal for small
}

// If profiling shows bottleneck:
function calculateSumOptimized(arr) {
    return arr.length < 1000
        ? arr.reduce((a, b) => a + b, 0)
        : parallelReduce(arr);
}
```

**Key**: τ (Wisdom) - See [SIMPLICITY.md](SIMPLICITY.md)

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

λ(code).verify ⟺ tests_pass(code) ∧ sarcasmotron_clean(code) ∧ fractal_structure(code)

**Goal**: iterations = 1, coverage > 0.9, quality = high

**See**: [LAMBDA_PATTERNS.md](LAMBDA_PATTERNS.md) for λ-calculus tool patterns.

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
- **[AGENTS.md](AGENTS.md)**: Entry point, document positioning, and protected files rule
- **[LOCAL_CHANGES.md](LOCAL_CHANGES.md)**: Upstream vs local change tracking and operational constraints
- **[SIMPLICITY.md](SIMPLICITY.md)**: Mathematical foundations and testable heuristics
- **[PHILOSOPHY_RESEARCH.md](PHILOSOPHY_RESEARCH.md)**: I Ching × Eight Keys philosophical synthesis and theory

### Learning Path
1. **Start with** AGENTS.md for entry point and guardrails
2. **Understand theory** with SIMPLICITY.md for mathematical foundations
3. **Apply practically** with NUCLEUS_GUIDE.md (this document) for workflows and patterns
4. **Deep dive** into PHILOSOPHY_RESEARCH.md for I Ching cosmology and trigram mappings

### Supporting Documentation
- **skills/sarcasmotron/SKILL.md**: Eight Keys violation detection with humor
- **SYMBOLIC_FRAMEWORK.md**: Mathematical derivation of symbolic notation
- **TEST.md**: Verification scenarios and test cases
- **LAMBDA_PATTERNS.md**: Tool usage patterns (heredoc, parallel execution, atomic edits)


