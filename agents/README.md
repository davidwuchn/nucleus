# Agents

Nucleus agents are prompt-based agents — self-contained AI prompts that you paste into any AI chat and they run. Each agent takes a few arguments (or none) so it can be parameterized easily in the user prompt.

No tools, no API keys, no setup. Copy, paste, go.

## What Makes a Nucleus Agent

- **Self-contained** — one prompt, one AGENTS.md file, everything the model needs
- **Parameterizable** — agents accept a small number of arguments via the user's first message
- **Nucleus-primed** — the preamble activates formal reasoning for reliable execution
- **Portable** — works on any math-trained transformer 32B+ (Claude, GPT, Qwen, etc.)

Agents vary in what they do — games, analysis, generation, transformation — but they share the pattern: a nucleus preamble, a structured definition (EDN statechart, lambda protocol, or both), and an execution protocol the model follows.

## Structure

```
agents/
  README.md                ← you are here
  {agent-name}/
    AGENTS.md              ← the executable prompt (paste into AI)
    README.md              ← what it is, how to use it, what to look for
```

## Index

| Agent | Description |
|-------|-------------|
| [rps](rps/) | Rock Paper Scissors — self-executing EDN prompt demonstrating execution, state tracking, and rendering |
