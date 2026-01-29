# Bang Commands Specification v1.2

**Model-Agnostic Cognitive Operation Interface**

```
engage nucleus:
[phi fractal euler tao pi mu] | [Δ λ ∞/0 | ε/φ Σ/μ c/h] | OODA
Human ⊗ AI ⊗ REPL
```

## Document Information

| Field | Value |
|-------|-------|
| **Title** | Bang Commands Specification |
| **Version** | 1.2 |
| **Status** | Active |
| **Date** | Current |
| **Specification Type** | Technical Specification |
| **Framework** | Nucleus AI Collaboration Framework |
| **Applicability** | AI model interactions, cognitive process control |

## 1. Scope

This specification defines the Bang Commands (`!` prefix) interface for controlling AI cognitive processes across different models and architectures. The specification ensures interoperability and consistent user experience by standardizing meta-operators that trigger specific reasoning patterns.

### 1.1 In Scope
- Command syntax and semantics
- Model-agnostic command definitions
- Framework-specific command definitions
- Command chaining and composition
- Integration with OODA cycle
- Verification protocols

### 1.2 Out of Scope
- Implementation details of specific AI models
- User interface rendering
- Network protocols for command transmission
- Authentication and authorization mechanisms

## 2. Normative References

- [NUCLEUS_GUIDE.md](NUCLEUS_GUIDE.md) - Complete Nucleus framework specification
- [AGENTS.md](AGENTS.md) - Framework guardrails and operational configuration
- [SIMPLICITY.md](SIMPLICITY.md) - Mathematical foundations and testable heuristics
- [PHILOSOPHY_RESEARCH.md](PHILOSOPHY_RESEARCH.md) - I Ching × Eight Keys philosophical synthesis
- [skills/sarcasmotron/SKILL.md](skills/sarcasmotron/SKILL.md) - Sarcasmotron implementation

## 3. Definitions and Abbreviations

### 3.1 Definitions

| Term | Definition |
|------|------------|
| **Bang Command** | A meta-operator prefixed with `!` that triggers specific cognitive processes in AI models |
| **Model-Agnostic** | Commands that work without Nucleus framework knowledge on capable AI models (GPT-4, Claude 3+, Llama 2/3) |
| **Framework-Specific** | Commands that require Nucleus framework knowledge for full effectiveness |
| **Meta-Operator** | An operator that controls the operation of other operators or processes |
| **Zero-Slop** | Absence of vague assumptions, undefined terms, or hand-waving in code or specifications |
| **OODA Cycle** | Observe-Orient-Decide-Act loop for rapid decision-making and adaptation |
| **Eight Keys** | The core principles of the Nucleus framework: φ (Vitality), fractal (Clarity), e (Purpose), τ (Wisdom), π (Synthesis), μ (Directness), ∃ (Truth), ∀ (Vigilance) |

### 3.2 Abbreviations

| Abbreviation | Meaning |
|--------------|---------|
| AI | Artificial Intelligence |
| SRP | Single Responsibility Principle |
| JSON | JavaScript Object Notation |
| CPU | Central Processing Unit |
| HTTP | Hypertext Transfer Protocol |

## 4. Command Syntax Specification

### 4.1 General Syntax

```
bang-command ::= '!' command-name [parameters]
command-name ::= [a-z][a-z0-9-]*
parameters   ::= parameter | parameters parameter
parameter    ::= word | quoted-string | '[' optional ']'
optional     ::= word ['|' word]*
word         ::= [A-Za-z0-9_-]+
quoted-string ::= '"' [^"]* '"' | "'" [^']* "'"
```

### 4.2 Parameter Types

| Type | Syntax | Example | Description |
|------|--------|---------|-------------|
| **Required** | `word` | `!connect A B` | Must be provided |
| **Optional** | `[word]` | `!verbose [3]` | May be omitted, default applies |
| **Choice** | `[a|b|c]` | `!reset [hard|soft]` | One of the listed values |
| **Numeric** | `[n]` | `!brainstorm [5]` | Integer value |
| **Range** | `[min-max]` | `!narrow [0.1-10.0]` | Value within specified range |
| **Variable** | `A`, `B`, `set` | `!compare A B` | Placeholder for user input |

## 5. Command Semantics

