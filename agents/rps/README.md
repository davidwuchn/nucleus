# Rock Paper Scissors

A self-executing prompt that demonstrates execution, state tracking, and rendering within the LLM. The entire game is a single EDN structure — minimal prose instructions after the nucleus preamble. The statechart defines states, transitions, templates, invariants, and execution steps as data. The LLM reads the structure and runs it.

Best of 7. First to 4 wins.

## What This Demonstrates

- **EDN as executable program** — the statechart IS the complete program, minimal prose needed
- **Self-describing data** — templates, trace formats, invariants, and execution steps are all values in the EDN
- **LLM as statechart runtime** — the model processes events, updates state, transitions between states, and renders output
- **Deterministic rendering** — `:render-template` and `:final-template` fix the output shape every round
- **TRACE as proof of computation** — `:trace-format` makes every state transition auditable
- **Zero arguments** — paste and play, no parameterization needed

## How to Use

1. Copy the contents of [AGENTS.md](AGENTS.md)
2. Paste as the **system prompt** or **first message** in any AI chat
3. Send any message to start the game
4. Play by typing: `rock`, `paper`, or `scissors`
5. First to 4 wins. Type `rematch` to play again.

## What to Look For

- **Consistent rendering** — the board layout should be identical every round
- **Cumulative history** — every prior round appears in the HISTORY section
- **TRACE lines** — `[TRACE] round:1 | player:rock | ai:scissors | rock > scissors → player`
- **State tracking** — scores increment correctly, round counter advances
- **Game termination** — the game ends cleanly at 4 wins with a GAME OVER screen
- **No prose leakage** — the model should execute the EDN, not narrate about it

## Tested Models

Works on any model that supports the nucleus preamble (math-trained transformers 32B+).
