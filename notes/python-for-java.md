# Java 程序员的 Python 刷题速查

这篇只记录做算法题时常用、并且容易受 Java 习惯影响的 Python 知识。完整语言教程
不在范围内。

## 基础写法

| 目的 | Python | Java 中的近似写法 |
|---|---|---|
| 整除 | `5 // 2` | `5 / 2`（两个操作数都是整数） |
| 取模 | `5 % 2` | `5 % 2` |
| 空值 | `None` | `null` |
| 逻辑运算 | `and`、`or`、`not` | `&&`、`||`、`!` |
| 极值哨兵 | `float("inf")`、`float("-inf")` | `Integer.MAX_VALUE` 等 |
| 交换 | `a, b = b, a` | 临时变量 |
| 命名 | `snake_case` | 常见为 `camelCase` |

Python 的整数没有 Java `int`/`long` 那样的固定范围。只需要一个“大于所有候选值”
的哨兵时，`float("inf")` 通常比 `sys.maxsize` 更能表达意图。

### 相等、身份与真假值

- `a == b` 比较值，接近 Java 的 `equals`。
- `a is b` 比较是否为同一个对象，刷题时主要写 `value is None`。
- 不要用 `is` 比较整数或字符串的值。
- 空字符串、空容器、数字 `0` 和 `None` 都是假值，可以直接写 `if not values:`。
- `x in mapping` 查询的是字典的键；`x in set` 和 `x in dict` 平均 O(1)，
  `x in list` 是 O(n)。

```python
if node is None:
    return

if not nums:
    return []

if target in index_by_value:
    ...
```

## 字符串与切片

字符串不可变，但支持下标和切片：

```python
s = "hello"
s[0]       # "h"，类似 charAt(0)
s[-1]      # "o"，最后一个字符
s[1:3]     # "el"，左闭右开
s[::-1]    # "olleh"
s[100:110] # ""，切片越界不会报错
```

需要修改字符时先转成列表，最后再拼接：

```python
chars = list("abc")
chars[0] = "x"
result = "".join(chars)  # "xbc"
```

处理不定数量的空白时使用无参数的 `split()`：

```python
"  a   b  ".split()      # ["a", "b"]
"  a   b  ".split(" ")  # ["", "", "a", "", "", "b", "", ""]
```

字符和数字互转：

```python
ord("A")                 # 65
chr(65)                  # "A"
int("3")                 # 3
str(3)                   # "3"
ord("c") - ord("a")     # 2，字母映射到下标
```

## List

```python
nums = [1, 2, 3]
counts = [0] * 26  # 类似 Java 的 new int[26]
doubled = [x * 2 for x in range(5)]

nums.append(4)
last = nums.pop()
copy_of_nums = nums.copy()  # 浅拷贝
```

Python 算法题通常用 `list` 兼任 Java 数组和 `ArrayList`；`[0] * 26` 会预先创建
26 个位置，但 `list` 仍可用 `append()` 改变长度。

创建二维列表时，每一行必须是独立对象：

```python
wrong = [[0] * 3] * 2             # 两行指向同一个列表
matrix = [[0] * 3 for _ in range(2)]
```

`list.copy()`、`list[:]` 都是浅拷贝；只有确实需要复制嵌套可变对象时才使用
`copy.deepcopy()`。

### 修改对象与重新绑定变量

Python 传递的是对象引用。函数内修改可变对象会影响调用方，但给参数名重新赋值不会：

```python
def mutate(values: list[int]) -> None:
    values.append(1)  # 调用方能看到

def rebind(values: list[int]) -> None:
    values = [1]      # 只改变当前函数中的名称
```

不要使用可变对象作为默认参数，因为它会在多次调用之间复用：

```python
def collect(value: int, result: list[int] | None = None) -> list[int]:
    if result is None:
        result = []
    result.append(value)
    return result
```

## Dict、defaultdict 与 Counter

```python
from collections import Counter, defaultdict

index_by_value: dict[int, int] = {}
index_by_value[10] = 0
index_by_value.get(20, -1)  # -1

groups: defaultdict[str, list[int]] = defaultdict(list)
groups["odd"].append(1)

freq = Counter("abracadabra")
freq["a"]                  # 5
freq.most_common(2)        # [("a", 5), ("b", 2)]
Counter("abc") <= Counter("abcabc")  # 每个字符的数量是否都不超过右侧
```