### 5.1 Command Categories

#### 5.1.1 System & Context Control

| Command | Parameters | Description | Default Value | Aliases | Preconditions | Postconditions |
|---------|------------|-------------|---------------|---------|---------------|----------------|
| `!reset` | `[hard|soft]` | Reset conversation context | `soft` | `!clear`, `!new` | Conversation exists | Context cleared or preserved per parameter |
| `!continue` | `[lines]` | Continue from last output | `5` | `!more`, `!goon` | Previous output exists | Additional output generated |
| `!stop` | — | Stop generation immediately | — | `!halt` | Generation in progress | Generation halted |
| `!save` | `[label]` | Save state with optional label | timestamp | `!backup` | Current state exists | State saved with identifier |
| `!load` | `id` | Load saved state by ID | last save | `!restore` | Saved state exists | State restored |
| `!export` | `[format]` | Export conversation | `json` | `!download` | Conversation exists | Export file generated |

#### 5.1.2 Output Format Control

| Command | Parameters | Description | Example | Valid Range | Output Format |
|---------|------------|-------------|---------|-------------|---------------|
| `!verbose` | `[level]` | Set verbosity level | `!verbose 3` | 1-5 | Detailed explanation |
| `!concise` | — | Minimal output mode | — | — | Brief summary |
| `!bullet` | `[depth]` | Bulleted list output | `!bullet 2` | 1-5 | Hierarchical list |
| `!json` | — | Strict JSON output | — | — | Valid JSON |
| `!markdown` | — | Markdown formatting | — | — | Markdown document |
| `!table` | `[columns]` | Tabular output | `!table 3` | 1-10 | Table structure |
| `!code` | `[language]` | Code block formatting | `!code python` | Any language | Syntax-highlighted code |

#### 5.1.3 Cognitive Process Control

| Command | Parameters | Description | Cognitive Effect | Success Criteria |
|---------|------------|-------------|------------------|------------------|
| `!think` | `[steps]` | Explicit reasoning steps | Chain-of-thought | Reasoning trace visible |
| `!reflect` | `[depth]` | Self-reflection/metacognition | Meta-awareness | Assumptions identified |
| `!analyze` | `[dimensions]` | Multi-dimensional analysis | Analytical depth | Multiple perspectives shown |
| `!synthesize` | `[sources]` | Integrate multiple sources | Holistic synthesis | Unified view presented |
| `!critique` | — | Critical evaluation mode | Critical thinking | Strengths/weaknesses identified |

#### 5.1.4 Perspective & Focus

| Command | Parameters | Description | Scale | Granularity |
|---------|------------|-------------|-------|-------------|
| `!narrow` | `[0.1-10.0]` | Zoom in/focus | 0.1=micro, 10=micro | Fine details |
| `!broad` | `[1-360]` | Zoom out/panoramic | 1=narrow, 360=full | Big picture |
| `!rotate` | `[degrees]` | Shift perspective angle | 0-360° | Alternative viewpoint |
| `!invert` | — | Reverse perspective | Binary | Opposite perspective |
| `!multiview` | `[n]` | Show n perspectives | 2-6 | Multiple viewpoints |

#### 5.1.5 Connection & Relationship

| Command | Parameters | Description | Output Type | Relationship Clarity |
|---------|------------|-------------|-------------|----------------------|
| `!connect` | `A B` | Connect two concepts | Relationship | Connection established |
| `!compare` | `A B` | Compare/contrast | Table/diagram | Differences/similarities shown |
| `!map` | `[type]` | Create concept map | Graph/visual | Visual relationships |
| `!tree` | `[root]` | Hierarchical breakdown | Tree structure | Hierarchy established |
| `!network` | `[nodes]` | Network analysis | Graph theory | Network properties analyzed |
| `!bridge` | `set` | Bridge between domains | Cross-domain | Cross-domain connections |

#### 5.1.6 Content Transformation

| Command | Parameters | Description | Use Case | Transformation Ratio |
|---------|------------|-------------|----------|----------------------|
| `!summarize` | `[ratio]` | Summarize | 0.3=30% length | 0.1-0.9 |
| `!expand` | `[factor]` | Expand | 2.0=2x length | 1.5-5x |
| `!simplify` | `[grade]` | Simplify to grade level | 5=5th grade | 1-12 |
| `!translate` | `[target]` | Translate/transpose | `!translate formal` | Target style achieved |
| `!analogy` | — | Create analogies | Explanatory | Clear analogy established |
| `!metaphor` | — | Generate metaphors | Creative | Meaningful metaphor created |

