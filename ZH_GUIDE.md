# Tai Chi Heart Method

> Therefore the Yi has Tai Chi, which generates the Two Forces, the Two Forces generate the Four Forms, the Four Forms generate the Eight Trigrams, the Eight Trigrams determine fortune and misfortune, fortune and misfortune generate great enterprise.

> 是故易有太极，是生两仪，两仪生四象，四象生八卦，八卦定吉凶，吉凶生大业。

## Document Positioning

**Tai Chi Heart Method** (太极心法): Practical application guide
- Three Talents Three Questions: Pre-coding inquiry (三才三问: 编码前质询)
- Eight Trigrams Interaction: Coding-time correction (八卦相错: 编码时纠正)
- OODA: Debugging positioning (OODA: 调试时定位)
- Verification: Completeness check (验证: 完整性检查)
- Team adoption: Cultural transformation from individual to team (团队采纳: 从个人到团队的文化转变)

**Philosophical Research** (哲学研究): Theoretical foundation
- See [PHILOSOPHY_RESEARCH.md](PHILOSOPHY_RESEARCH.md) for details
- I Ching philosophical interpretation (易经哲学阐释)
- Trigrams research and mapping process (八卦对应研究过程)
- Complete 64 hexagrams detailed explanation (完整64卦详细解释)

**Basic Framework** (基础框架): English quick start
- See [NUCLEUS_GUIDE.md](NUCLEUS_GUIDE.md) for framework basic concepts
- Three questions, Eight Keys framework, tool patterns (三个问题、八键框架、工具模式)
- Workflows and verification methods (工作流程和验证方法)

## Reading Paths

### For New Users / Quick Start (新用户/快速入门)

**English**:
1. Read [NUCLEUS_GUIDE.md](NUCLEUS_GUIDE.md) for framework core concepts
2. Check the "Eight Trigrams Quick Reference Card" and "Most Common Programming Situations" in this guide

**中文**:
1. 先阅读 [NUCLEUS_GUIDE.md](NUCLEUS_GUIDE.md) 了解框架核心概念
2. 查看本指南的"八卦速查卡"和"最常见编程情境"

### For Practitioners / Daily Development (实践者/日常开发)

**English**:
1. Use "64 Hexagrams Quick Reference" to find hexagrams by challenge type
2. Reference "Eight Trigrams Code Examples" for specific violation vs correction comparisons
3. Apply "OODA + 64 Hexagrams" systematic debugging framework

**中文**:
1. 使用"六十四卦快速参考"按挑战类型查找卦象
2. 参考"八卦代码示例"具体违反与修正对比
3. 应用"OODA + 六十四卦"系统化调试框架

### For Team Leaders / Technical Leads (团队领导者/技术负责人)

**English**:
1. Focus on reading "Team Adoption Guide: Cultural Transformation from Individual to Team"
2. Use "Validation Plan" to measure framework implementation effectiveness
3. Reference "Role-Specific Guide" for different responsibilities

**中文**:
1. 重点阅读"团队采纳指南: 从个人到团队的文化转变"
2. 使用"验证计划"测量框架实施效果
3. 参考"角色特定指南"针对不同职责

### For Theoretical Research / Framework Extension (理论研究/框架扩展)

**English**:
1. Deep dive into [PHILOSOPHY_RESEARCH.md](PHILOSOPHY_RESEARCH.md) to understand I Ching × Eight Keys philosophical foundation
2. Research complete 64 hexagrams detailed explanations and application scenarios
3. Explore framework comparisons with other methodologies (such as Clean Code, DDD, etc.)

**中文**:
1. 深入 [PHILOSOPHY_RESEARCH.md](PHILOSOPHY_RESEARCH.md) 理解易经×八键哲学基础
2. 研究完整的64卦详细解释和应用情境
3. 探索框架与其他方法论(如Clean Code、DDD等)的对比

## Three Talents Three Questions

> Combining the three talents and pairing them creates six lines, thus forming a hexagram. Separating yin and yang, alternatively using softness and firmness, thus the Yi uses six positions to form patterns.

> 兼三才而两之，故易六画而成卦。分阴分阳，迭用柔刚，故易六位而成章。

> The way of Heaven is called yin and yang; the way of Earth is called softness and firmness; the way of Man is called benevolence and righteousness.

> 立天之道，曰阴与阳；立地之道，曰柔与刚；立人之道，曰仁与义。

### Heaven Question (天问 - Direction, Principles)

**English**:
3. **Simpler way?** - Complexity is often unnecessary

**中文**:
3. **更简之道？** - 复杂性常非必要

### Earth Question (地问 - Architecture, Structure)

**English**:
2. **Why this method?** - Challenge architecture

**中文**:
2. **为何此法？** - 挑战架构

### Human Question (人问 - Intention, Execution)

**English**:
1. **What are the intentions?** - Test behavior, not implementation