`defaultdict(list)` 把 `list` 作为默认工厂；访问缺失键时会调用 `list()` 创建并保存
一个新的空列表。因此 `groups["odd"].append(1)` 近似等价于：

```python
if "odd" not in groups:
    groups["odd"] = []
groups["odd"].append(1)
```

遍历字典时按所需内容选择：

```python
for key in index_by_value:
    ...
for value in index_by_value.values():
    ...
for key, value in index_by_value.items():
    ...
```

`defaultdict` 会在读取缺失键时创建默认值。若不希望读操作改变字典，应使用普通
`dict.get()`。

## Set

```python
a = {1, 2, 3}
b = {2, 3, 4}
empty = set()  # {} 是空 dict

a & b  # 交集 {2, 3}
a | b  # 并集 {1, 2, 3, 4}
a - b  # 差集 {1}
a ^ b  # 对称差集 {1, 4}
a <= b # a 是否为 b 的子集

a.discard(99)  # 元素不存在也不报错
a.remove(99)   # 元素不存在时抛出 KeyError
```

`discard()` 和 `remove()` 都会删除指定元素；不确定元素是否存在时使用 `discard()`。

## 栈、队列与堆

栈直接用 `list`：

```python
stack: list[int] = []
stack.append(1)
top = stack.pop()
```

队列使用 `deque`，不要使用复杂度为 O(n) 的 `list.pop(0)`：

```python
from collections import deque

queue = deque([1, 2, 3])
queue.append(4)
front = queue.popleft()
```

`heapq` 不创建专用容器，而是原地把普通 `list` 维护成小顶堆：只保证父节点不大于
子节点，列表整体不一定有序。为兼容常见的 LeetCode Python 运行环境，可用相反数
模拟数值大顶堆：

```python
import heapq

min_heap: list[int] = []
heapq.heappush(min_heap, 3)
heapq.heappush(min_heap, 1)
smallest = min_heap[0]              # peek：读取堆顶但不删除，O(1)
smallest = heapq.heappop(min_heap)  # pop：读取并删除堆顶，O(log n)

max_heap: list[int] = []
heapq.heappush(max_heap, -3)
heapq.heappush(max_heap, -1)
largest = -max_heap[0]              # peek：3
largest = -heapq.heappop(max_heap)  # 3
```

除读取 `heap[0]` 外，不要直接修改底层列表，否则可能破坏堆序；已有列表可用
`heapq.heapify(values)` 原地建堆。

自定义对象不要直接入堆，优先包装成“排序键 + 唯一序号 + 对象”。唯一序号可以避免
排序键相同时继续比较不可比较的对象：

```python
from itertools import count

sequence = count()
heapq.heappush(heap, (priority, next(sequence), item))
```

## 遍历选择

| 场景 | 写法 |
|---|---|
| 只需要值 | `for value in values` |
| 同时需要下标和值 | `for i, value in enumerate(values)` |
| 同时遍历多个序列 | `for a, b in zip(xs, ys)` |
| 需要访问相邻下标 | `for i in range(1, len(values))` |
| 边界会在循环体内变化 | `while` |

`range(start, stop, step)` 遵循左闭右开 `[start, stop)`：`start` 是起点（默认 `0`），
`stop` 是不包含的终点，`step` 是每次变化量（默认 `1`，反向遍历时为负数）。

```python
range(n)               # 0, 1, ..., n - 1
range(0, n, 2)         # 0, 2, 4, ...
range(n - 1, -1, -1)  # n - 1, n - 2, ..., 0
```

`range(...)` 在进入循环前就确定范围。若右边界会在循环中扩张，例如跳跃游戏中的
`cover`，应使用 `while i <= cover`。

反过来，BFS 中的 `for _ in range(len(queue))` 正是利用了范围固定这一点：它只处理
进入当前层时已有的节点，新加入的节点留到下一层。

## 排序

`sorted(iterable)` 返回新列表，`list.sort()` 原地修改。两者都是稳定排序，优先使用
`key` 表达排序依据：