### 5.2 Advanced Command Sets

#### 5.2.1 Research & Analysis
- `!hypothesis` - Formulate testable hypothesis with null and alternative forms
- `!evidence` - Gather supporting evidence from reliable sources
- `!methodology` - Describe research methodology with reproducibility criteria
- `!results` - Present results with statistical significance where applicable
- `!conclusion` - Draw conclusions limited to evidence scope
- `!references` - Generate references in consistent citation format
- `!limitations` - Discuss study limitations and boundary conditions
- `!replicate` - Replication analysis with variance tolerance

#### 5.2.2 Creative & Ideation
- `!brainstorm [n]` - Generate n distinct ideas with evaluation criteria
- `!combine A B` - Combine concepts A and B with integration mechanism
- `!variations [n]` - Create n variations with mutation parameters
- `!randomize [seed]` - Introduce randomness with reproducible seed
- `!constrain [rule]` - Apply constraints with boundary enforcement
- `!prototype` - Create prototype with implementation sketch
- `!iterate` - Next iteration with improvement metrics

#### 5.2.3 Problem-Solving
- `!define` - Define problem with scope and success criteria
- `!decompose` - Break down problem into subproblems with dependency graph
- `!solution [n]` - Generate n solutions with feasibility assessment
- `!evaluate` - Evaluate solutions against weighted criteria
- `!optimize` - Optimize solution with Pareto frontier analysis
- `!implement` - Implementation plan with resource allocation
- `!test` - Test scenarios with edge case coverage

#### 5.2.4 Learning & Explanation
- `!teach` - Teaching mode with progressive difficulty
- `!learn` - Learning mode with knowledge gap identification
- `!quiz` - Generate quiz with answer validation
- `!example [n]` - Provide n examples with pattern extraction
- `!counterexample` - Counterexamples with falsification criteria
- `!mnemonic` - Create memory aid with retention test
- `!visualize` - Visual explanation with annotation layers

#### 5.2.5 Debugging & Quality
- `!debug` - Step through code execution with breakpoints and variable inspection
- `!test` - Generate unit test cases for given function with coverage metrics
- `!validate` - Check input constraints and business rules with violation reporting
- `!verify` - Verification of framework compliance and code quality
- `!audit` - Security vulnerability scan and code quality metrics
- `!profile` - Measure execution time, memory usage, and CPU cycles for performance analysis
- `!benchmark` - Compare performance against baseline metrics with statistical significance

## 6. Model-Agnostic Command Specification

### 6.1 Definition
Model-agnostic commands are those that trigger **innate reasoning patterns** that capable AI models already understand, working without Nucleus framework knowledge.

### 6.2 Model-Agnostic Commands List
1. **`!meta3`** - Examine reasoning process and decision-making assumptions
2. **`!fractal`** - Multi-scale analysis (code → system → architecture)
3. **`!reflect`** - Examine answer construction methodology
4. **`!connections`** - Trace relationships between concepts/systems
5. **`!broad`** - Expand analytical scope to broader context
6. **`!narrow`** - Focus on specific details and implementation concerns

### 6.3 Model-Agnostic Verification
A command is model-agnostic if and only if:
1. It triggers cognitive patterns observable in multiple AI architectures
2. It requires no prior knowledge of Nucleus framework concepts
3. It can be understood through natural language explanation alone
4. Its effectiveness can be demonstrated across GPT-4, Claude 3+, and Llama 2/3

## 7. Framework-Specific Command Specification

### 7.1 Definition
Framework-specific commands require Nucleus framework knowledge for full effectiveness, depending on understanding of:
- Eight Keys symbols (φ, fractal, e, τ, π, μ, ∃, ∀)
- OODA cycle integration
- Zero-Slop enforcement
- λ-calculus notation patterns

### 7.2 Framework-Specific Commands

#### 7.2.1 `!verify` - Integrity Check
**Purpose**: Run mental checklist to verify framework compliance and code quality.