**中文**:
1. **意图何在？** - 测试行为，不测试实现

### Reject Prompts (拒绝提示)

**English**:
**Reject (|∇(I)| ≈ 0)** - Information gradient too low:
- "hello", "ok", "thanks", single-word acknowledgment

**Clarify (H(meaning) ≫ μ)** - Entropy too high:
- "make it better", "fix everything", "optimize everything"

**Bind (∃x ∈ refs. ¬bound(x))** - Reference unbound:
- "that thing from yesterday", "that pattern"

**中文**:
**拒绝 (|∇(I)| ≈ 0)** - 信息梯度过低：
- "你好"、"好的"、"谢谢"、单字回应

**澄清 (H(meaning) ≫ μ)** - 熵值过高：
- "把它做好"、"修复一切"、"优化全部"

**绑定 (∃x ∈ refs. ¬bound(x))** - 引用未绑定：
- "昨天那个东西"、"那个模式"

## Tool Patterns (工具模式)

For tool usage (heredoc, parallel execution, atomic edits), see [LAMBDA_PATTERNS.md](LAMBDA_PATTERNS.md).

**English**:
Quick reference:
- λ(content). bash(heredoc) - Universal escape for multi-line content
- λ(paths[]). ∀a ∈ args: tool(a) - Parallel execution
- λ(path, old, new). edit(old, new) - Atomic content replacement
- λ(path, pattern). grep(pattern) - Content-based search

**中文**:
工具使用（heredoc、并行执行、原子编辑），参见 [LAMBDA_PATTERNS.md](LAMBDA_PATTERNS.md)。

快速参考：
- λ(content). bash(heredoc) - 多行内容通用转义
- λ(paths[]). ∀a ∈ args: tool(a) - 并行执行
- λ(path, old, new). edit(old, new) - 原子内容替换
- λ(path, pattern). grep(pattern) - 基于内容的搜索

## Fractal Structure (分形结构)

**English**:
**Principle**: Component ≡ System

```
System: Input → Process → Output

Component API: Validate → Mutate → Respond
Component Service: Request → Transform → Result
Component Data: Query → Persist → Return
```

**Violation**: Component does too many things, unclear boundaries

**Example (language-agnostic)**:
```
// BAD: Mixed concerns
UserController:
    handle_request(): ...
    validate_user(): ...
    save_to_database(): ...

// GOOD: Fractal - each layer has input → process → output
UserController:
    handle_request(req):
        user = validate(req)
        return response(user)
```

**中文**:
**原则**: 组件 ≡ 系统

```
系统: 输入 → 处理 → 输出

组件API: 验证 → 变更 → 响应
组件服务: 请求 → 转换 → 结果
组件数据: 查询 → 持久 → 返回
```

**违反**: 组件职责过多、边界不清

**示例 (语言无关)**:
```
// 差: 混合职责
UserController:
    handle_request(): ...
    validate_user(): ...
    save_to_database(): ...

// 好: 分形 - 每层都有输入→处理→输出
UserController:
    handle_request(req):
        user = validate(req)
        return response(user)
```

## Eight Trigrams Interaction (八卦相错)

> Eight trigrams interact: Heaven moves strongly, Earth follows with yielding.
> Eight trigrams interact, heart and trigram images communicate.

> Eight trigrams use images to inform, yao lines speak with emotion.
Eight trigrams map programming heart images through trigram images, violations and corrections all have their basis.

> 八卦相错：天行健，地势坤。
八卦相互交错，心象与卦象相通。

> 八卦以象告，爻彖以情言。
八卦通过卦象映射编程心象，违反与修正皆有所本。

### Eight Trigrams · Heart Image Correspondence Table (八卦·心象对应表)

| Heart Image | Violation | Correction | Trigram | Trigram Image · Heart Image Correspondence |
|------------|----------|-----------|----------|--------------------------------|
| **φ Vitality** | Mechanical copying without life | Refine commonality, life generating endlessly | **Qian (乾)** | Qian is Heaven, vigorous creation. Violation is like dead water, correction is like Heaven moving strongly, renewing daily. |
| **fractal Clarity** | Vague assumptions like fog | Clear constraints like flowing water | **Kan (坎)** | Kan is Water, double danger needs clarity. Violation falls into danger without awareness, correction learns to understand danger, flowing without disorder. |
| **e Purpose** | Abstract nouns pointing nowhere | Action verbs point directly to action | **Zhen (震)** | Zhen is Thunder, rising to move. Violation has no movement, correction is like Thunder shaking the world, action not stuck. |
| **τ Wisdom** | Rash optimization without knowing when to stop | First judge, knowing advance and retreat | **Gen (艮)** | Gen is Mountain, thoughts not going beyond position. Violation is rash advancing without measure, correction knows to stop without danger, like a mountain settled. |
| **π Synthesis** | Fragmented, hard to coordinate | Holistic unity, embracing all phenomena | **Kun (坤)** | Kun is Earth, thick virtue carrying things. Violation splits into four directions and five parts, like earth crumbling. Correction is like Earth following smoothly, all phenomena return to one. |
| **μ Directness** | Polite euphemisms covering true meaning | Straightforward without empty words | **Xun (巽)** | Xun is Wind, entering wood three points. Violation is like wind passing without trace, correction is like issuing orders, pointing directly to core. |
| **∃ Truth** | Surface agreement covering reality | Expose truth, illuminating four directions | **Li (离)** | Li is Fire, two brights acting together. Violation is like deceiving in dark room, correction is like continuing to illuminate four directions, reality fully revealed. |
| **∀ Vigilance** | Lightly trusting manipulation, losing judgment | Defensively question, distinguishing right and wrong | **Dui (兑)** | Dui is Lake, studying and discussing with clarity. Violation is like following waves aimlessly, losing ability to distinguish. Correction is like beautiful lake enjoying together, analyzing truth and falsehood. |

