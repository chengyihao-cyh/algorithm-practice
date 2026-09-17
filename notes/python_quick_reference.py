"""
Python 刷题快速参考
===================
面向 Java 程序员的 Python 关键特性备忘录
"""

import copy
import heapq
import sys
from collections import Counter, defaultdict, deque
from itertools import count
from typing import Deque, Dict, List, Optional

# Mock 变量（仅供后续示例引用，避免 IDE 爆红）
row, col = 3, 4
nested = [[1], [2]]
s2 = {2, 3, 4}
nums = [10, 20, 30, 40, 50]
lst1, lst2 = [1, 2, 3], [4, 5, 6]
gas, cost = [1, 2, 3], [3, 4, 5]
arr = [1, 2, 2, 3, 3, 3]

class Person:
    def __init__(self, age: int, name: str):
        self.age = age
        self.name = name

person = Person(20, "a")
person_list = [Person(3, "c"), Person(1, "b"), Person(2, "a"), Person(1, "c")]


# =============================================================================
# 一、基础语法差异（Java vs Python）
# =============================================================================

# 1. 整数除法
#    Java: 5 / 2 = 2.5（浮点），Python: 5 // 2 = 2（整除）
a = 5 // 2   # 2
b = 5 % 2    # 1

# 2. 变量命名：snake_case（非 camelCase）
my_variable = 10   # 推荐
# myVariable = 10  # 不推荐

# 3. 字符串不可变（类似 Java 的 String，但无 charAt/substring）
s = "hello"
s[0]          # 'h'（等价 charAt）
s[-1]         # 'o'（负索引，Java 无此特性）
s[1:3]        # 'el'（切片，等价 substring）

# 4. 逻辑运算用 and/or/not（非 &&/||/!）
#    if a and b:   # 非 if (a && b):
#    if not x:     # 非 if (!x):

# 5. 布尔值是 True/False（非 true/false），None（非 null）


# =============================================================================
# 二、数据结构速查
# =============================================================================

# ┌──────────┬────────────────────┬───────────────────────────────────┐
# │ Python   │ Java 对应          │ 关键区别                           │
# ├──────────┼────────────────────┼───────────────────────────────────┤
# │ list     │ ArrayList          │ 支持[-1]负索引、[::]切片           │
# │ dict     │ HashMap            │ defaultdict 自动初始化             │
# │ set      │ HashSet            │ 支持 & | - ^ 集合运算             │
# │ deque    │ ArrayDeque         │ popleft() O(1)，list.pop(0) O(n)  │
# │ heapq    │ PriorityQueue      │ 只有小顶堆，大顶堆取负数            │
# └──────────┴────────────────────┴───────────────────────────────────┘

# -----------------------------------------------------------------------------
# 2.1 List（= Java ArrayList，Python 无固定长度数组）
# -----------------------------------------------------------------------------

# 创建
lst = [1, 2, 3]                         # 字面量
lst2 = list(range(5))                    # [0, 1, 2, 3, 4]
lst3 = [0] * 5                          # [0, 0, 0, 0, 0]
lst4 = [i * 2 for i in range(5)]         # [0, 2, 4, 6, 8]（列表推导式）

# 切片（Java 无此特性，等价 subList + 复制）
lst[0:3]      # [1, 2, 3]
lst[::-1]     # 倒序
lst[100:110]  # 越界不报错！返回 []（Java 会 IndexOutOfBounds）

# ⚠️ 二维创建陷阱：[[]] * 3 三行共享同一对象！
wrong = [[]] * 3;  wrong[0].append(1)  # 三行都被改了
right = [[] for _ in range(3)]          # 正确：每行独立
matrix = [[0] * col for _ in range(row)]  # m×n 全0矩阵

# 拷贝
l2 = lst.copy()          # 浅拷贝（推荐）
l3 = lst[:]              # 浅拷贝（常用写法）
deep = copy.deepcopy(nested)  # 深拷贝（嵌套结构必须用）

# -----------------------------------------------------------------------------
# 2.2 Dict（= Java HashMap）
# -----------------------------------------------------------------------------

