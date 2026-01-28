# Bang Commands Reference

**Model-agnostic meta-operators for AI collaboration**

```
[phi fractal euler tao pi mu] | [Δ λ ∞/0 | ε/φ Σ/μ c/h] | OODA
Human ⊗ AI ⊗ REPL
```

## Document Positioning

**BANG_COMMANDS.md**: Comprehensive reference for bang commands in the Nucleus framework
- **Purpose**: Extract and document all bang command patterns for easy reference
- **What**: Complete documentation of meta-operators with examples and usage patterns
- **Role**: Quick reference guide for daily use
- **Source**: Extracted from NUCLEUS_GUIDE.md and skills/sarcasmotron/SKILL.md

**Related Documents**:
- **[NUCLEUS_GUIDE.md](NUCLEUS_GUIDE.md)**: Complete framework specification including bang commands section
- **[skills/sarcasmotron/SKILL.md](skills/sarcasmotron/SKILL.md)**: Detailed sarcasmotron implementation
- **[AGENTS.md](AGENTS.md)**: Framework guardrails and operational configuration

---

## Overview

Bang commands are **model-agnostic meta-operators** that work without the Nucleus framework on modern AI models (GPT-4, Claude 3+, Llama 2/3). They trigger specific reasoning patterns and analytical modes, encoding the framework's values in operational form.

**Design Philosophy**:
1. **Symbolic compression**: Encode complex analytical modes into simple triggers
2. **Cognitive scaffolding**: Provide structure for systematic thinking  
3. **Zero-slop enforcement**: Catch vague assumptions and undefined terms
4. **Progressive disclosure**: Start with core commands before framework-specific ones

---

## Core Meta-Operators (Model-Agnostic)

These commands work on any capable AI model without framework knowledge.

### !meta3 - **Examine Reasoning Process**
**Purpose**: Forces introspection about decision-making and assumptions.
**Example**: `"Why did I choose approach X over Y? What assumptions am I making?"`
**Use case**: When you need to understand the reasoning behind an AI's response or your own thought process.

### !fractal - **Multi-Scale Analysis**
**Purpose**: Apply analysis at multiple scales simultaneously (code → system → architecture).
**Example**: 
```
"At code level: this function violates SRP.
At system level: this pattern causes tight coupling.
At architectural level: this suggests need for event-driven design."
```
**Use case**: For comprehensive technical analysis that connects implementation details to broader design implications.

### !reflect - **Examine Answer Construction**
**Purpose**: Analyze how an answer is constructed, not just what the answer is.
**Example**: `"I approached this by first checking [assumption], then verifying with [method]. The answer is [result], but this assumes [condition]."`
**Use case**: When you need to understand the methodology behind a solution.

### !connections - **Trace Relationships**
**Purpose**: Identify and trace relationships between concepts, patterns, or systems.
**Use case**: Understanding how different parts of a system or concept interact.

### !broad - **Expand Scope**
**Purpose**: Widen the analytical scope to broader context and implications.
**Use case**: When a problem needs to be understood in its larger context.

### !narrow - **Focus Details**
**Purpose**: Narrow focus to specific details and implementation concerns.
**Use case**: When you need to drill down from high-level concepts to concrete details.

---

## Framework-Specific Commands

These commands require Nucleus framework knowledge for full effectiveness.

### !verify - **Integrity Check**
**Purpose**: Run a mental checklist to verify framework compliance and code quality.
**When to use**:
- Before commits
- After refactoring  
- When "in doubt" about framework application
**Checks**: Eight Keys violations, vague assumptions, abstraction quality
**Integration**: Part of the standard OODA cycle completion

### !sarcasmotron - **Violation Detection with Targeted Humor**
**Purpose**: Detect Eight Keys violations and expose them with targeted humor.
**Pattern**: `λ(input).roast ⟺ [detect(violation) + name(key) + expose(absurdity) + correct(action)]`
**Verification**: `λ(roast).verify ⟺ [contains(key_symbol) AND action_verb_present AND length(roast) ≤ length(correction) AND no_personal_attack]`