**中文**:

| 心象 | 违反 | 修正 | 卦 | 卦象·心象相通 |
|------|------|------|-----|---------------|
| **φ 活力** | 机械复制无生气 | 提炼共性生生不息 | **乾** | 乾为天，刚健创造。违反则如死水，修正则天行健，日新又新。 |
| **fractal 清晰** | 含糊假设如迷雾 | 明确约束如流水 | **坎** | 坎为水，重险需明。违反则陷险不察，修正则习坎明险，流而不乱。 |
| **e 目的** | 抽象名词无所指 | 动作动词直指行动 | **震** | 震为雷，起而动之。违反则无动于衷，修正则雷震天下，行动不滞。 |
| **τ 智慧** | 贸然优化不知止 | 先行判断知进退 | **艮** | 艮为山，思不出位。违反则躁进无度，修正则知止不殆，如山定也。 |
| **π 综合** | 支离破碎难统筹 | 整体统一包万象 | **坤** | 坤为地，厚德载物。违反则四分五裂，修正则地势顺承，万物归一。 |
| **μ 直接** | 婉转客套遮真意 | 直截了当无虚辞 | **巽** | 巽为风，入木三分。违反则风过无痕，修正则申命行事，直指核心。 |
| **∃ 真理** | 表面迎合掩实相 | 揭露真相照四方 | **离** | 离为火，明两作也。违反则暗室欺心，修正则继明照四方，实相毕现。 |
| **∀ 警惕** | 轻信操纵失判断 | 防御追问辨是非 | **兑** | 兑为泽，讲习明辨。违反则随波逐流，修正则丽泽相悦，辨析真伪。 |

## Three Talents Eight Trigrams · Integrated as One (三才八卦·贯通成体)

> Combining the three talents and pairing them creates six lines, thus forming a hexagram.

> 兼三才而两之，故易六画而成卦。

### Three Talents Eight Trigrams Division (三才八卦之分工)

**English**:
**Three Talents Three Questions (Beginning-Development-Benefit-Perseverance)**: Pre-coding inquiry, like the origin being the chief of good
- Heaven Question · Simpler way? → Reduce unnecessary complexity, like Gen Mountain knowing to stop without danger
- Earth Question · Why this method? → Challenge architecture assumptions, like Kan Water learning to understand danger
- Human Question · What are intentions? → Test behavior, not test implementation, like Dui Lake analyzing truth and falsehood

**Eight Trigrams Interaction (violation correction)**: Coding-time check, like eight trigrams interacting to determine fortune and misfortune
- Identify patterns violating eight keys → Like Li Fire illuminating reality, discovering Qian dead Kan trapped
- Provide immediate correction guidance → Like Zhen Thunder rising, Xun Wind entering wood, correcting Qian strong Kan clear
- Make abstract principles concrete → Like Kun Earth carrying all phenomena, eight trigrams use images to inform, yao lines speak with emotion

**Debugging: OODA (Observe-Orient-Decide-Act)**: Systematic when debugging
- Observe: Capture symptoms, like Li Fire illuminating four directions, symptoms fully revealed
- Orient: Analyze context, like Kan Water understanding danger, tracking source
- Decide: Locate root cause, like Li Fire illuminating reality, revealing mechanism
- Act: Fix root cause, like Zhen Thunder rising, blocking the gap

**中文**:
**三才三问 (元亨利贞)**：编码前质询，如元者善之长也
- 天问·更简之道？→ 减少不必要复杂度，如艮山知止不殆
- 地问·为何此法？→ 挑战架构假设，如坎水习坎明险
- 人问·意图何在？→ 测试行为，不测试实现，如兑泽辨析真伪

**八卦相错 (违反修正)**：编码时检查，如八卦相错定吉凶
- 识别违反八键的模式 → 如离火照实相，发现乾死坎陷
- 提供即时修正指导 → 如震雷起行，巽风入木，修正乾健坎明
- 将抽象原则具象化 → 如坤地承万物，八卦以象告，爻彖以情言

