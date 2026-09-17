# Algorithm Practice

Java 与 Python 的 LeetCode 刷题仓库，保留代码随想录的教程顺序，同时使用 LeetCode 题号建立稳定索引。

## 目录

- `solutions/code-carl/`：代码随想录当前答案，按 `chXX/tN` 教程顺序组织。
- `solutions/hot-100/`：现有 Java Hot 100 答案。
- `templates/java/`：Java 练习骨架，分为代码随想录与 Hot 100。
- `templates/python/`：Python 练习骨架，分为代码随想录与 Hot 100。
- `archive/`：按每轮开始日期保存历史作答，不区分语言顶层目录。
- `notes/`：Python 转换笔记和保留下来的零散记录。

## 命名

单题文件保留教程序号并补充 LeetCode 题号，例如：

```text
t3_lc0027_remove_element.py
T3_LC0027_RemoveElement.java
```

同一教程序号包含多道题时，不增加额外小序号，由 LeetCode 题号和题名区分。章节 README 按教程原顺序提供 `leetcode.cn` 中文站链接。

## 使用方式

模板是独立的 LeetCode 风格代码片段，不使用 Maven 工程。开始一轮练习时，可以直接从 `templates/java/` 或 `templates/python/` 选择对应题单。Python 模板通过 `pass` 标记待实现方法；Java 模板通过 `UnsupportedOperationException("TODO")` 标记待实现返回值。完成练习后将结果放入对应的 `solutions/` 目录，历史轮次保留在 `archive/`。

## 历史

本仓库仅保留合并整理后的当前历史，不继承原 Java、Python 仓库的提交记录。归档日期中一部分是根据原目录季节名称和源码日期推定的近似值，详细映射见 [`archive/README.md`](archive/README.md)。