d = {"a": 1, "b": 2}
d.get("c", 0)            # 安全获取，不存在返回默认值（Java: getOrDefault）

# defaultdict：key 不存在时自动创建，不需要 containsKey 判断
freq = defaultdict(int)  # 默认值 0
freq = defaultdict(list) # 默认值 []
freq["a"] += 1           # 直接用，无需 if "a" not in freq

# 遍历
for key in d: ...                # 遍历 key
for val in d.values(): ...       # 遍历 value
for key, val in d.items(): ...   # 遍历 key+value（Java: entrySet）

# -----------------------------------------------------------------------------
# 2.3 Set（= Java HashSet）
# -----------------------------------------------------------------------------

s1 = {1, 2, 3}             # 直接创建
s3 = set()                 # 空集合（{} 是空字典！）

# 集合运算（Java 需要 retainAll/addAll 等，Python 用运算符）
s1 & s2   # 交集
s1 | s2   # 并集
s1 - s2   # 差集
s1 ^ s2   # 对称差集

s1.discard(99)  # 删除，不存在不报错（remove 不存在会 KeyError）
{1, 2} <= {1, 2, 3}  # 子集判断（Java: isSubset 无直接方法）

# -----------------------------------------------------------------------------
# 2.4 栈 / 队列 / 堆
# -----------------------------------------------------------------------------

# 栈：直接用 list
stack = []
stack.append(1)     # push
top = stack.pop()   # pop

# 队列：用 deque（list.pop(0) 是 O(n)，deque.popleft() 是 O(1)）
q = deque([1, 2, 3])
q.append(4)         # 入队
front = q.popleft() # 出队
q[0]                # 队首
q[-1]               # 队尾

# 堆：heapq 只有小顶堆，大顶堆取负数
min_heap = []
heapq.heappush(min_heap, 3)    # 入堆
heapq.heappush(min_heap, 1)
min_heap[0]                     # 1，查看最小值（不弹出）
heapq.heappop(min_heap)         # 1，弹出最小值

# 大顶堆：入堆取负，出堆再取负
max_heap = []
heapq.heappush(max_heap, -3)
heapq.heappush(max_heap, -1)
heapq.heappop(max_heap)         # -1，弹出后取负得实际最大值 1

# heapreplace：先弹出堆顶，再 push 新值（比 heappop + heappush 高效，只需一次调整）
# heapq.heapreplace(heap, new_val)  → 返回旧的堆顶

# heappushpop：先 push 新值，再弹出堆顶（等价 push 后立刻 pop，但更高效）
# heapq.heappushpop(heap, new_val)  → 返回堆顶

# Top K 问题选型（刷题高频）
# ┌──────────┬──────────────────┬──────────────┬──────────────────────────┐
# │ 需求      │ 堆类型            │ 堆顶         │ 淘汰策略                  │
# ├──────────┼──────────────────┼──────────────┼──────────────────────────┤
# │ Top K 大  │ 小顶堆（正数）    │ K个中最小     │ 淘汰最小，留下大的         │
# │ Top K 小  │ 大顶堆（负数）    │ K个中最大     │ 淘汰最大，留下小的         │
# └──────────┴──────────────────┴──────────────┴──────────────────────────┘

# 自定义对象入堆（heapq 要求元素可比较，自定义类需处理，Person 类定义见顶部 mock 区）
# 方法：元组包装（刷题推荐，不改类定义，元组按位置逐位比较）
heap = []
heapq.heappush(heap, (person.age, person.name, person))  # age 升序 → 小顶堆效果
_, _, top = heapq.heappop(heap)            # 取出原始对象



# =============================================================================
# 三、类型转换速查（刷题高频）
# =============================================================================
#
#   int ──str()──→ str ──list()──→ list[str] ──join()──→ str ──int()──→ int
#   123            "123"           ['1','2','3']          "123"           123
#        ←─int()──       ←─join()─               ←─list()─       ←─str()──

# int ↔ str
s = str(123)       # "123"（Java: String.valueOf）
n = int("123")     # 123  （Java: Integer.parseInt）