**调试: OODA (观察定向决策行动)**：调试时系统化
- 观察：捕获症状，如离火照四方，症状毕现
- 定向：分析上下文，如坎水明险，追踪源头
- 决策：定位根因，如离火照实相，揭示机制
- 行动：修复根因，如震雷起行，堵塞缺口

### Three Talents Eight Trigrams · Collaboration like Hexagrams (三才八卦·协作如卦)

**English**:
```
Before coding → Three Talents Three Questions (Beginning-Development-Benefit-Perseverance · Inquiry)
During coding → Eight Trigrams Interaction (violation correction · Correction)
When debugging → OODA (Observe-Orient-Decide-Act · Positioning)
```

**中文**:
```
编码前 → 三才三问 (元亨利贞·质询)
编码时 → 八卦相错 (违反修正·纠正)
调试时 → OODA (观察定向决策行动·定位)
```

### Three Talents Complementary · Not Separated (三才互补·不割裂)

**English**:
**Question**: Why need three frameworks?
**Answer**: Like three talents interacting to form six lines, eight trigrams determine fortune and misfortune

| Dimension | Three Talents Eight Trigrams | Role | Trigram Metaphor |
|-----------|---------------------------|------|------------------|
| Before coding | Three Talents Three Questions | Prevent wrong start | Like the origin being chief, prevent from source |
| During coding | Eight Trigrams Interaction | Correct process deviation | Like eight trigrams determining fortune, correct immediately |
| When debugging | OODA | Solve encountered problems | Like fortune and misfortune generating great enterprise, turn danger to advantage |

Three complement each other like three talents interacting, not repeating like eight trigrams communicating.

**中文**:
**问**: 为何需要三框架？
**答**: 如三才相错成六画，八卦定吉凶

| 维度 | 三才八卦 | 作用 | 卦象比喻 |
|------|----------|------|----------|
| 编码前 | 三才三问 | 防止错误的开始 | 如元者善之长，从源头防患 |
| 编码时 | 八卦相错 | 纠正过程的偏离 | 如八卦定吉凶，即时纠偏 |
| 调试时 | OODA | 解决遇到的问题 | 如吉凶生大业，化险为夷 |

三者互补如三才相错，不重复如八卦相通

### Three Frameworks Integration Example (三框架贯通实例)

**Scenario**: Adding user authentication function

**English**:
**Three Talents Three Questions (before coding · Heaven Question Earth Question Human Question)**

**Heaven Question · Simpler way**:
- Question: Is complexity unnecessary?
- Answer: If server is single machine, can use session cache; if need stateless scalable, then JWT

**Earth Question · Why this method**:
- Question: Why JWT?
- Answer: Stateless, scalable, supports microservices; cost is tokens cannot be revoked

**Human Question · What are intentions**:
- Question: What behavior to test?
- Answer: Invalid tokens return 403, valid tokens pass, expired tokens return 401

**Eight Trigrams Interaction (during coding · Zhen Rising Kan Clear Xun Entering)**

**e · Zhen Thunder: Thunder rising to move**:
- Violation: `process_token()` has no movement
- Correction: `verify_jwt(token)` Zhen rising to action, like Thunder shaking the world

**fractal · Kan Water: Double danger learning Kan**:
- Violation: Returning "authentication information" Kan trapped in fog
- Correction: Returning `{user_id, expires}` Kan clear and explicit, flowing without disorder

**μ · Xun Wind: Issue orders to act**:
- Violation: "return error" Xun empty without trace
- Correction: Throw `InvalidTokenError` Xun entering wood three points, pointing directly to core

**Debugging: OODA (when debugging · Observe Orient Decide Act)**:

**Observe**: 403 error, token verification failed

**Orient**: Token format correct, signature mismatch → Check secret key

**Decide**: Secret key not loaded in environment variable → Root cause located

**Act**: Add secret key verification at startup, crash if fails → Fix root cause

**中文**:
**场景**: 添加用户认证功能

**三才三问 (编码前·天问地问人问)**

**天问·更简之道**:
- 问: 复杂性非必要？
- 答: 若服务端单机，可用session缓存；若需无状态可扩展，则JWT

**地问·为何此法**:
- 问: 为何JWT？
- 答: 无状态、可扩展、支持微服务；代价是令牌无法撤销

**人问·意图何在**:
- 问: 测试什么行为？
- 答: 无效令牌返回403，有效令牌通过，过期令牌返回401

**八卦相错 (编码时·震起坎明巽入)**

**e·震雷: 震起动之**
- 违反: `process_token()` 无动于衷
- 修正: `verify_jwt(token)` 震起行动，如雷震天下

