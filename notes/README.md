# 刷题笔记

这里记录的是“如何用 Python 刷题”和“做题后学到了什么”。完整题解放在
[`solutions/python/`](../solutions/python/)，待练习的代码骨架放在
[`templates/python/`](../templates/python/)，避免同一道题在多个目录重复维护。

## 从哪里开始

| 需要 | 阅读 |
|---|---|
| 从 Java 切换到 Python，查询语法和标准库 | [`python-for-java.md`](python-for-java.md) |
| 复习常见算法写法与选择依据 | [`algorithm-patterns.md`](algorithm-patterns.md) |
| 回顾踩坑原因，或记录一道题的复盘 | [`practice-journal.md`](practice-journal.md) |

第一次阅读建议依次看完三篇；刷题时则把这里当作索引，按标题搜索即可。

## 内容边界

- **语言知识**：记在 `python-for-java.md`，重点写 Java 与 Python 的差异。
- **算法模式**：记在 `algorithm-patterns.md`，只保留能迁移到多道题的思路。
- **个人复盘**：记在 `practice-journal.md`，记录错误原因和下次判断规则。
- **完整题解**：放进 `solutions/python/`，不再复制到笔记中。
- **待做模板**：放进 `templates/python/`，笔记只链接它。

## 为什么以 Markdown 为主

这类内容以解释、对照表、短代码片段和链接为主，Markdown 最容易检索，也最适合
Git diff。需要运行和验证的完整代码仍使用 `.py`，但放在 `solutions/` 或 `templates/`
的明确位置。

Jupyter Notebook 更适合需要逐步观察中间数据、画图或做复杂度实验的场景。普通
LeetCode 刷题笔记使用它会引入单元格执行顺序和较难审查的 JSON diff，因此当前
不采用；以后若确实需要实验，可单独增加 `experiments/` 目录。

## 以后怎样记

遇到新知识时，先判断它属于哪一类：

1. 只是某道题的完整实现：更新题解，不写进笔记。
2. 能复用到多道题的 Python 用法或算法模式：补到对应主题下。
3. 自己反复犯的错：在复盘表中增加一条“现象、原因、下次规则”。

短片段直接写进 Markdown；只有需要独立运行、断言验证或被多个题解导入时，才新建
`.py` 文件。

## 本地小实验

仓库根目录的 `playground/` 用于随手编写和运行 Python 小 Demo，整个目录已被
`.gitignore` 忽略，不会进入提交：

```bash
python playground/demo.py
```

这里适合验证切片、排序、容器 API 或一小段算法行为。确认有长期价值后，再把结论写入
笔记，或把完整实现移到 `solutions/python/`；临时打印、测试数据和失败尝试留在
`playground/` 即可。