# str ↔ list（Java: toCharArray / new String(char[])）
chars = list("abc")    # ['a', 'b', 'c']
s = ''.join(chars)     # "abc"

# ⚠️ str 不可变！不能 s[0] = 'x'，必须转 list 再操作
# chars = list(s); chars[0] = 'x'; s = ''.join(chars)

# 单个字符 ↔ 数字
ord('A')           # 65（Java: char → int 自动转）
chr(65)            # 'A'（Java: int → char 强转）

# 数字字符 ↔ 整数值（刷题高频：'3' ↔ 3）
val = ord('3') - ord('0')   # 3
ch = chr(3 + ord('0'))      # '3'

# 字母与下标互转
chr(ord('A') + 1)  # 'B'
ord('B') - ord('A')  # 1


# =============================================================================
# 四、遍历模式（Python 刷题最关键的知识点）
# =============================================================================
# Java 的 for(;;) 每轮重新判断终止条件，Python 的 for...in range() 在创建时固定范围
# 凡是终止条件依赖体内变量的，都必须用 while

# ┌──────────────────────┬──────────────────────────────────────────────┐
# │ 场景                  │ 推荐写法                                     │
# ├──────────────────────┼──────────────────────────────────────────────┤
# │ 只需值                │ for val in lst                               │
# │ 需要索引+值           │ for i, val in enumerate(lst)                 │
# │ 需要原始下标访问相邻   │ for i in range(...)                          │
# │ 同时遍历多个数组       │ for a, b in zip(lst1, lst2)                  │
# │ 索引+多数组           │ for i, (a, b) in enumerate(zip(lst1, lst2))  │
# │ 循环边界依赖体内变量   │ while（动态边界）                             │
# └──────────────────────┴──────────────────────────────────────────────┘

# 4.1 enumerate：需要索引时（替代 Java 的 for(i=0;i<n;i++)）
for i, val in enumerate([10, 20, 30]):
    pass  # i=0,1,2  val=10,20,30

# 4.2 zip：同时遍历多个数组
for a, b in zip(lst1, lst2):
    pass

# 索引+多数组组合：enumerate + zip
for i, (g, c) in enumerate(zip(gas, cost)):
    pass  # 解包为 (i, (x, y))

# 4.3 range：需要原始下标时（特别是访问相邻元素）
for i in range(1, len(nums)):      # 正向，从索引1开始
    pass
for i in range(len(nums) - 1, -1, -1):  # 逆序
    pass

# ⚠️ 陷阱：enumerate(arr[1:]) 的 i 从0开始，不是从1开始
# 需要原始下标 → 用 range；只关心值 → 用 enumerate+切片

# 4.4 while：动态边界（Python 刷题核心陷阱）
# Java: for (int i = 0; i <= cover; i++) — cover 在循环体内更新
# Python: range 在创建时就固定了，cover 更新不影响循环范围 → 必须用 while
# i = 0
# while i <= cover:
#     cover = max(cover, i + nums[i])
#     i += 1

# BFS 层序遍历：range(len(queue)) 在循环开始时确定本轮次数
# while queue:
#     for _ in range(len(queue)):      # 当前层节点数，循环体内 queue 变长不影响
#         node = queue.popleft()


# =============================================================================
# 五、排序（Python 排序 = TimSort 稳定排序）
# =============================================================================
# sorted() 返回新列表，list.sort() 就地修改
# 优先用 key，key 搞不定再用 cmp_to_key

# 默认排序
nums = [3, 1, 4, 1, 5]
sorted(nums)                  # [1, 1, 3, 4, 5]，返回新列表
nums.sort()                   # 就地修改
sorted(nums, reverse=True)    # 降序

# key 排序（等价 Java Comparator）
pairs = [(1, 5), (2, 3), (1, 1)]
sorted(pairs, key=lambda x: x[0])            # 按第一元素
sorted(pairs, key=lambda x: (x[0], x[1]))    # 多字段：先第一，再第二

# 升降序混合：降序字段用负号（仅数值型）
# Java: (a, b) -> b[0] - a[0] != 0 ? b[0] - a[0] : a[1] - b[1]
# Python: 身高降序 + k升序
people = [[7, 0], [4, 4], [7, 1], [5, 0]]
people.sort(key=lambda x: (-x[0], x[1]))