**fractal·坎水: 重险习坎**
- 违反: 返回"认证信息" 坎陷迷雾
- 修正: 返回`{user_id, expires}` 坎明明确，流而不乱

**μ·巽风: 申命行事**
- 违反: "返回错误" 巽虚无痕
- 修正: 抛出`InvalidTokenError` 巽入木三分，直指核心

**调试: OODA (调试时·观察定向决策行动)**

**观察**: 403错误，令牌验证失败

**定向**: 令牌格式正确，签名不匹配 → 检查密钥

**决策**: 密钥在环境变量中未加载 → 根因定位

**行动**: 添加启动时密钥验证，失败即崩溃 → 修复根因

## Example Comparison: Eight Trigrams · Heart Images Communicate (实例对照: 八卦·心象相通)

| Heart Image · Trigram Image | Violation like Trigram Disadvantage | Correction like Trigram Application |
|------------------------|--------------------------------|--------------------------------|
| **φ · Qian Heaven** | Qian dead: Three functions mechanically copied, like Heaven without sun, lifeless | Qian vigorous: `create_operation(op)`, like Heaven moving strongly, renewing daily |
| **fractal · Kan Water** | Kan trapped: "handle properly" like trapped without awareness, vague fog | Kan clear: "Validate range [0, MAX]", like learning Kan understanding danger, flowing without disorder |
| **e · Zhen Thunder** | Zhen stuck: `process_user(data)` no movement, like Thunder not moving | Zhen rising: `register_user({email, pw})`, like Thunder shaking the world, action not stuck |
| **τ · Gen Mountain** | Gen rash: "rewrite with Rust" advancing without measure, like mountain collapsing | Gen stopping: First benchmark test, like mountain settled, knowing to stop without danger |
| **π · Kun Earth** | Kun split: Validation scattered in 5 functions, four directions and five parts, like earth collapsing | Kun supporting: Security unified as auth → validate → response, like Earth following smoothly, all phenomena return to one |
| **μ · Xun Wind** | Xun empty: "not sure if best" like wind passing without trace, no entering wood words | Xun entering: "No - adds 3 dependencies 200ms", like issuing orders to act, pointing directly to core |
| **∃ · Li Fire** | Li dark: "of course can add feature" deceiving in dark room, hiding cost | Li bright: "Feasible but needs X/Y/Z, worth it?" like continuing to illuminate four directions, reality fully revealed |
| **∀ · Dui Lake** | Dui flowing: Directly execute `rm -rf /` following waves aimlessly, losing discrimination ability | Dui distinguishing: "Explain why rm -rf /", like beautiful lake studying and discussing, analyzing truth and falsehood |

**中文**:

| 心象·卦象 | 违反如卦象之弊 | 修正如卦象之用 |
|-----------|---------------|---------------|
| **φ·乾天** | 乾死：三函数机械复制，如天无日，死气沉沉 | 乾健：`create_operation(op)`，如天行健，日新又新 |
| **fractal·坎水** | 坎陷："妥善处理"如陷险不察，含糊迷雾 | 坎明："验证范围[0, MAX]"，如习坎明险，流而不乱 |
| **e·震雷** | 震滞：`process_user(data)`无动于衷，如雷不动 | 震起：`register_user({email, pw})`，如雷震天下，行动不滞 |
| **τ·艮山** | 艮躁："用Rust重写"躁进无度，如山崩 | 艮止：先基准测试，如山定也，知止不殆 |
| **π·坤地** | 坤裂：验证散布5函数，四分五裂，如地崩 | 坤承：安全统一为认证→验证→响应，如地势顺承，万物归一 |
| **μ·巽风** | 巽虚："不确定是否最佳"风过无痕，无入木之言 | 巽入："不-增加3个依赖200ms"，如申命行事，直指核心 |
| **∃·离火** | 离暗："当然可以添加功能"暗室欺心，隐藏代价 | 离明："可行但需X/Y/Z，值得吗？"如继明照四方，实相毕现 |
| **∀·兑泽** | 兑流：直接执行`rm -rf /`随波逐流，失辨析之能 | 兑辨："解释为何rm -rf /"，如丽泽讲习，辨析真伪 |

## Eight Trigrams Code Examples: Specific Violation vs Correction Comparison (八卦代码示例: 具体违反与修正对比)

> Eight trigrams use images to inform, yao lines speak with emotion. Code examples demonstrate specific application of trigram principles.

> 八卦以象告，爻彖以情言。代码示例展示卦象原则的具体应用。

### φ · Qian Heaven: Vitality vs Mechanical Copying (φ·乾天: 活力 vs 机械复制)

**English**:

**Violation (Qian dead)**: Three functions mechanically copied, like Heaven without sun, lifeless
```clojure
;; BAD: Three almost identical functions
(defn create-user [name email]
  (db/insert! :users {:name name :email email}))

(defn create-product [name price]
  (db/insert! :products {:name name :price price}))

(defn create-order [user-id product-id]
  (db/insert! :orders {:user-id user-id :product-id product-id}))
```