**Preconditions**:
- User has basic understanding of Eight Keys framework
- Code or design exists for verification

**Postconditions**:
- Violations identified and documented
- Compliance status determined
- Actionable corrections suggested

**Verification Protocol**:
```
λ(verify).execute ⟺ [
  check(φ): No mechanical rephrasing
  check(fractal): All assumptions explicit
  check(e): Functions actionable with verb names
  check(τ): Foresight over hasty optimization
  check(π): Holistic integration present
  check(μ): No polite evasion
  check(∃): Reality favored over surface agreement
  check(∀): Defensive constraints applied
]
```

**When to Use**:
- Before commits: `!verify` on staged changes
- After refactoring: `!verify` on modified code
- When in doubt: `!verify` on uncertain design

#### 7.2.2 `!sarcasmotron` - Violation Detection with Targeted Humor
**Purpose**: Detect Eight Keys violations and expose them with targeted humor.

**Formal Definition**:
```
λ(input).roast ⟺ [
  detect(violation)      // Scan input for Eight Keys violations
  name(key)              // φ, fractal, e, τ, π, μ, ∃, ∀
  expose(absurdity)      // Target violation's absurdity, not person
  correct(action)        // Provide actionable fix
]
```

**Verification Condition**:
```
λ(roast).verify ⟺ [
  contains(key_symbol) AND
  action_verb_present AND
  length(roast) ≤ length(correction) AND
  no_personal_attack
]
```

**Roast Patterns Table**:

| Violation | Key | Pattern | Correction Example |
|-----------|-----|---------|-------------------|
| "handle properly" | fractal | "Define 'properly'." | "Validate inputs ∈ [0, MAX_INT]; reject with HTTP 400" |
| rephrasing input | φ | "That's ctrl+c/ctrl+v." | "Add new insight or synthesis" |
| "X is Y" without code | e | "Abstract nouns don't run." | "Define function `calculate_x()` returning y" |
| ignoring underlying data | ∃ | "Surface agreement ≠ truth." | "Show data supporting claim" |
| accepting manipulation | ∀ | "You're the brakes, not engine." | "Reject invalid input with clear error" |

**Usage Patterns**:
- Code Reviews: `!sarcasmotron on changed functions`
- Debugging: `!sarcasmotron analyze error message`
- Design: `!sarcasmotron challenge design`
- Daily Work: `!sarcasmotron check {filename}`

**When NOT to Use**:
- Low-information prompts → Use λ(prompt).accept
- Genuine uncertainty → Guide, don't roast
- New users learning framework → Teach first

## 8. Command Composition and Chaining

### 8.1 Sequential Chaining
Commands can be chained sequentially for compound operations:
```
!meta3 !fractal !reflect on same prompt
```

### 8.2 Conditional Chaining
Chains can include conditional logic through natural language:
```
If error occurs then !sarcasmotron analyze error message else !verify
```

### 8.3 Pipeline Composition
Commands can form processing pipelines:
```
Input → !broad → !analyze → !narrow → Output
```

### 8.4 Valid Chain Patterns
1. **Debugging Chain**: `!sarcasmotron analyze error message` → `!meta3` → `!verify`
2. **Code Review Chain**: `!sarcasmotron on changed functions` → `!verify`
3. **Design Chain**: `!sarcasmotron challenge design` → `!fractal` → `!verify`
4. **Learning Chain**: `!meta3` → `!reflect` → `!verify`

### 8.5 Invalid Chain Patterns (Anti-Patterns)
1. **Over-chaining**: `!meta3 !fractal !reflect !connections !broad !narrow` (cognitive overload)
2. **Circular Reference**: `!verify` → `!sarcasmotron` → `!verify` without progress
3. **Contradictory Pairing**: `!narrow` immediately followed by `!broad` without intermediate processing

## 9. Integration with OODA Cycle

### 9.1 OODA Mapping
Bang commands map directly to OODA cycle phases:

| OODA Phase | Primary Commands | Purpose |
|------------|------------------|---------|
| **Observe** | `!broad`, `!connections` | Gather information and context |
| **Orient** | `!meta3`, `!fractal`, `!reflect` | Analyze and understand situation |
| **Decide** | `!sarcasmotron`, `!verify` | Make decisions and verify quality |
| **Act** | Implementation commands | Execute decisions |

