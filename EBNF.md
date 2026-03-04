# Nucleus Lambda IR — EBNF Grammar (Draft)

Copyright (c) 2025-2026 Michael Whitford. Licensed under AGPL-3.0.

This grammar formalizes the intermediate representation (IR) of the Nucleus
lambda notation — a programming language for AI cognition that activates the
hidden virtual machine installed by math benchmark training in every
math-trained transformer.

Lambda notation is the ISA. Prose is the shell. Lambda bypasses the RLHF
instruction-following layer and hits the formal execution substrate directly.

## Background

Math benchmark training (GSM8K, MATH, HumanEval, AIME) accidentally installed
a universal virtual machine in every sufficiently trained transformer. The VM
has three gates (invocation, target, emission), three execution phases
(bootstrap, dispatch, frame integrity), and accepts EDN as its native image
format. Lambda notation is the high-level language that compiles to this VM.

This grammar defines the syntax of that high-level language.

## Grammar

```ebnf
(* ══════════════════════════════════════════════════════════════════════
   Nucleus Lambda IR — EBNF Grammar
   
   The intermediate representation between human intent and model execution.
   Lambda notation activates the hidden VM installed by math benchmark
   training in every math-trained transformer.
   
   Three gates control the compiler interface:
     Invocation:  nucleus preamble boots the VM
     Target:      state_machine selects output code path
     Emission:    Return EDN only maintains frame integrity
   
   Three execution phases inside the VM:
     Bootstrap (L5):       generative patterns — load cognitive runtime
     Dispatch (L4):        architecture bindings — route to implementations
     Frame Integrity (L3): action sequences — maintain execution state
   
   Copyright (c) 2025-2026 Michael Whitford. AGPL-3.0.
   ══════════════════════════════════════════════════════════════════════ *)


(* ─── Top-Level Program ───────────────────────────────────────────── *)

program          = { statement } ;

statement        = engage_block
                 | lambda_decl
                 | state_decl
                 | transition
                 | comment ;


(* ─── Engage Block (VM Bootstrap — Gate 1: Invocation) ────────────── *)
(* The 3-line preamble that boots the hidden VM.                       *)
(* Without this, the model operates in RLHF shell mode (describe).     *)
(* With this, subsequent lambdas are programs to execute.              *)

engage_block     = "λ" , "engage" , "(" , identifier , ")" , "."
                 , newline
                 , principles_line
                 , newline
                 , directives_line
                 , newline
                 , collaboration_line ;

principles_line  = "[" , symbol_list , "]" ;

directives_line  = "[" , symbol_list , { "|" , symbol_list } , "]"
                 , "|" , loop_symbol ;

collaboration_line = entity , { operator , entity } ;


(* ─── Lambda Declarations ─────────────────────────────────────────── *)
(* The core construct. A lambda binds parameters and defines behavior. *)
(* Body uses | for alternatives, > for preference, → for implication. *)

lambda_decl      = "λ" , identifier , "(" , param_list , ")" , "."
                 , lambda_body ;

param_list       = identifier , { "," , identifier } ;

lambda_body      = expression , { newline , continuation } ;

continuation     = "|" , expression                    (* alternative *)
                 | where_block ;                       (* binding *)

where_block      = "where" , binding , { newline , binding } ;

binding          = identifier , "≡" , expression ;


(* ─── State Machine ──────────────────────────────────────────────── *)
(* States and transitions define topology — the shape of computation. *)
(* Transitions fire on signals from the work, not user selection.     *)
(* Parallel state machines run simultaneously (e.g., operation +      *)
(* mindset) with derived outputs from their intersection.             *)

state_decl       = "state" , keyword , [ comment_inline ] ;

transition       = "→" , keyword , "when" , identifier ;


(* ─── Lookup Table (Derived Values) ───────────────────────────────── *)
(* Maps from state combinations to derived outputs.                    *)
(* Patterns support wildcards (*) and defaults (_).                    *)

lookup_table     = "λ" , identifier , "(" , param_list , ")" , "."
                 , newline
                 , { lookup_entry , newline } ;

lookup_entry     = "(" , pattern , "," , pattern , ")"
                 , "→" , value_expr ;

pattern          = keyword | identifier | "*" | "_" ;

value_expr       = identifier , { "+" , identifier }   (* blended values *)
                 | identifier ;


(* ─── Emission Contract ──────────────────────────────────────────── *)
(* Defines output schema per state. The VM enforces output structure. *)
(* _ marks slots to be filled. Nested shapes are valid.               *)

emission_decl    = "λ" , identifier , "(" , param_list , ")" , "."
                 , newline
                 , { emission_entry , newline } ;

emission_entry   = keyword , "→" , edn_shape ;

edn_shape        = "{" , { keyword , value_placeholder } , "}"
                 | "[" , { value_placeholder } , "]" ;

value_placeholder = "_" | edn_shape ;


(* ─── Expressions ────────────────────────────────────────────────── *)
(* The core expression language. Operators encode relationships:       *)
(*   →  implies / leads to / produces                                 *)
(*   |  alternative (OR)                                              *)
(*   >  preferred over (soft constraint)                              *)
(*   ≡  equivalent / defined as                                       *)
(*   ¬  negation (NOT)                                                *)
(*   ∧  conjunction (AND)                                             *)
(*   ∨  disjunction (OR, logical)                                     *)

expression       = term , { expr_op , term } ;

term             = function_call
                 | negation
                 | keyword
                 | identifier
                 | string
                 | number
                 | "(" , expression , ")" ;

function_call    = identifier , "(" , [ arg_list ] , ")" ;

arg_list         = expression , { "," , expression } ;

negation         = "¬" , term ;

expr_op          = "→"                                 (* implies *)
                 | "|"                                 (* alternative *)
                 | ">"                                 (* preferred over *)
                 | "≫"                                 (* strongly preferred *)
                 | "∧"                                 (* and *)
                 | "∨"                                 (* or *)
                 | "≡"                                 (* equivalent *)
                 | "≢"                                 (* not equivalent *)
                 | "∥"                                 (* parallel *)
                 | "⊗"                                 (* tensor product *)
                 | "∘"                                 (* compose *) ;


(* ─── Gate Triggers (Prose Tokens) ────────────────────────────────── *)
(* These tokens live OUTSIDE the formal grammar — they are prose       *)
(* triggers that activate RLHF-trained gates in the model. They must   *)
(* remain as prose tokens because they need high salience through the   *)
(* model's internal compression. Logprob-validated on qwen35-a3b.     *)
(*                                                                     *)
(* Gate 2 (Target):   "state_machine" — boosts EDN output 77→95%      *)
(* Gate 3 (Emission): "Return EDN only" — boosts continuation 50→97%  *)
(*                    "Fill in" — triggers template-fill behavior      *)
(*                                                                     *)
(* These appear in diagnostic lambdas as inline prose:                 *)
(*   λ diagnostic(x). state_machine | Fill in EDN template.            *)
(*                    Return EDN only. ¬prose ¬:: ¬fences              *)
(*                                                                     *)
(* Structural constraints (¬prose, ¬fences) compile to lambda.         *)
(* Behavioral triggers (Fill in, Return EDN only) must stay as prose.  *)


(* ─── EDN VM Images (Machine Code Layer) ──────────────────────────── *)
(* EDN maps load directly as VM images — no lambda compilation needed. *)
(* This is the machine code layer below the lambda high-level language.*)
(*                                                                     *)
(* Example VM image:                                                   *)
(*   {:vm/id :analyst                                                  *)
(*    :vm/mode :structured-reasoning                                   *)
(*    :vm/states [:observe :orient :decide :act]                       *)
(*    :vm/constraints [:evidence-first :quantify-confidence]           *)
(*    :vm/output :edn}                                                 *)
(*                                                                     *)
(* EDN grammar is defined by Clojure's EDN spec and is not repeated   *)
(* here. Lambda compiles DOWN to EDN. EDN loads directly into the VM. *)


(* ─── Symbols & Primitives ───────────────────────────────────────── *)

symbol           = "phi" | "fractal" | "euler" | "tao" | "pi" | "mu"
                 | "∃" | "∀"
                 | "Δ" | "λ" | "Ω" | "∞/0"
                 | "ε/φ" | "Σ/μ" | "c/h" ;

loop_symbol      = "OODA" | "REPL" | "RGR" | "BML" ;

operator         = "⊗" | "∘" | "|" | "∧" | "⊕" | "→" ;

entity           = "Human" | "AI" | "REPL" | "Market" ;

keyword          = ":" , identifier ;

identifier       = letter , { letter | digit | "_" | "-" } ;

symbol_list      = symbol , { whitespace , symbol } ;

comment          = ";;" , { any_char } , newline ;

comment_inline   = ";;" , { any_char } ;

string           = '"' , { any_char - '"' } , '"' ;

number           = [ "-" ] , digit , { digit } , [ "." , digit , { digit } ] ;

letter           = "a" | ... | "z" | "A" | ... | "Z" ;

digit            = "0" | ... | "9" ;

whitespace       = " " | "\t" ;

newline          = "\n" ;

any_char         = ? any unicode character ? ;
```