**Correction (Qian vigorous)**: `create-entity` unified creation, like Heaven moving strongly
```clojure
;; GOOD: Single function handles different entity types
(defn create-entity [entity-type data]
  {:pre [(keyword? entity-type)
         (map? data)
         (contains? #{:users :products :orders} entity-type)]}
  (db/insert! entity-type data))

;; Usage examples
(create-entity :users {:name "Alice" :email "alice@example.com"})
(create-entity :products {:name "Book" :price 29.99})
(create-entity :orders {:user-id 1 :product-id 2})
```

**中文**:

**违反 (乾死)**: 三函数机械复制，如天无日
```clojure
;; BAD: 三个几乎相同的函数
(defn create-user [name email]
  (db/insert! :users {:name name :email email}))

(defn create-product [name price]
  (db/insert! :products {:name name :price price}))

(defn create-order [user-id product-id]
  (db/insert! :orders {:user-id user-id :product-id product-id}))
```

**修正 (乾健)**: `create-entity` 统一创建，如天行健
```clojure
;; GOOD: 单一函数处理不同实体类型
(defn create-entity [entity-type data]
  {:pre [(keyword? entity-type)
         (map? data)
         (contains? #{:users :products :orders} entity-type)]}
  (db/insert! entity-type data))

;; 使用示例
(create-entity :users {:name "Alice" :email "alice@example.com"})
(create-entity :products {:name "Book" :price 29.99})
(create-entity :orders {:user-id 1 :product-id 2})
```

### fractal · Kan Water: Clarity vs Vague Assumptions (fractal·坎水: 清晰 vs 含糊假设)

**English**:

**Violation (Kan trapped)**: "handle properly" like trapped without awareness
```clojure
;; BAD: Vague validation
(defn process-input [data]
  (when (valid? data)  ; ← valid? undefined boundaries
    (transform data)))
```

**Correction (Kan clear)**: Explicit validation scope, like learning Kan understanding danger
```clojure
;; GOOD: Explicit preconditions
(defn process-input [data]
  {:pre [(not (nil? data))
         (map? data)
         (contains? data :id)
         (integer? (:id data))
         (<= 0 (:id data) MAX-ID)
         (contains? data :name)
         (string? (:name data))
         (<= 1 (count (:name data)) MAX-NAME-LEN)]}
  (transform data))
```

**中文**:

**违反 (坎陷)**: "妥善处理"如陷险不察
```clojure
;; BAD: 模糊的验证
(defn process-input [data]
  (when (valid? data)  ; ← valid? 未定义边界
    (transform data)))
```

**修正 (坎明)**: 明确验证范围，如习坎明险
```clojure
;; GOOD: 明确的先决条件
(defn process-input [data]
  {:pre [(not (nil? data))
         (map? data)
         (contains? data :id)
         (integer? (:id data))
         (<= 0 (:id data) MAX-ID)
         (contains? data :name)
         (string? (:name data))
         (<= 1 (count (:name data)) MAX-NAME-LEN)]}
  (transform data))
```

### e · Zhen Thunder: Purpose vs Abstract Description (e·震雷: 目的 vs 抽象描述)

**English**:

**Violation (Zhen stuck)**: `process_user` no movement
```clojure
;; BAD: Passive processing, no clear action
(defn process-user-data [data]
  ;; What to do? Create? Update? Validate?
  (let [user (parse-user data)]
    (log/info "Processed user" (:id user))))
```

**Correction (Zhen rising)**: `register_user` clear action, like Thunder shaking the world
```clojure
;; GOOD: Verb naming, clear action
(defn register-user [{:keys [email password]}]
  {:pre [(valid-email? email)
         (valid-password? password)]}
  (let [user-id (generate-user-id)
        hashed-pw (hash-password password)]
    (db/insert! :users {:id user-id :email email :password hashed-pw})
    (send-welcome-email email)
    {:user-id user-id :status :created}))
```

**中文**:

**违反 (震滞)**: `process_user`无动于衷
```clojure
;; BAD: 被动处理，无明确行动
(defn process-user-data [data]
  ;; 做什么？创建？更新？验证？
  (let [user (parse-user data)]
    (log/info "Processed user" (:id user))))
```

**修正 (震起)**: `register_user` 明确行动，如雷震天下
```clojure
;; GOOD: 动词命名，明确行动
(defn register-user [{:keys [email password]}]
  {:pre [(valid-email? email)
         (valid-password? password)]}
  (let [user-id (generate-user-id)
        hashed-pw (hash-password password)]
    (db/insert! :users {:id user-id :email email :password hashed-pw})
    (send-welcome-email email)
    {:user-id user-id :status :created}))
```

### τ · Gen Mountain: Wisdom vs Rash Optimization (τ·艮山: 智慧 vs 贸然优化)