```python
nums = [3, 1, 4]
ascending = sorted(nums)
descending = sorted(nums, reverse=True)

pairs = [(1, 5), (2, 3), (1, 1)]
sorted(pairs, key=lambda pair: (pair[0], pair[1]))

# 第一项降序，第二项升序
people = [[7, 0], [4, 4], [7, 1]]
people.sort(key=lambda person: (-person[0], person[1]))
```

需要“数值升序、字符串降序”之类无法统一取负的混合规则时，可以利用稳定排序，先
排次要条件，再排主要条件。只有规则无法自然表示为 key 时，才考虑
`functools.cmp_to_key`。

## 常用标准库工具

二分定位使用 `bisect`，避免重复手写容易出错的边界：

```python
from bisect import bisect_left, bisect_right

nums = [1, 2, 2, 4]
bisect_left(nums, 2)   # 1，第一个 >= 2 的位置
bisect_right(nums, 2)  # 3，第一个 > 2 的位置
```

带余除法用 `divmod`，动态规划或搜索的记忆化可使用 `cache`：

```python
from functools import cache

carry, digit = divmod(total, 10)

@cache
def dfs(state: int) -> int:
    ...
```

其他常用内置函数包括 `sum`、`min`、`max`、`any`、`all` 和 `reversed`。优先用它们
表达意图，但不要为了缩短代码而把复杂状态更新塞进难读的一行表达式。

## 类型标注

当前 Python 可以优先使用内置泛型：

```python
def two_sum(nums: list[int], target: int) -> list[int]:
    index_by_value: dict[int, int] = {}
    ...
```

LeetCode 环境若版本较旧，可改用 `typing.List`、`typing.Dict`。可能为空的节点使用
`TreeNode | None`；旧版环境可使用 `Optional[TreeNode]`。

## 作用域与可变状态

嵌套函数读取外层变量不需要声明，但重新赋值需要 `nonlocal`：

```python
def count_nodes(root) -> int:
    count = 0

    def traverse(node) -> None:
        nonlocal count
        if node is None:
            return
        count += 1
        traverse(node.left)
        traverse(node.right)

    traverse(root)
    return count
```

`path.append(...)` 修改的是已有列表，不是给 `path` 重新赋值，所以不需要
`nonlocal path`。

刷题中的 `path`、`answer`、前驱值等可变状态优先放在方法局部。放在类属性或未正确
重置的实例属性上，会在同一对象的多次调用之间残留。

### 递归深度

Python 默认递归深度远小于 Java 常见题目能达到的节点数。链式树或深图可能触发
`RecursionError`。优先考虑显式栈的迭代写法；能确认内存风险和输入规模时，再谨慎
使用 `sys.setrecursionlimit(...)`。

## 常见操作复杂度

| 操作 | 平均复杂度 | 备注 |
|---|---:|---|
| `list.append()` / `list.pop()` | O(1) | 操作尾部 |
| `list.pop(0)` / `list.insert(0, x)` | O(n) | 会移动后续元素 |
| `deque.append()` / `deque.popleft()` | O(1) | 适合队列 |
| `x in list` | O(n) | 线性查找 |
| `x in set` / `x in dict` | O(1) | 平均情况 |
| `heapq.heappush()` / `heappop()` | O(log n) | 查看 `heap[0]` 为 O(1) |
| `sorted(values)` / `values.sort()` | O(n log n) | 稳定排序 |
| `values[a:b]` | O(k) | 会创建长度为 k 的新序列 |

切片会复制数据。在递归或循环里频繁切片可能把原本线性的算法变成 O(n²)，此时应传
下标边界。

## 高频避坑清单

- 空集合是 `set()`，不是 `{}`。
- 队列使用 `deque.popleft()`，不用 `list.pop(0)`。
- 二维列表使用推导式创建，避免多行引用同一对象。
- 值比较用 `==`，只在判断 `None` 等单例时使用 `is`。
- 不使用列表、字典或集合做函数默认参数。
- 大量字符串片段先收集到列表，最后用 `"".join(parts)`。
- 切片越界不会抛异常；单个下标越界会抛 `IndexError`。
- 注意切片会复制数据，不要在性能敏感的循环里滥用。
- 修改嵌套函数外层的标量变量时声明 `nonlocal`。
- 回溯状态尽量局部化，每次递归的 `append` 要与 `pop` 配对。
- 堆中元组的前几项相同后会继续比较下一项；对象不可比较时加入唯一序号。
