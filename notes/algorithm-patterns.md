# Python 算法模式

这里不保存完整题解，只记录能迁移到多道题的判断方式和代码骨架。链接指向仓库中的
当前题解，细节以题解为准。

## 双指针：从两端决定答案

适用信号：数组有序，左右两端的值决定当前最大值或最小值。

有序数组平方后，两端绝对值之一一定最大，可以从答案末尾向前填充：

```python
left, right = 0, len(nums) - 1
write = len(nums) - 1
answer = [0] * len(nums)

while left <= right:
    if abs(nums[left]) > abs(nums[right]):
        answer[write] = nums[left] ** 2
        left += 1
    else:
        answer[write] = nums[right] ** 2
        right -= 1
    write -= 1
```

参考：[LC 977 有序数组的平方](../solutions/python/code-carl/ch01_array/t4_lc0977_sorted_squares.py)。

## 滑动窗口：右边扩张，左边收缩

适用信号：问题要求连续区间，并且加入右端元素后可以增量维护窗口状态。

最小覆盖类问题通常遵循这个骨架：

```python
left = 0
for right, value in enumerate(values):
    add(value)

    while window_is_valid():
        update_answer(left, right)
        remove(values[left])
        left += 1
```

关键不是背循环，而是先定义清楚：

- 窗口中维护什么状态；
- 何时称为有效窗口；
- 收缩后哪个条件表明窗口重新失效。

参考：[LC 76 最小覆盖子串](../solutions/python/code-carl/ch01_array/t7_lc0076_min_window.py)。

## 哈希表：记录“之前见过什么”

两数之和中，遍历当前值 `value` 时只需查询补数是否已经出现：

```python
index_by_value: dict[int, int] = {}

for index, value in enumerate(nums):
    complement = target - value
    if complement in index_by_value:
        return [index_by_value[complement], index]
    index_by_value[value] = index
```

先查询、后写入，可以自然避免同一个元素被使用两次。

当问题只关心频率时使用 `Counter`；缺失键需要自动初始化时使用 `defaultdict`；只关心
是否出现时使用 `set`。

参考：[LC 1 两数之和](../solutions/python/code-carl/ch03_hashtable/t5_lc0001_two_sum.py)、
[LC 454 四数相加 II](../solutions/python/code-carl/ch03_hashtable/t6_lc0454_four_sum_count.py)。

## 堆：只维护当前最优的 K 个元素

求 Top K 大时，维护大小不超过 K 的小顶堆。堆顶是当前入选元素中最小的，也是遇到
更优候选时应该被淘汰的元素。

```python
heap: list[tuple[int, int]] = []

for value, frequency in frequencies.items():
    item = (frequency, value)
    if len(heap) < k:
        heapq.heappush(heap, item)
    elif frequency > heap[0][0]:
        heapq.heapreplace(heap, item)
```

不要在堆满后无条件 `heapreplace`，否则较差的候选也会挤掉当前答案。这里仅比较频率，
因为题目不要求用数值打破频率相同的平局。

参考：[LC 347 前 K 个高频元素](../solutions/python/code-carl/ch05_stack/t7_lc0347_top_k_frequent.py)。

## BFS：按层固定本轮节点数

```python
queue = deque([root])
levels: list[list[int]] = []

while queue:
    level: list[int] = []
    for _ in range(len(queue)):
        node = queue.popleft()
        level.append(node.val)
        if node.left is not None:
            queue.append(node.left)
        if node.right is not None:
            queue.append(node.right)
    levels.append(level)
```

`range(len(queue))` 在本轮开始时固定，因此循环中加入的子节点不会混进当前层。

参考：[二叉树层序遍历模板](../templates/python/code-carl/ch06_tree/t5_level_order.py)。

## DFS 与回溯：状态局部化

回溯的基本纪律是做选择、递归、撤销选择：

```python
answer: list[str] = []
path: list[str] = []

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

`answer` 和 `path` 放在外层方法的局部作用域中：既能被嵌套函数使用，也不会污染下一
次方法调用。只有给外层标量重新赋值时才需要 `nonlocal`。

参考：[LC 257 二叉树的所有路径](../solutions/python/code-carl/ch06_tree/t12_lc0257_binary_tree_paths.py)、
[LC 501 二叉搜索树中的众数](../solutions/python/code-carl/ch06_tree/t23_lc0501_find_mode.py)。

## KMP：前缀表代表什么

`prefix[i]` 表示模式串 `pattern[:i + 1]` 的最长相等真前后缀长度。失配时跳到
`prefix[j - 1]`，而不是让主串指针后退：

```python
prefix = [0] * len(pattern)
j = 0

for i in range(1, len(pattern)):
    while j > 0 and pattern[i] != pattern[j]:
        j = prefix[j - 1]
    if pattern[i] == pattern[j]:
        j += 1
    prefix[i] = j
```

搜索阶段使用同一套失配回退规则。当 `j == len(pattern)` 时，匹配起点是
`i - j + 1`。

参考：[LC 28 找出字符串中第一个匹配项的下标](../solutions/python/code-carl/ch04_string/t4_lc0028_str_str.py)、
[LC 459 重复的子字符串](../solutions/python/code-carl/ch04_string/t5_lc0459_repeated_substring_pattern.py)。

## 模拟：先定义不变量

螺旋矩阵之类的模拟题，最容易错在四条边重复处理端点。先约定每条边使用左闭右开
区间，再让四个循环遵守同一规则，比逐个修补边界可靠。

参考：[LC 59 螺旋矩阵 II](../solutions/python/code-carl/ch01_array/t6_lc0059_generate_matrix.py)。

## 大整数逐位运算

Python 本身支持任意精度整数，但面试题可能要求模拟字符串加法。统一从低位向高位
处理，用 `divmod` 同时得到进位和当前位：

```python
def add_strings(left: str, right: str) -> str:
    i, j = len(left) - 1, len(right) - 1
    carry = 0
    digits: list[str] = []

    while i >= 0 or j >= 0 or carry:
        x = ord(left[i]) - ord("0") if i >= 0 else 0
        y = ord(right[j]) - ord("0") if j >= 0 else 0
        carry, digit = divmod(x + y + carry, 10)
        digits.append(str(digit))
        i -= 1
        j -= 1

    return "".join(reversed(digits))
```

这种写法不必先交换两个字符串，也不会遗漏最高位进位。