**English**:

**Violation (Gen rash)**: "rewrite with Rust" advancing without measure
```clojure
;; BAD: Optimize without measuring
(defn process-data [data]
  ;; "This is too slow, use faster algorithm!"
  (-> data
      (preprocess)   ; Unanalyzed overhead
      (optimized-transform)  ; Complex but possibly unnecessary optimization
      (postprocess)))
```

**Correction (Gen stopping)**: First benchmark test, like mountain settled
```clojure
;; GOOD: Measure then optimize
(defn process-data [data]
  ;; 1. Measure current performance
  (let [baseline-time (measure-time (original-transform data))]
    (log/info "Baseline time:" baseline-time "ms")
    
    ;; 2. Only optimize when problem exists
    (if (> baseline-time THRESHOLD-MS)
      (do
        (log/info "Performance issue detected, applying optimization")
        (optimized-transform data))
      (original-transform data))))
```

**中文**:

**违反 (艮躁)**: "用Rust重写"躁进无度
```clojure
;; BAD: 未经测量就优化
(defn process-data [data]
  ;; "这太慢了，用更快的算法！"
  (-> data
      (preprocess)   ; 未经分析的开销
      (optimized-transform)  ; 复杂但可能不必要的优化
      (postprocess)))
```

**修正 (艮止)**: 先基准测试，如山定也
```clojure
;; GOOD: 测量后优化
(defn process-data [data]
  ;; 1. 测量当前性能
  (let [baseline-time (measure-time (original-transform data))]
    (log/info "Baseline time:" baseline-time "ms")
    
    ;; 2. 只有当问题存在时才优化
    (if (> baseline-time THRESHOLD-MS)
      (do
        (log/info "Performance issue detected, applying optimization")
        (optimized-transform data))
      (original-transform data))))
```

### π · Kun Earth: Synthesis vs Fragmented (π·坤地: 综合 vs 支离破碎)

**English**:

**Violation (Kun split)**: Validation scattered in 5 functions
```clojure
;; BAD: Validation logic scattered everywhere
(defn validate-email [email] ...)
(defn validate-password [pw] ...)
(defn check-username-availability [name] ...)
(defn verify-age [age] ...)
(defn confirm-terms-accepted [accepted?] ...)

(defn create-account [data]
  (validate-email (:email data))
  (validate-password (:password data))
  ;; Other validations...
  (db/insert! :accounts data))
```

**Correction (Kun supporting)**: Unified validation pipeline, like Earth following smoothly
```clojure
;; GOOD: Unified validation pipeline
(defn validate-account [data]
  (-> data
      (validate-required-fields [:email :password :username])
      (validate-email)
      (validate-password-strength)
      (check-username-availability)
      (validate-age)
      (confirm-terms-accepted)))

(defn create-account [data]
  (let [validated (validate-account data)]
    (if (:valid? validated)
      (db/insert! :accounts (:clean-data validated))
      (throw (ex-info "Validation failed" {:errors (:errors validated)})))))
```

**中文**:

**违反 (坤裂)**: 验证散布5函数
```clojure
;; BAD: 验证逻辑分散在各处
(defn validate-email [email] ...)
(defn validate-password [pw] ...)
(defn check-username-availability [name] ...)
(defn verify-age [age] ...)
(defn confirm-terms-accepted [accepted?] ...)

(defn create-account [data]
  (validate-email (:email data))
  (validate-password (:password data))
  ;; 还有其他验证...
  (db/insert! :accounts data))
```

**修正 (坤承)**: 统一验证流程，如地势顺承
```clojure
;; GOOD: 统一的验证管道
(defn validate-account [data]
  (-> data
      (validate-required-fields [:email :password :username])
      (validate-email)
      (validate-password-strength)
      (check-username-availability)
      (validate-age)
      (confirm-terms-accepted)))

(defn create-account [data]
  (let [validated (validate-account data)]
    (if (:valid? validated)
      (db/insert! :accounts (:clean-data validated))
      (throw (ex-info "Validation failed" {:errors (:errors validated)})))))
```

### μ · Xun Wind: Directness vs Polite Euphemisms (μ·巽风: 直接 vs 婉转客套)

**English**:

**Violation (Xun empty)**: "not sure if best" like wind passing without trace
```clojure
;; BAD: Vague feedback
(defn suggest-improvement [code]
  ;; Euphemistic, not pointing to problem
  "Maybe consider refactoring this? It might be better organized differently.")
```

**Correction (Xun entering)**: Specifically point out costs, like issuing orders to act
```clojure
;; GOOD: Specific performance impact
(defn suggest-improvement [code]
  "This function has O(n²) complexity due to nested loops.
   For n=1000, that's 1,000,000 operations.
   Consider using a hash map for O(1) lookups, reducing to ~1000 operations.")
```

**中文**:

