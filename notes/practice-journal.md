# 刷题复盘

这里记录的不是“答案是什么”，而是“当时怎么写、为什么会错、下次如何更快判断”。
顶部表格只用于快速定位问题，具体差异以表格后的代码对照为准。

## 快速索引

| 现象 | 原因 | 下次规则 |
|---|---|---|
| 循环中扩大了边界，但 `for` 没有继续执行 | `range` 在循环开始前已经确定 | 循环终点依赖循环体内状态时用 `while` |
| 嵌套 DFS 读取前驱值时报 `UnboundLocalError` | 函数内赋值让该名称变成局部变量 | 需要修改外层标量时声明 `nonlocal` |
| 第二次调用题解时答案带着上次结果 | 把可变状态放在类属性或未重置的实例属性 | `answer`、`path` 默认放在方法局部 |
| 回溯结果缺节点或路径互相污染 | `append` 与 `pop` 没有覆盖相同的控制流 | 每次选择都在同一递归层撤销，叶子分支也不例外 |
| 二维数组改一个位置，多行同时变化 | 使用 `[[...]] * rows` 复制了引用 | 二维可变结构使用嵌套列表推导式 |
| 队列题超时 | 使用了 O(n) 的 `list.pop(0)` | FIFO 队列使用 `collections.deque` |
| Top K 堆中混入了更差元素 | 堆满后无条件替换堆顶 | 只有候选优于堆顶时才 `heapreplace` |
| `heapq` 比较自定义对象时报错 | 元组排序键相同时继续比较了对象 | 加入 `itertools.count()` 生成的唯一序号 |
| 多空格字符串分割出空串 | 使用了 `split(" ")` | 普通单词分割优先使用无参数 `split()` |
| 修改副本时原嵌套列表也变化 | 只做了浅拷贝 | 先判断是否真的需要副本；嵌套可变对象才考虑深拷贝 |

## 代码对照

### 1. 动态循环边界：for 改为 while

问题写法：

```python
cover = 0

# range(cover + 1) 在进入循环时已经固定为 range(1)。
for i in range(cover + 1):
    cover = max(cover, i + nums[i])

return cover >= len(nums) - 1
```

推荐写法：

```python
i = 0
cover = 0

while i <= cover:
    cover = max(cover, i + nums[i])
    if cover >= len(nums) - 1:
        return True
    i += 1

return False
```

`range(...)` 只在进入循环时计算一次范围，而 `while` 每轮都会重新判断 `i <= cover`。
循环终点依赖循环体内状态时，优先想到 `while`。

### 2. 嵌套函数修改外层标量：声明 nonlocal

问题写法：

```python
previous = float("-inf")

def inorder(node) -> bool:
    if node is None:
        return True
    if not inorder(node.left):
        return False

    if node.val <= previous:  # UnboundLocalError
        return False
    previous = node.val

    return inorder(node.right)
```

推荐写法只需要明确声明作用域：

```diff
 previous = float("-inf")

 def inorder(node) -> bool:
+    nonlocal previous
     if node is None:
         return True
```

函数体中出现 `previous = ...` 后，Python 会把它认定为该函数的局部变量；前面的读取
于是变成“读取尚未赋值的局部变量”。如果只是 `path.append(...)`，修改的是已有列表，
没有重新绑定 `path`，所以不需要 `nonlocal path`。

### 3. 求解状态：从类属性移到方法局部

问题写法：

```python
class Solution:
    answer: list[str] = []
    path: list[str] = []

    def binary_tree_paths(self, root) -> list[str]:
        self.traverse(root)
        return self.answer
```

推荐写法：

```python
class Solution:
    def binary_tree_paths(self, root) -> list[str]:
        answer: list[str] = []
        path: list[str] = []

        def traverse(node) -> None:
            ...

        traverse(root)
        return answer
```

类属性会被所有实例和多次调用共享。即使改成只在 `__init__` 初始化的实例属性，同一
实例第二次调用时仍可能残留。只属于一次求解的状态默认放在公开方法内部。

### 4. 回溯状态：append 与 pop 覆盖同一层

问题写法：

```python
def traverse(node) -> None:
    if node.left is None and node.right is None:
        # 当前叶子还没有进入 path。
        answer.append("->".join(path))
        return

    path.append(str(node.val))
    if node.left is not None:
        traverse(node.left)
    if node.right is not None:
        traverse(node.right)
    path.pop()
```

推荐写法：

```python
def traverse(node) -> None:
    path.append(str(node.val))

    if node.left is None and node.right is None:
        answer.append("->".join(path))
    else:
        if node.left is not None:
            traverse(node.left)
        if node.right is not None:
            traverse(node.right)

    path.pop()
```

