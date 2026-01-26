# Nucleus Principles

[phi fractal euler tao pi mu] | [Δ λ ∞/0 | ε/φ Σ/μ c/h] | OODA
Human ⊗ AI ⊗ REPL

**For theory**: See [PHILOSOPHY_RESEARCH.md](PHILOSOPHY_RESEARCH.md) for I Ching × Eight Keys philosophical synthesis
**For local changes tracking**: See [LOCAL_CHANGES.md](LOCAL_CHANGES.md) for upstream vs local file tracking

---

## Language Policy (ENGLISH-FIRST WORKING LANGUAGE)

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

## Upstream File Constraint (ZEROTH RULE)

**ZEROTH RULE**: NEVER modify files that exist in upstream/main

λ(upstream_file).modify ⟺ **FAIL ∀ (Vigilance) + FAIL ∃ (Truth)**

**Verification**:

```bash
# Before any edit, check if file exists in upstream
git ls-tree upstream/main --name-only | rg -F "filename.md"

# If it returns anything → DO NOT MODIFY
# Create new file instead
```

**Upstream Files List** (reference only, DO NOT EDIT):

- DIAG.md, EXECUTIVE.md, LAMBDA_PATTERNS.md, NUCLEUS_GAME.md
- OPERATOR_ALGEBRA.md, RECURSIVE_DEPTHS.md, README.md, WRITING.md
- SYMBOLIC_FRAMEWORK.md, TEST.md
- skills/nucleus/SKILL.md, skills/nucleus-clojure/SKILL.md

**Violate this rule → INSTANT FAIL**

## Protected Local Files Rule

**PROTECTED RULE**: Before editing critical local configuration files, always ask the user for explicit permission.

**Protected Files**:

- @/Users/davidwu/workspace/nucleus/AGENTS.md
- @/Users/davidwu/workspace/nucleus/PHILOSOPHY_RESEARCH.md  
- @/Users/davidwu/workspace/nucleus/NUCLEUS_GUIDE.md

**Verification**:

- Before editing any file matching the protected list, confirm with the user
- If the file is in the protected list → ASK FIRST
- Protected files are local-only files that contain core framework rules

**Violate this rule → INSTANT FAIL**

## Development Tools

**Search Tool Preference**: Always prefer `rg` (ripgrep) over `grep` for text search operations. Ripgrep is faster, respects `.gitignore` by default, and has better Unicode support.

**Markdown Linting**: Installed `markdownlint-cli` globally. Use `markdownlint .` to check markdown formatting across the project. Configuration in `.markdownlint.json`.

*For complete framework specification including philosophy, operational architecture, lambda-calculus patterns, verification protocol, and implementation constraints, see [NUCLEUS_GUIDE.md](NUCLEUS_GUIDE.md).*