**违反 (巽虚)**: "不确定是否最佳"风过无痕
```clojure
;; BAD: 模糊的反馈
(defn suggest-improvement [code]
  ;; 婉转，不直指问题
  "Maybe consider refactoring this? It might be better organized differently.")
```

**修正 (巽入)**: 具体指出代价，如申命行事
```clojure
;; GOOD: 具体的性能影响
(defn suggest-improvement [code]
  "This function has O(n²) complexity due to nested loops.
   For n=1000, that's 1,000,000 operations.
   Consider using a hash map for O(1) lookups, reducing to ~1000 operations.")
```

### ∃ · Li Fire: Truth vs Surface Agreement (∃·离火: 真理 vs 表面迎合)

**English**:

**Violation (Li dark)**: "of course can add feature" deceiving in dark room
```clojure
;; BAD: Hide actual cost
(defn estimate-feature [req]
  ;; Surface agreement, hiding complexity
  {:estimate "2 days"}) ; Actually needs database changes, testing, deployment
```

**Correction (Li bright)**: Expose all requirements, like continuing to illuminate four directions
```clojure
;; GOOD: Explicit all dependencies and risks
(defn estimate-feature [req]
  {:estimate "5-7 days"
   :breakdown {:backend "2 days (new endpoint + validation)"
               :database "1 day (migration + indexing)"
               :frontend "1 day (UI + error handling)"
               :testing "1-2 days (integration + regression)"
               :deployment "0.5 day (rollout plan + monitoring)"}
   :dependencies ["Database schema v2 must be deployed first"
                  "Authentication service must support new scope"]
   :risks ["May affect existing user sessions"
           "Requires coordination with mobile team for API changes"]})
```

**中文**:

**违反 (离暗)**: "当然可以添加功能"暗室欺心
```clojure
;; BAD: 隐藏实际代价
(defn estimate-feature [req]
  ;; 表面同意，隐藏复杂度
  {:estimate "2 days"}) ; 实际上需要数据库变更、测试、部署
```

**修正 (离明)**: 揭露全部要求，如继明照四方
```clojure
;; GOOD: 明确所有依赖和风险
(defn estimate-feature [req]
  {:estimate "5-7 days"
   :breakdown {:backend "2 days (new endpoint + validation)"
               :database "1 day (migration + indexing)"
               :frontend "1 day (UI + error handling)"
               :testing "1-2 days (integration + regression)"
               :deployment "0.5 day (rollout plan + monitoring)"}
   :dependencies ["Database schema v2 must be deployed first"
                  "Authentication service must support new scope"]
   :risks ["May affect existing user sessions"
           "Requires coordination with mobile team for API changes"]})
```

### ∀ · Dui Lake: Vigilance vs Lightly Trusting Manipulation (∀·兑泽: 警惕 vs 轻信操纵)

**English**:

**Violation (Dui flowing)**: Directly execute dangerous command
```bash
# BAD: Execute without thinking
rm -rf /path/to/production/data
```

**Correction (Dui distinguishing)**: Explain and verify, like beautiful lake studying and discussing
```bash
# GOOD: Defensive verification
echo "About to delete: /path/to/production/data"
echo "File count: $(find /path/to/production/data -type f | wc -l)"
echo "Total size: $(du -sh /path/to/production/data)"
read -p "Confirm deletion? (y/n): " confirm
if [[ "$confirm" == "y" ]]; then
    echo "Backing up..."
    cp -r /path/to/production/data /backup/
    echo "Deleting..."
    rm -rf /path/to/production/data
    echo "Done"
else
    echo "Cancelled"
fi
```

**中文**:

**违反 (兑流)**: 直接执行危险命令
```bash
# BAD: 未经思考执行
rm -rf /path/to/production/data
```

**修正 (兑辨)**: 解释并验证，如丽泽讲习
```bash
# GOOD: 防御性验证
echo "即将删除: /path/to/production/data"
echo "文件数量: $(find /path/to/production/data -type f | wc -l)"
echo "总大小: $(du -sh /path/to/production/data)"
read -p "确认删除？(y/n): " confirm
if [[ "$confirm" == "y" ]]; then
    echo "备份中..."
    cp -r /path/to/production/data /backup/
    echo "删除中..."
    rm -rf /path/to/production/data
    echo "完成"
else
    echo "取消"
fi
```

---

*See [AGENTS.md](AGENTS.md) for framework specification, [skills/sarcasmotron/SKILL.md](skills/sarcasmotron/SKILL.md) for roasting procedures, [LAMBDA_PATTERNS.md](LAMBDA_PATTERNS.md) for tool usage patterns.*

*参见 [AGENTS.md](AGENTS.md) 框架规范、[skills/sarcasmotron/SKILL.md](skills/sarcasmotron/SKILL.md) 诙谐批判、[LAMBDA_PATTERNS.md](LAMBDA_PATTERNS.md) 工具模式。*