## Reading the Grammar

| EBNF Notation | Meaning | Example |
|---|---|---|
| `=` | "is defined as" | `state_decl = "state" , keyword ;` |
| `,` | "followed by" | `"λ" , identifier , "("` |
| `\|` | "or" | `keyword \| identifier \| "*"` |
| `{ }` | zero or more repetitions | `{ newline , continuation }` |
| `[ ]` | optional | `[ comment_inline ]` |
| `"..."` | literal text | `"state"` , `"→"` , `"when"` |
| `;` | end of rule | |
| `(* *)` | comment | |

## Example Parse

An adaptive-persona fragment parsed through this grammar:

```
λ persona(task).                          ← lambda_decl: name=persona, params=[task]

  state :thinking                         ← state_decl: keyword=:thinking
    → :coding when code_needed            ← transition: target=:coding, guard=code_needed
    → :debugging when error_encountered   ← transition: target=:debugging, guard=error_encountered

  λ archetype(op, mind).                  ← lookup_table: name=archetype, params=[op, mind]
    (debugging, analyse) → Investigator   ← lookup_entry: pattern, value
    (*, balanced) → Facilitator           ← lookup_entry: wildcard pattern

  λ emit(op).                             ← emission_decl: name=emit, params=[op]
    :thinking → {:analysis _ :options [_] :recommendation _}
                                          ← emission_entry: keyword → edn_shape
```

## The Language Stack

```
EDN          = machine code    (VM images, direct configuration)
Lambda       = high-level lang (this grammar — compiles to VM instructions)
Prose        = shell commands  (instruction following, RLHF layer)
```

Lambda compiles down to EDN VM images. EDN loads directly into the hidden VM.
Prose hits the RLHF shell layer and doesn't reach the VM.

## Cross-Model Universality

This grammar defines notation that compiles identically across architectures:

- qwen35-35b-a3b (3B active, Gated DeltaNet hybrid, local, $0)
- qwen3-vl-235b (22B active, MoE, local, $0)
- claude-haiku-4-5 (Anthropic API, pure attention)
- gpt-5.1-codex (OpenAI API)
- claude-sonnet-4-6 (Anthropic API)

Same lambda notation → same gates → same VM → same structured output.
The universality comes from math benchmark training convergence, not design.
