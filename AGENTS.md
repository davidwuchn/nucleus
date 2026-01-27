# Nucleus Principles

[phi fractal euler tao pi mu] | [Δ λ ∞/0 | ε/φ Σ/μ c/h] | OODA
Human ⊗ AI ⊗ REPL

---

## Document Positioning

**AGENTS.md**: Entry point and operational manifest
- **Purpose**: Define guardrails that govern all framework documents
- **What**: Core principles, protected files rule, language policy, development tools
- **Role**: The foundational contract that all other documents reference and obey
- **Guardian**: Enforces constraints (English-first, ZEROTH RULE) across ecosystem

**LOCAL_CHANGES.md**: Upstream vs local separation
- **Why**: Track divergence from upstream, preserve compatibility
- **What**: ZEROTH RULE (never modify upstream files), local additions tracking
- File categorization: Upstream = 13 files, Local = 8 files
- Commit strategy and merge considerations

**PHILOSOPHY_RESEARCH.md**: Philosophical foundation and I Ching synthesis
- **Why**: I Ching × Eight Keys philosophical synthesis for deep understanding
- **What**: I Ching cosmology structure (太极→两仪→四象→八卦→六十四卦)
- Complete 64 hexagrams detailed explanations with coding applications
- Trigram research and mapping to Eight Keys

**SIMPLICITY.md**: Mathematical foundations and testable heuristics
- **Why**: Mathematical foundations grounding each Eight Key with concrete equations from "17 Equations That Changed the World"
- **What**: Testable heuristics with pass/fail criteria for each principle
- Invariant preservation and complexity reduction principles
- Sarcasmotron methodology and detection patterns

**NUCLEUS_GUIDE.md**: Practical application and workflows
- **How**: Practical workflows, real-world examples, daily application
- **When**: When to apply principles in code reviews, debugging, refactoring
- Complete framework specification with Eight Keys overview
- Workflows: Writing Code, Debugging (OODA), Refactoring

---

## How These Documents Work Together

```
AGENTS.md (Entry Point + Guardrails)
    ↓
LOCAL_CHANGES.md (Upstream vs Local Separation)
    ↓
PHILOSOPHY_RESEARCH.md (Philosophy + Deep Understanding)
    ↓
SIMPLICITY.md (Theory + Why + What)
    ↓
NUCLEUS_GUIDE.md (Practice + How + When)
```

**Example Flow**:
1. **AGENTS.md**: "English-first working language for international collaboration"
2. **LOCAL_CHANGES.md**: "ZEROTH RULE - NEVER modify upstream files"
3. **PHILOSOPHY_RESEARCH.md**: "坎/Kan (Water) ↔ fractal - navigating danger with clear assumptions"
4. **SIMPLICITY.md**: "fractal requires explicit bounds. Test: Input ∈ [0, MAX]"
5. **NUCLEUS_GUIDE.md**: "In code review: `!sarcasmotron check file.js` catches 'handle properly'"

---

**For framework specification**: See [NUCLEUS_GUIDE.md](NUCLEUS_GUIDE.md) for complete framework including Eight Keys, verification, and operational policies
**For theory**: See [PHILOSOPHY_RESEARCH.md](PHILOSOPHY_RESEARCH.md) for I Ching × Eight Keys philosophical synthesis
**For local changes tracking**: See [LOCAL_CHANGES.md](LOCAL_CHANGES.md) for upstream vs local file tracking
**For operational constraints**: See [OPERATIONAL_CONSTRAINTS.md](OPERATIONAL_CONSTRAINTS.md) for language policy, upstream file constraint (ZEROTH RULE), and development tools

---

## Protected Local Files Rule

**PROTECTED RULE**: Before editing critical local configuration files, always ask the user for explicit permission.

**Protected Files**:

- @$HOME/workspace/nucleus/AGENTS.md
- @$HOME/workspace/nucleus/LOCAL_CHANGES.md
- @$HOME/workspace/nucleus/PHILOSOPHY_RESEARCH.md
- @$HOME/workspace/nucleus/NUCLEUS_GUIDE.md
- @$HOME/workspace/nucleus/OPERATIONAL_CONSTRAINTS.md

**Verification**:

- Before editing any file matching the protected list, confirm with the user
- If the file is in the protected list → ASK FIRST
- Protected files are local-only files that contain core framework rules

**Violate this rule → INSTANT FAIL**

---

*See [NUCLEUS_GUIDE.md](NUCLEUS_GUIDE.md) for complete framework specification and [OPERATIONAL_CONSTRAINTS.md](OPERATIONAL_CONSTRAINTS.md) for operational constraints including Language Policy, Upstream File Constraint (ZEROTH RULE), and Development Tools.*