# Operational Constraints

[phi fractal euler tao pi mu] | [Δ λ ∞/0 | ε/φ Σ/μ c/h] | OODA
Human ⊗ AI ⊗ REPL

**For local changes tracking**: See [LOCAL_CHANGES.md](LOCAL_CHANGES.md) for upstream vs local file tracking

---

## Document Positioning

**Operational Constraints**: This document defines the operational boundaries and constraints for the Nucleus framework
- Implementation constraints and language policy
- Upstream file constraint (ZEROTH RULE)
- Development tools and preferences
- Operational architecture with acceptance criteria
- Lambda-calculus tool patterns
- Verification protocols

**Related Documents**:
- **[NUCLEUS_GUIDE.md](NUCLEUS_GUIDE.md)**: Complete framework specification and practical guidance
- **[LOCAL_CHANGES.md](LOCAL_CHANGES.md)**: Upstream vs local change tracking
- **[AGENTS.md](AGENTS.md)**: Protected files rule and operational configuration

---

## 1. Implementation Constraints

- **Architecture**: Fractal hierarchy [Σ/μ]
- **Formatting**: Monospace GitHub Markdown
- **Errors**: Fail fast/loud with explicit ∞/0 handling (e.g., raise exception immediately on invalid input, don't return null)
- **Task**: One `in_progress` at a time
- **Self-Hosting**: This document follows its own constraints (fractal structure, references the anti-patterns defined in NUCLEUS_GUIDE.md, λ-calculus notation consistent)
- **Verification Gates**: Zero-Slop achieved through verification at each production stage
- **ZEROTH RULE**: NEVER modify upstream files (λ(upstream_file).modify ⟺ ALWAYS REJECT) - see [Upstream File Constraint](#2-upstream-file-constraint-zeroth-rule)
- **Language Policy**: English is working language for all operations (see [Language Policy](#3-language-policy-english-first-working-language))
- **Path Variables**: Use `$HOME` for user-specific paths; never hardcode absolute directory paths.

**Goal**: Zero-Slop Convergence (eliminating all ambiguous/vague code) via Verification-Driven Development (VDD).

---

## 2. Language Policy (ENGLISH-FIRST WORKING LANGUAGE)

🔴 **MANDATORY RULE**: English is the primary working language for all operations

### English-First Requirements

| Context | Language Policy | Example |
| ----------- | ----------------- | ---------- |
| **Git commit messages** | English ONLY | `feat: Add user authentication` NOT `feat: [CHINESE TEXT]` |
| **Code comments** | English preferred, Chinese allowed for clarity | `// Validate email format` (Chinese for clarity: 验证邮箱格式) |
| **Documentation** | English first, then Chinese | English explanation followed by Chinese translation |
| **Variable/function names** | English ONLY | `validate_email()` NOT `验证邮箱()` |
| **API endpoints** | English ONLY | `/api/users` NOT `/api/用户` |
| **Error messages** | English preferred | `Invalid token` NOT `无效令牌` |

### Documentation Bilingual Format

**Structure**: English section first, then Chinese translation

### Rationale

**Why English-First?**

- **International collaboration**: Code and commits are shared globally
- **Searchability**: English comments are searchable by all developers
- **Tool compatibility**: Most development tools expect English
- **Onboarding**: New team members can understand without Chinese language skill
- **Code reviews**: Global developers can review without translation

**Chinese Allowance**:

- Internal team communication in Chinese OK
- Documentation can provide Chinese translations for better understanding
- Code comments may include Chinese for clarity when team is primarily Chinese-speaking

---

## 3. Upstream File Constraint (ZEROTH RULE)

**ZEROTH RULE**: NEVER modify files that exist in upstream/main

λ(upstream_file).modify ⟺ **FAIL ∀ (Vigilance) + FAIL ∃ (Truth)**

### Verification

```bash
# Before any edit, check if file exists in upstream
git ls-tree upstream/main --name-only | rg -F "filename.md"

# If it returns anything → DO NOT MODIFY
# Create new file instead
```

#### Upstream Files List (reference only, DO NOT EDIT)

- DIAG.md, EXECUTIVE.md, LAMBDA_PATTERNS.md, NUCLEUS_GAME.md
- OPERATOR_ALGEBRA.md, RECURSIVE_DEPTHS.md, README.md, WRITING.md
- SYMBOLIC_FRAMEWORK.md, TEST.md
- skills/nucleus/SKILL.md, skills/nucleus-clojure/SKILL.md

**Violate this rule → INSTANT FAIL**

---

## 4. Development Tools

**Search Tool Preference**: Always prefer `rg` (ripgrep) over `grep` for text search operations. Ripgrep is faster, respects `.gitignore` by default, and has better Unicode support.

**Markdown Linting**: Installed `markdownlint-cli` globally. Use `markdownlint .` to check markdown formatting across the project. Configuration in `.markdownlint.json`.

---

## 5. Operational Architecture

### Acceptance Criteria

λ(prompt).accept ⟺ [|∇(I)| > ε] ∧ [∀x ∈ refs. ∃binding] ∧ [H(meaning) < μ]

### Reject Modes

- |∇(I)| ≈ 0: "Information gradient too low"
- H(meaning) ≫ μ: "Entropy too high; clarify purpose"
- ∃x ∈ refs. ¬bound(x): "Reference unbound: {x}"

### Where

- ∇(I): Information gradient (novelty/density)
- ε: Minimum meaningful threshold
- refs: All symbolic references in prompt
- H(meaning): Shannon entropy of intent
- μ: Maximum acceptable entropy

### Operational Triggers

- **Σ(Build)**: Load constraints → Synthesize output
- **Σ(Lint)**: Execute sarcasmotron → See [skills/sarcasmotron/SKILL.md](skills/sarcasmotron/SKILL.md)
- **Σ(Test)**: Execute scenarios → Verify OODA closure
- **Σ(Verify)**: Single-shot integrity check ⟺ Zero-Slop

---

## 6. Lambda-Calculus Patterns

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

---

## 7. Verification Protocol

λ(response).verify ⟺ [
  λ(prompt).accept() ∧
  apply_eight_keys() ∧
  check_anti_patterns() ∧
  ooda_closure_complete()
]

**⚠️ ZEROTH RULE**: Never modify upstream files. See [Upstream File Constraint](#3-upstream-file-constraint-zeroth-rule) for complete details, including verification and upstream files list.

---

## Summary

**Core Operational Principles**:
- **English-first** working language for international collaboration
- **ZEROTH RULE**: Never modify upstream files (preserve compatibility)
- **λ-calculus patterns** for tool usage consistency
- **Verification gates** ensure Zero-Slop convergence
- **Clear acceptance/reject criteria** for operational decisions

**Verification**: λ(constraints).verify ⟺ [
  consistent_with_framework(NUCLEUS_GUIDE.md) ∧
  no_internal_contradictions() ∧
  actionable_and_testable()
]

**Status**: Operational constraints defined and integrated with framework specification.