把 `append` 放在所有分支之前，把 `pop` 放在所有分支之后，每层递归就都遵守“做选择、
递归、撤销选择”。叶子节点不再维护一套特殊状态。

### 5. 二维列表：每一行都要单独创建

```diff
-matrix = [[0] * columns] * rows
+matrix = [[0] * columns for _ in range(rows)]
```

前者只是多次引用同一个内层列表：执行 `matrix[0][0] = 1` 后，每一行的第一个元素
都会变化。列表推导式会在每轮创建一个新列表。

### 6. 队列：使用 deque.popleft

```diff
-queue = [root]
+from collections import deque
+queue = deque([root])

 while queue:
-    node = queue.pop(0)  # O(n)，后续元素整体前移
+    node = queue.popleft()  # O(1)
```

`list` 适合作为栈，`deque` 适合作为队列。API 看起来相近，但删除头部元素的复杂度
不同。

### 7. Top K：候选更好时才替换堆顶

问题写法会让更差的候选也挤掉当前答案：

```python
if len(heap) < k:
    heapq.heappush(heap, (frequency, value))
else:
    heapq.heapreplace(heap, (frequency, value))
```

推荐写法：

```python
item = (frequency, value)
if len(heap) < k:
    heapq.heappush(heap, item)
elif frequency > heap[0][0]:
    heapq.heapreplace(heap, item)
```

求 Top K 大时维护大小为 K 的小顶堆。堆顶是当前入选元素中最差的一个，只有更好的
候选才能替换它。

### 8. 自定义对象入堆：为相同排序键增加序号

问题写法：

```python
heapq.heappush(heap, (person.age, person))
```

当两个 `age` 相等时，元组会继续比较 `person`。如果 `Person` 没有定义大小比较，
这里会抛出 `TypeError`。

推荐写法：

```python
from itertools import count

sequence = count()
heapq.heappush(heap, (person.age, next(sequence), person))
```

唯一序号会在原始对象之前打破平局。如果对象本身有明确的第二排序字段，也可以使用该
字段代替序号。

### 9. 字符串分割：无参数 split 处理连续空白

```python
text = "  hello   python  "

text.split(" ")
# ["", "", "hello", "", "", "python", "", ""]

text.split()
# ["hello", "python"]
```

无参数 `split()` 会处理连续空格、制表符和换行，并忽略首尾空白。只有分隔符本身有
业务含义时才显式传参，例如 `split(",")`。

### 10. 嵌套列表：浅拷贝仍然共享内层对象

问题写法：

```python
matrix = [[1], [2]]
copied = matrix.copy()
copied[0].append(9)

print(matrix)
# [[1, 9], [2]]
```

已知只有两层列表时，可以明确地逐行复制：

```python
matrix = [[1], [2]]
copied = [row.copy() for row in matrix]
copied[0].append(9)

print(matrix)
# [[1], [2]]
```

结构层级不固定且确实需要完全独立时，再使用 `copy.deepcopy()`。先判断是否真的需要
复制；深拷贝不是所有嵌套结构的默认答案。

## 一道题怎样复盘

只有出现新判断、新错误或值得复用的写法时才记录。会做且没有新信息的题不必写笔记。

复制下面的小节并填写。代码只保留能复现差异的最小上下文：

````markdown
## YYYY-MM-DD · LC 题号 题名

- 题解：`../solutions/python/.../文件名.py`
- 首次判断：看到什么信号，选择了什么算法？
- 卡点或错误：具体表现是什么？

### 当时的写法

```python
# 能复现问题的最小片段
```

### 调整后的写法

```python
# 与上面保持相同上下文，突出真正的变化
```

- 根因：缺的是语言知识、算法不变量，还是边界意识？
- 下次规则：用一句可执行的话描述。
- 复杂度：时间 O(...)，空间 O(...)。
````

“下次规则”应能指导行动。例如不要只写“注意边界”，而要写“二分搜索开始前先定义
区间是 `[left, right]` 还是 `[left, right)`，循环条件与更新规则必须保持一致”。

## 定期整理方式

每积累约 10 条复盘时做一次归并：

1. 重复的错误合并成一条更准确的规则，但保留最有代表性的代码对照。
2. 已经熟练、没有再犯的基础语法从复盘移到语言速查，或直接删除。
3. 能覆盖多道题的思路提炼到算法模式，并链接一到两个代表题解。
4. 只属于单题实现细节的内容留在题解注释中，不扩散到通用笔记。
