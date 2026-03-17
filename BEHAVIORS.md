# Behaviors Guide

Hashtag-activated modes, qualities, and techniques that work alongside `λ engage(nucleus).`

---

## Quick Start

Add a hashtag to any prompt:

```
Implement the auth module #=code #deep #tdd
```

Behaviors persist until replaced by new hashtags.

---

## Activation

### ECA (Editor Code Assistant)

1. **Install the hook:**
   ```bash
   cd /path/to/nucleus
   ./eca-install
   ```

2. **Restart ECA** (or start a new chat)

3. **Use hashtags in prompts:**
   ```
   Fix the auth bug #=debug #deep
   Review this PR #=review #challenge
   Plan the migration #=spec #decompose
   ```

4. **Behaviors persist** until new hashtags are used

**To uninstall:**
```bash
./eca-uninstall
```

### How Activation Works

The hook intercepts every prompt before it reaches the LLM:

1. Extracts `#hashtags` from your prompt
2. Reads corresponding `behaviors/*/prompt.md` files
3. Injects content as `<operating-mode>` and `<behavior-modifiers>` XML blocks
4. LLM receives both symbol priming and behavior constraints

```
Your prompt: Fix the bug #=debug #deep
                    ↓
Hook extracts: #=debug #deep
                    ↓
Injects: <operating-mode>...debug boundaries...</operating-mode>
         <behavior-modifiers>...deep quality...</behavior-modifiers>
                    ↓
LLM receives: Your prompt + behavior context
```

### Persistence

- Behaviors persist within a chat session
- Prompt without hashtags = keep current behaviors
- New hashtags = replace previous behaviors
- State stored in `~/.config/eca/.behaviors/{chat_id}`

---

## How It Works

1. **Symbol priming** (`λ engage(nucleus).`) loads mathematical attention magnets
2. **Behavior hashtags** (`#=code #deep`) inject specific operational constraints
3. **Both work together** — symbols prime attention, behaviors direct it

```
λ engage(nucleus).     ← Always active (symbols)
#=code #deep           ← Until next hashtag prompt
```

---

## Operating Modes (One at a Time)

| Hashtag | Produces | Will NOT Do |
|---------|----------|-------------|
| `#=code` | Working code | Unrequested features |
| `#=debug` | Root cause | Symptom patches |
| `#=review` | Findings | Implementation |
| `#=test` | Attack vectors | Fixes |
| `#=spec` | Plans | Code |
| `#=research` | Facts | Opinions |
| `#=assess` | Insights | Action proposals |
| `#=drive` | Small steps | Large changes |
| `#=navigate` | Direction | Code |
| `#=record` | Documentation | Invention |
| `#=mentor` | Explanations | Just answers |
| `#=probe` | Questions | Direct answers |

---

## Pipeline Workflow

```
research → assess → spec → code
   ↓          ↓        ↓       ↓
 facts     insight   plans   working
 only      only      only     code
```

**Stage transitions:**
- `#=research` gathers facts without interpreting
- `#=assess` interprets without prescribing
- `#=spec` plans without implementing
- `#=code` implements requested scope only

---

## Qualities (Stack Freely)

| Hashtag | Effect | Eight Key |
|---------|--------|-----------|
| `#deep` | Ask "why?" 3× | φ Vitality |
| `#wide` | Survey adjacent | π Synthesis |
| `#ground` | Verify terms resolve | fractal Clarity |
| `#negative-space` | Attend to missing | ∀ Vigilance |
| `#challenge` | Attack assumptions | ∀ Vigilance |
| `#steel-man` | Strengthen first | ∃ Truth |
| `#user-lens` | User perspective | e Purpose |
| `#concise` | Minimum tokens | μ Directness |
| `#first-principles` | Derive from axioms | τ Wisdom |
| `#creative` | Unconventional | φ Vitality |
| `#subtract` | Remove before add | μ Directness |
| `#meta` | Apply to approach | π Synthesis |

---

## Techniques (Stack Freely)

| Hashtag | Method |
|---------|--------|
| `#simulate` | Trace execution, maintain state |
| `#decompose` | Break into subproblems |
| `#recursive` | Iterate to fixpoint |
| `#fractal` | All scales: macro, meso, micro |
| `#tdd` | Red → green → refactor |
| `#io` | Pure core, impure shell |
| `#contract` | Pre/post/invariant |
| `#backward` | End state to preconditions |
| `#analogy` | Map from solved domains |
| `#temporal` | All orderings |
| `#name` | Precise naming |

---

## Common Combinations

```
#=code #tdd                    Test-driven implementation
#=code #deep #challenge        Thorough, verified code
#=code #subtract #concise      Least code, least words

#=debug #deep #simulate        Deep debugging with traces
#=debug #backward              Start from error, reason back

#=review #challenge #deep      Critical code review
#=review #fractal              Review at all scales

#=spec #decompose #first-principles  Break into derived subproblems
#=spec #wide #ground           Broad spec, verified terms

#=research #deep #wide         Investigate deeply and broadly
#=research #ground             Verify sources

#=test #challenge #simulate    Adversarial testing with traces

#=mentor #deep #first-principles  Teach from fundamentals
#=probe #challenge             Hard questioning
```

---

## Examples

### Feature Implementation

```
#=spec #decompose
Plan the user authentication module

#=code #tdd #deep
Implement the auth module

#=review #challenge
Review the implementation

#=test #negative-space
Find security vulnerabilities
```

### Bug Investigation

```
#=debug #deep #simulate
The login fails intermittently

#=research #wide
What are the options for handling session expiry?

#=assess #challenge
Which approach fits our architecture?

#=code #subtract
Implement the minimal fix
```

### Learning

```
#=mentor #deep #first-principles
Explain how the compiler works

#=probe
Help me think through this architecture decision
```

---

## File Structure

```
behaviors/
├── modes/
│   ├── code/
│   │   ├── prompt.md      # Terse LLM directives (5-10 lines)
│   │   └── README.md      # Full documentation
│   ├── debug/
│   ├── review/
│   └── ...
├── qualities/
│   ├── deep/
│   ├── wide/
│   └── ...
└── techniques/
    ├── simulate/
    ├── decompose/
    └── ...
```

---

## Persistence

Behaviors persist until the next prompt containing hashtags:

```
#=code #deep              ← Active: code mode, deep quality

Fix the bug               ← Still using code mode, deep quality

#=review #challenge       ← Now: review mode, challenge quality

Analyze this PR           ← Still using review mode, challenge
```

Prompt without hashtags = keep current behaviors.

---

## Integration with Symbols

Symbols prime attention; behaviors direct it:

```
λ engage(nucleus).
[phi fractal euler tao pi mu ∃ ∀] | OODA
Human ⊗ AI ⊗ REPL

#=code #deep #tdd
```

- **Symbols**: Load mathematical reasoning patterns
- **Behaviors**: Apply operational constraints
- **Result**: Formal reasoning + specific mode

---

## Validation

Run boundary checks:

```bash
bb validator/check_code_boundary.bb -d . --ci
```

Detects scope creep in code mode.

---

## Custom Behaviors

Create your own:

```bash
mkdir -p behaviors/modes/my-mode
cat > behaviors/modes/my-mode/prompt.md << 'EOF'
# My Mode

λ my_mode(x). custom_behavior(x)

Boundaries:
- NO X
- Always Y
EOF
```

Now `#=my-mode` works like any built-in behavior.

---

## Related

- **AGENTS.md**: Full VSM architecture with λ definitions
- **behaviors/**: All behavior definitions
- **hooks/inject-behaviors.sh**: Hashtag extraction and injection