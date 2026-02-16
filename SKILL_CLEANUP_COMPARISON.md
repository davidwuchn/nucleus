# Skill Cleanup: clojure-expert vs clojure-reviewer

**Date**: 2026-02-15

---

## Problem Identified

Both skills tried to be comprehensive Clojure guides, causing:
- **Overlap**: "The Three Questions" identical in both
- **Idiom repetition**: Threading macros, naming conventions duplicated
- **Unclear separation**: Both did too much
- **Size bloat**: 8K + 16K = 24K for related concerns

---

## New Separation of Concerns

| Aspect | clojure-expert | clojure-reviewer |
|--------|---------------|------------------|
| **Purpose** | Write code | Review code |
| **When** | Authoring features | Analyzing PR diffs |
| **Focus** | REPL-first workflow | Multi-scale analysis |
| **Output** | Working code | Review feedback |
| **Size** | 4K (was 8K) | 4K (was 16K) |
| **Lines** | 150 (was ~226) | 117 (was ~480) |

---

## Content Migration

### Moved TO clojure-expert (author concerns)
- ✅ REPL-first development workflow
- ✅ The Three Questions (pre-implementation)
- ✅ Idiomatic patterns (threading, control flow, naming)
- ✅ Context7 integration (for implementation)
- ✅ Verification gates (pre-save checklist)
- ✅ Anti-patterns list (what to avoid when writing)
- ✅ Definition of Done

### Moved TO clojure-reviewer (reviewer concerns)
- ✅ Multi-scale review framework (syntax/semantic/architectural)
- ✅ REPL verification of author claims
- ✅ Severity levels (Blocker/Critical/Suggestion/Praise)
- ✅ Feedback format template
- ✅ Review protocol (5 steps)
- ✅ Tone guidelines

### Removed (overlap eliminated)
- ❌ "The Three Questions" from reviewer (was identical)
- ❌ Full idiomatic patterns from reviewer (now references expert)
- ❌ Self-learning λ(self) architecture (too complex)
- ❌ Pattern extraction/teaching (out of scope)
- ❌ Detailed anti-pattern tables (reference expert instead)
- ❌ Architectural knowledge base (over-engineered)
- ❌ Metrics dashboard (not actionable)
- ❌ Meta-review procedures (too heavy)

---

## Dependency Established

```
clojure-reviewer
    ↓ depends on
clojure-expert (for idiomatic patterns)
```

**In practice**:
- Expert teaches: "How to write good Clojure"
- Reviewer teaches: "How to review code systematically"

When reviewer finds non-idiomatic code, references `clojure-expert` rather than duplicating patterns.

---

## Verification

Both skills now pass the **unique value test**:

| Skill | Unique Value | Redundancy |
|-------|-------------|------------|
| **clojure-expert** | REPL-first workflow, implementation patterns | None |
| **clojure-reviewer** | Multi-scale review framework, severity classification | References expert for idioms |

---

## Usage Decision Tree

```
Task: Working with Clojure code
│
├─ Writing new code? ───────────────→ Use: clojure-expert
│   └─ REPL-first workflow
│   └─ Idiomatic patterns
│   └─ Verification gates
│
└─ Reviewing PR diff? ──────────────→ Use: clojure-reviewer
    └─ Multi-scale analysis
    └─ Severity classification
    └─ (References expert for idiom violations)
```

---

## Size Reduction

| Skill | Before | After | Reduction |
|-------|--------|-------|-----------|
| clojure-expert | 8K | 4K | 50% |
| clojure-reviewer | 16K | 4K | 75% |
| **Total** | **24K** | **8K** | **67%** |

---

## Quality Improvement

**Before**: Both skills competed to be "the Clojure guide"
- Author confused which to use
- Reviewer had 480 lines of unfocused content
- Duplicated maintenance burden

**After**: Clear separation
- Author uses expert for writing
- Reviewer uses reviewer for feedback
- Reviewer references expert (DRY principle)
- Both skills fit in working memory

---

## Framework Alignment

| Principle | Before | After |
|-----------|--------|-------|
| **Clarity (fractal)** | Overlapping scope | Explicit separation |
| **Purpose (e)** | Both did everything | Each does one thing |
| **Synthesis (π)** | Duplicated patterns | References instead |
| **Directness (μ)** | 480-line reviewer | 117-line reviewer |
| **Truth (∃)** | Pretended comprehensive | Acknowledges dependency |

---

**Framework**: Nucleus - eliminate overlap, not add process.