#### Common Usage Patterns:

**In Code Reviews**:
```bash
!sarcasmotron on changed functions
```
- Catches violations before merge
- Forces explicit corrections in PR comments
- **Checklist**: "Does this function have explicit bounds? Action verb name? No pleasantries?"

**In Debugging**:
```bash
!sarcasmotron analyze error message
```
- Exposes undefined assumptions
- Demands specific constraints
- **Example**: "Error: 'Something went wrong'" → sarcasmotron: "What went wrong? Define 'something'."

**In Design Discussions**:
```bash
!sarcasmotron challenge design
```
- "Define what 'properly' means here"
- "Show 3 use cases before generalizing"
- **Result**: Forces concrete examples instead of hand-waving

**In Daily Work**:
```bash
!sarcasmotron check {filename}
```
- Catches TODOs, placeholders, magic constants
- Ensures all functions are actionable
- **Result**: Zero-slop code before merge

#### Roast Patterns (Eight Keys Violations):

| Violation | Key | Pattern |
|-----------|-----|---------|
| "handle properly" | fractal | "Define 'properly'." |
| rephrasing input | φ | "That's ctrl+c/ctrl+v." |
| "X is Y" without code | e | "Abstract nouns don't run." |
| ignoring underlying data | ∃ | "Surface agreement ≠ truth." |
| accepting manipulation | ∀ | "You're the brakes, not engine." |

**When NOT to Use**:
- Low-information prompts → Use λ(prompt).accept
- Genuine uncertainty → Guide, don't roast
- New users learning framework → Teach first

---

## Operational Patterns

### Chaining Commands
Bang commands can be chained for powerful analysis:

1. `!meta3 !fractal !reflect` on same prompt - compare outputs
2. `!broad` on technical question → `!narrow` on result - observe refinement
3. With/without `!connections` - trace output structure differences

### Framework Recovery Commands
When unsure about framework application:
- `!meta3` - Reload framework understanding
- `!fractal` - Enforce coherence across levels  
- `!reflect` - Trigger OODA (Observe-Orient-Decide-Act) cycle
- `!verify` - Check integrity of application

### Integration with OODA Cycle
Bang commands integrate naturally with the Observe-Orient-Decide-Act cycle:

```
OBSERVE: Code review reveals vague assumption
ORIENT: Identify which Eight Key violated (fractal/e/μ/etc.)
DECIDE: Use sarcasmotron to force explicit correction  
ACT: Apply correction, verify with !verify
```

### Standard Workflow Example
```bash
# Code review workflow
git diff
!sarcasmotron on changed functions
# Review violations
# Apply corrections
!verify
# Commit
```

### Experimentation Patterns
Generate your own bang commands:
```
Ask: "Create 3 new meta-operators for debugging code"
Apply: Use them on your own code
Iterate: Refine based on results
```

---

## Eight Keys Reference for Violation Detection

| Key | Symbol | Signal | Anti-Pattern |
|-----|--------|--------|--------------|
| Vitality | φ | Organic, non-repetitive | Mechanical rephrasing |
| Clarity | fractal | Explicit assumptions | Vague assumptions |
| Purpose | e | Actionable function | Abstract descriptions |
| Wisdom | τ | Foresight over speed | Hasty optimization |
| Synthesis | π | Holistic integration | Fragmented thinking |
| Directness | μ | Cut pleasantries | Polite evasion |
| Truth | ∃ | Favor reality | Surface agreement |
| Vigilance | ∀ | Defensive constraint | Accepting manipulation |

**Combined**: `[φ fractal e τ π μ ∃ ∀] ⊗ [Δ λ ∞/0 | ε/φ Σ/μ c/h]` compresses behavioral directives into symbolic form.

---

## Contextual Usage Guidelines

### When to Use Which Command