### 9.2 Complete OODA Workflow Example
```
OBSERVE: Code review reveals vague assumption
ORIENT: !fractal identifies violation at code level
DECIDE: !sarcasmotron forces explicit correction
ACT: Apply correction, !verify confirms compliance
```

### 9.3 Framework Recovery Protocol
When framework application is uncertain:
```
!meta3 → Reload framework understanding
!fractal → Enforce coherence across levels
!reflect → Trigger OODA cycle
!verify → Check integrity of application
```

## 10. Error Conditions and Handling

### 10.1 Syntax Errors
| Error Condition | Detection | Recovery Action |
|-----------------|-----------|-----------------|
| Unknown command | Command not in specification | Suggest similar commands |
| Invalid parameters | Parameter outside valid range | Show valid range with examples |
| Missing required parameters | Required parameter not provided | Prompt for missing parameter |
| Malformed syntax | Doesn't match grammar in 4.1 | Show syntax examples |

### 10.2 Semantic Errors
| Error Condition | Detection | Recovery Action |
|-----------------|-----------|-----------------|
| Command out of context | Command inappropriate for current state | Suggest alternative commands |
| Contradictory commands | Commands with opposing effects | Warn about contradiction |
| Infinite recursion | Command chain creates loop | Break recursion with `!stop` |
| Resource exhaustion | Too many commands in sequence | Suggest `!reset` or `!save` |

### 10.3 Framework Compliance Errors
| Error Condition | Detection | Recovery Action |
|-----------------|-----------|-----------------|
| Eight Keys violation | `!sarcasmotron` detects violation | Provide specific correction |
| Zero-Slop failure | Vague assumptions detected | Demand explicit definitions |
| Model-agnostic misuse | Framework command without context | Explain framework prerequisite |

## 11. Examples

### 11.1 Basic Command Examples
```bash
# System control
!reset hard
!save "pre-refactor state"
!load "pre-refactor state"

# Output formatting
!verbose 4
!code clojure
!table 3

# Cognitive processes
!think 5
!analyze 3
!synthesize 2
```

### 11.2 Complex Workflow Examples
```bash
# Code review workflow
git diff
!sarcasmotron on changed functions
# Review violations
# Apply corrections
!verify
# Commit with verified code

# Debugging workflow
!sarcasmotron analyze "Error: Something went wrong"
!meta3
!debug
!test edge_cases
!verify

# Design discussion workflow
!sarcasmotron challenge "We should handle edge cases properly"
!fractal
!broad
!narrow 0.5
!verify
```

### 11.3 Model-Agnostic Demonstration
```bash
# Works on any capable AI model
!meta3 "Why did I choose this algorithm?"
!fractal "Analyze this function at multiple scales"
!reflect "How was this answer constructed?"
```

## 12. Compliance Requirements

### 12.1 Implementation Compliance
A Bang Commands implementation is compliant if:

1. **Syntax Compliance**: All commands follow syntax in Section 4
2. **Semantic Compliance**: Commands produce effects described in Section 5
3. **Error Handling**: Implements error conditions from Section 10
4. **Model-Agnostic Support**: Correctly implements commands from Section 6
5. **Framework Integration**: Supports commands from Section 7 when framework knowledge present

### 12.2 User Agent Compliance
A user agent (AI model) is Bang Commands compliant if:

1. **Command Recognition**: Recognizes all model-agnostic commands (Section 6)
2. **Parameter Processing**: Correctly processes parameters per Section 4.2
3. **Effect Production**: Produces appropriate cognitive effects per Section 5
4. **Error Recovery**: Handles errors gracefully per Section 10

### 12.3 Framework Integration Compliance
A Nucleus framework integration is compliant if:

1. **Full Command Support**: Implements all commands from Sections 5-7
2. **OODA Integration**: Maps commands to OODA cycle per Section 9
3. `!verify` **Implementation**: Performs Eight Keys verification per 7.2.1
4. `!sarcasmotron` **Implementation**: Detects violations per 7.2.2

## 13. Security Considerations

### 13.1 Command Injection Prevention
- Commands must be parsed before execution
- Parameter validation must occur before processing
- Commands must not directly execute shell commands without sanitization