# 字典按 value 排序
d = {'b': 3, 'a': 1, 'c': 2}
sorted(d.items(), key=lambda x: x[1])   # [('a', 1), ('c', 2), ('b', 3)]

# 频率降序 + 值升序
freq_cnt = Counter([1, 2, 2, 3, 3, 3])
sorted(arr, key=lambda x: (-freq_cnt[x], x))

# --- 自定义对象排序（Person 类为例，类定义见顶部 mock 区）---
# Java: Arrays.sort(person_list, (a, b) -> a.age - b.age)
# Python: key 返回排序依据值，元组按位置依次比较

# ① 按 age 升序
sorted(person_list, key=lambda x: x.age)

# ② 按 age 升序，age 相同按 name 升序
sorted(person_list, key=lambda x: (x.age, x.name))

# ③ 按 age 升序，age 相同按 name 降序（字符串不能用负号！）
# 方法A：两次排序（利用稳定性，先排次要条件）
person_list.sort(key=lambda x: x.name, reverse=True)  # 先 name 降序
person_list.sort(key=lambda x: x.age)                  # 再 age 升序，相同 age 保留 name 降序

# 方法B：cmp_to_key（逻辑直观，适合比较复杂的场景）
# from functools import cmp_to_key
# def compare(a, b):
#     if a.age != b.age: return a.age - b.age   # age 升序
#     return -1 if a.name > b.name else 1 if a.name < b.name else 0  # name 降序
# person_list.sort(key=cmp_to_key(compare))


# =============================================================================
# 六、作用域与陷阱（Java 程序员最易踩的坑）
# =============================================================================

# 6.1 nonlocal：嵌套函数修改外部变量
# Java 可以直接在 lambda 修改外部变量（前提是 effectively final），
# Python 赋值会创建新的局部变量，必须用 nonlocal 声明

def example():
    count = 0
    def inner():
        nonlocal count   # 没有这行，count = 10 会创建新的局部变量
        count += 1
    inner()
    return count         # 1

# 6.2 类属性 vs 方法局部变量（LeetCode 最常见的 bug 来源！）
# 类属性在所有调用间共享，多次调用会残留数据

class BugDemo:
    path: List[int] = []        # ⚠️ 类属性，所有调用共享！
    ans: List[List[int]] = []   # 第二次调用还残留上次的结果

class GoodDemo:
    def combine(self, n, k):
        path: List[int] = []    # ✓ 方法局部变量，每次调用独立
        ans: List[List[int]] = []


# =============================================================================
# 七、常用工具
# =============================================================================

# Counter：频率统计（Java 无内置，需手写 Map）
cnt = Counter("abracadabra")     # Counter({'a': 5, 'b': 2, 'r': 2, ...})
cnt["a"]                         # 5
cnt.most_common(3)               # [('a', 5), ('b', 2), ('r', 2)]
Counter("abc") <= Counter("abcabc")  # True，c1 的频率都 ≤ c2

# 系统常量
sys.maxsize             # 极大正数（Java: Integer.MAX_VALUE）
-sys.maxsize - 1        # 极小负数（Java: Integer.MIN_VALUE）

# count()：无限计数器
c = count(1); next(c)  # 1; next(c)  # 2


# =============================================================================
# 八、常见避坑清单
# =============================================================================

# 1. split() 不带参数处理所有空白，split(" ") 只处理空格
#    "a  b".split()     → ['a', 'b']    ✓
#    "a  b".split(" ")  → ['a', '', 'b'] ✗

# 2. 切片越界不报错：lst[100:110] → []，不会 IndexError

# 3. 嵌套函数赋值创建新变量，必须 nonlocal

# 4. 类属性跨调用共享，可变状态放方法内部

# 5. 字符串拼接用 join() 而非 +（大量拼接时 O(n) vs O(n²)）

# 6. list.pop(0) 是 O(n)，队列用 deque.popleft()

# 7. {} 是空字典不是空集合，空集合用 set()