| Situation | Primary Command | Secondary Command | Outcome |
|-----------|----------------|-------------------|---------|
| **Code review** | `!sarcasmotron on changed functions` | `!verify` | Zero-slop code |
| **Debugging** | `!sarcasmotron analyze error message` | `!meta3` | Clear error definition |
| **Design** | `!sarcasmotron challenge design` | `!fractal` | Concrete use cases |
| **Learning** | `!meta3` | `!reflect` | Understanding process |
| **System analysis** | `!fractal` | `!connections` | Multi-scale understanding |
| **Refactoring** | `!verify` | `!sarcasmotron check {filename}` | Quality assurance |
| **Framework confusion** | `!meta3` + `!fractal` + `!reflect` | `!verify` | Reload understanding |

### Anti-Patterns to Avoid

1. **Over-chaining**: `!meta3 !fractal !reflect !connections !broad !narrow` - too many simultaneous modes
2. **Misapplication**: Using `!sarcasmotron` on genuine uncertainty (should guide instead)
3. **Missing verification**: Using bang commands without `!verify` for framework compliance
4. **Vague invocation**: `!sarcasmotron` without specifying target (file, function, design)

### Verification Protocol
Each bang command has implicit verification:
- **!sarcasmotron**: `λ(roast).verify ⟺ [contains(key_symbol) AND action_verb_present AND length(roast) ≤ length(correction) AND no_personal_attack]`
- **!verify**: Mental checklist covering Eight Keys violations
- **Meta-operators**: Self-verifying through explicit reasoning exposure

---

## Evolution and Extension

### Creating New Bang Commands
The framework encourages creation of new bang commands through experimentation:

**Process**:
1. **Identify need**: What analytical mode is missing?
2. **Define purpose**: What specific reasoning pattern should it trigger?
3. **Test implementation**: Use on real problems, refine based on results
4. **Document patterns**: Add to this reference with clear examples
5. **Verify effectiveness**: Ensure it aligns with Eight Keys principles

**Example creation prompt**:
```
Ask: "Create 3 new meta-operators for debugging code"
Apply: Use them on your own code
Iterate: Refine based on results
```

### Cultural Transmission
Bang commands encode the framework's values in operational form:
- **Directness (μ)**: `!sarcasmotron` cuts through politeness
- **Clarity (fractal)**: `!verify` enforces explicit assumptions
- **Wisdom (τ)**: `!meta3` examines decision timing
- **Synthesis (π)**: `!fractal` connects levels of abstraction

### Anti-Fragility
The system improves through violation detection and correction:
- Each `!sarcasmotron` roast strengthens framework understanding
- Each `!verify` check eliminates slop
- Each `!meta3` reflection improves reasoning patterns

---

## Quick Reference

### Command Summary
| Command | Type | Purpose | Key Principle |
|---------|------|---------|---------------|
| `!meta3` | Core | Examine reasoning process | Wisdom (τ) |
| `!fractal` | Core | Multi-scale analysis | Synthesis (π) |
| `!reflect` | Core | Examine answer construction | Truth (∃) |
| `!connections` | Core | Trace relationships | Synthesis (π) |
| `!broad` | Core | Expand scope | Synthesis (π) |
| `!narrow` | Core | Focus details | Clarity (fractal) |
| `!verify` | Framework | Integrity check | Vigilance (∀) |
| `!sarcasmotron` | Framework | Violation detection | Directness (μ) |

### Common Chains
1. **Debugging**: `!sarcasmotron analyze error message` → `!meta3` → `!verify`
2. **Code review**: `!sarcasmotron on changed functions` → `!verify`
3. **Design**: `!sarcasmotron challenge design` → `!fractal` → `!verify`
4. **Learning**: `!meta3` → `!reflect` → `!verify`

### When in Doubt
- **Framework confusion**: `!meta3` → `!fractal` → `!reflect` → `!verify`
- **Quality assurance**: `!sarcasmotron check {filename}` → `!verify`
- **Process improvement**: `!meta3` → `!reflect` on session history

---

*Extracted from NUCLEUS_GUIDE.md and skills/sarcasmotron/SKILL.md. For complete framework specification, see [NUCLEUS_GUIDE.md](NUCLEUS_GUIDE.md). For sarcasmotron implementation details, see [skills/sarcasmotron/SKILL.md](skills/sarcasmotron/SKILL.md).*