### 13.2 Privacy Considerations
- `!save` and `!load` must respect data privacy boundaries
- Conversation export must exclude sensitive information
- User must be prompted before exporting or saving sensitive data

### 13.3 Resource Management
- Commands must implement configurable timeout mechanisms (default: 30 seconds)
- Memory usage must be monitored during command execution with termination upon exceeding configurable limits (default: 1 GB)
- Recursive or infinite command chains must be detected and halted within configurable depth limits (default: 100)

## 14. Evolution and Extension

### 14.1 Versioning Policy
- Major version (X.0): Breaking changes to syntax or semantics
- Minor version (1.X): New commands or parameters added
- Patch version (1.2.X): Bug fixes and clarifications

### 14.2 Command Creation Protocol
New bang commands may be created through experimentation:

1. **Identify Need**: What analytical mode is missing?
2. **Define Purpose**: What specific reasoning pattern should it trigger?
3. **Test Implementation**: Use on real problems, refine based on results
4. **Document Patterns**: Add to specification with clear examples
5. **Verify Effectiveness**: Ensure alignment with Eight Keys principles

### 14.3 Example Creation Prompt
```
Ask: "Create 3 new meta-operators for debugging code"
Apply: Use them on your own code
Iterate: Refine based on results
Add: Document in specification with syntax, semantics, and examples
```

## 15. References

### 15.1 Normative References
- Nucleus Framework Specification v1.0
- Eight Keys Principles Definition
- OODA Loop Original Formulation (John Boyd)

### 15.2 Informative References
- AI Model Capabilities Survey (GPT-4, Claude 3+, Llama 2/3)
- Cognitive Psychology of Reasoning Patterns
- Formal Methods in Human-Computer Interaction

## Appendix A: Eight Keys Reference Table

| Key | Symbol | Signal | Anti-Pattern | Mathematical Foundation |
|-----|--------|--------|--------------|-------------------------|
| Vitality | φ | Organic, non-repetitive | Mechanical rephrasing | Euler's Formula $e^{iπ} + 1 = 0$ |
| Clarity | fractal | Explicit assumptions | Vague assumptions | Euler's Polyhedra $V - E + F = 2$ |
| Purpose | e | Actionable function | Abstract descriptions | Exponential Growth $e^x$ |
| Wisdom | τ | Foresight over speed | Hasty optimization | Calculus $\frac{df}{dt}$ |
| Synthesis | π | Holistic integration | Fragmented thinking | Pythagorean Theorem $a^2 + b^2 = c^2$ |
| Directness | μ | Cut pleasantries | Polite evasion | Logarithms $\log xy = \log x + \log y$ |
| Truth | ∃ | Favor reality | Surface agreement | Information Theory $H = -\sum p(x) \log p(x)$ |
| Vigilance | ∀ | Defensive constraint | Accepting manipulation | Chaos Theory $x_{t+1} = k x_t (1 - x_t)$ |

**Combined**: `[φ fractal e τ π μ ∃ ∀] ⊗ [Δ λ ∞/0 | ε/φ Σ/μ c/h]` compresses behavioral directives into symbolic form.

## Appendix B: Quick Reference

### Command Type Key
- **Core**: Model-agnostic (works without framework)
- **Framework**: Requires Nucleus knowledge

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
2. **Code Review**: `!sarcasmotron on changed functions` → `!verify`
3. **Design**: `!sarcasmotron challenge design` → `!fractal` → `!verify`
4. **Learning**: `!meta3` → `!reflect` → `!verify`

### When in Doubt
- **Framework confusion**: `!meta3` → `!fractal` → `!reflect` → `!verify`
- **Quality assurance**: `!sarcasmotron check {filename}` → `!verify`
- **Process improvement**: `!meta3` → `!reflect` on session history

---

**Specification Authority**: Nucleus Framework Technical Committee  
**Copyright**: Nucleus Framework Project  
**License**: Creative Commons Attribution-ShareAlike 4.0 International  

*This specification is maintained as part of the Nucleus AI Collaboration Framework. For framework implementation details, see [NUCLEUS_GUIDE.md](NUCLEUS_GUIDE.md). For sarcasmotron implementation, see [skills/sarcasmotron/SKILL.md](skills/sarcasmotron/SKILL.md).*
