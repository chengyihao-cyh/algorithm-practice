import heapq
import sys
from collections import defaultdict, deque
from itertools import count
from typing import List, Counter, Optional, Dict, Deque

from template.ch02_list.list_node import ListNode
from template.ch06_tree.tree_node import TreeNode


# abs
class Solution:
    def sortedSquares(self, nums: List[int]) -> List[int]:
        l, r, idx = 0, len(nums) - 1, len(nums) - 1
        res: List[int] = [0] * len(nums)
        while l <= r:
            if abs(nums[l]) > abs(nums[r]):
                res[idx] = pow(nums[l], 2)
                idx -= 1
                l += 1
            else:
                res[idx] = pow(nums[r], 2)
                idx -= 1
                r -= 1
        return res

    # // 才是整除
    # count()+next() 作为计数器 避免频繁 +=
    def generateMatrix(self, n: int) -> List[List[int]]:
        res: List[List[int]] = [[0] * n for _ in range(n)]
        cnt = count(1)
        for r in range(n // 2):
            for j in range(r, n - r - 1):
                res[r][j] = next(cnt)
            for i in range(r, n - r - 1):
                res[i][n - r - 1] = next(cnt)
            for j in range(n - r - 1, r, -1):
                res[n - r - 1][j] = next(cnt)
            for i in range(n - r - 1, r, - 1):
                res[i][r] = next(cnt)
        if n % 2 == 1:
            res[n // 2][n // 2] = next(cnt)
        return res

    # 最大值 sys.maxsize 最小值 -sys.maxsize - 1
    # Counter() 对可迭代对象做次数记录
    def minWindow(self, s: str, t: str) -> str:
        l, distance, = 0, len(t)
        minLen, resL, resR = sys.maxsize, -1, -1
        freq = Counter(t)

        for r, nextCh in enumerate(s):
            if nextCh in freq:
                freq[nextCh] -= 1
                if freq[nextCh] >= 0:
                    distance -= 1
                    while distance == 0:
                        if r - l + 1 < minLen:
                            minLen = r - l + 1
                            resL, resR = l, r
                        delCh = s[l]
                        l += 1
                        if delCh in freq:
                            freq[delCh] += 1
                            if freq[delCh] > 0:
                                distance += 1

        return "" if minLen == sys.maxsize else s[resL: resR + 1]

    # 交换很方便
    # 对于可能为空的对象用 Optional标注
    def getIntersectionNode(self, headA: Optional[ListNode], headB: Optional[ListNode]) -> Optional[ListNode]:
        ptrA, ptrB = headA, headB
        lenA, lenB = 0, 0
        while ptrA is not None:
            ptrA = ptrA.next
            lenA += 1
        while ptrB is not None:
            ptrB = ptrB.next
            lenB += 1

        ptrA, ptrB = headA, headB
        if lenB > lenA:
            lenA, lenB = lenB, lenA
            ptrA, ptrB = ptrB, ptrA

        for _ in range(lenA - lenB):
            ptrA = ptrA.next

        while ptrA is not None and ptrA != ptrB:
            ptrA = ptrA.next
            ptrB = ptrB.next
        return None if ptrA is None else ptrA

    # Counter 能作比较
    def canConstruct(self, ransomNote: str, magazine: str) -> bool:
        return Counter(ransomNote) <= Counter(magazine)

    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False
        return Counter(s) == Counter(t)

    # py 的 set 支持差、并、补、操作
    def intersection(self, nums1: List[int], nums2: List[int]) -> List[int]:
        st = set(nums1)
        ans = []
        for n in nums2:
            if n in st:
                st.remove(n)
                ans.append(n)
        return ans

    # 变量命名 _ 隔开
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        idx_map: Dict[int, int] = {}
        for idx, num in enumerate(nums):
            if target - num in idx_map:
                return [idx_map[target - num], idx]
            idx_map[num] = idx
        return []

    # defaultdict 相较于 {} 不会在 key 为空时抛异常而是会返回默认值 (int)则返回0
    def fourSumCount(self, nums1: List[int], nums2: List[int], nums3: List[int], nums4: List[int]) -> int:
        sum_freq_map = defaultdict(int)
        cnt = 0
        for n1 in nums1:
            for n2 in nums2:
                sum_freq_map[n1 + n2] += 1

        for n3 in nums3:
            for n4 in nums4:
                cnt += sum_freq_map[- n3 - n4]
        return cnt

    # 对切片元素倒序 [::-1]
    # 切片元素越界不会报错 [100:110] = ""
    def reverseStr(self, s: str, k: int) -> str:
        chars = list(s)
        for i in range(0, len(s), 2 * k):
            chars[i:i + k] = chars[i:i + k][::-1]
        return "".join(chars)

    # 分割使用 .split() 而不是 .split(" ")
    # 对切片元素倒序 [::-1]
    def reverseWords(self, s: str) -> str:
        ans = []
        for sp in s.strip().split():
            ans.append(sp)
        return " ".join(ans[::-1])

    # 先对列表倒序 再次 " ".join 使用空格拼接列表
    def reverseWords(self, s: str) -> str:
        return " ".join(s.strip().split()[::-1])

    # str 不用 charAt 直接下标取出
    def strStr(self, haystack: str, needle: str) -> int:
        next: List[int] = [0] * len(needle)

        j = 0
        for i in range(1, len(needle)):
            while j > 0 and needle[i] != needle[j]:
                j = next[j - 1]
            if needle[i] == needle[j]:
                j += 1
            next[i] = j

        j = 0
        for i in range(len(haystack)):
            while j > 0 and haystack[i] != needle[j]:
                j = next[j - 1]
            if haystack[i] == needle[j]:
                j += 1
                if j == len(needle):
                    return i - j + 1

        return -1

    # [-1] 可以取出最后一个元素
    def repeatedSubstringPattern(self, s: str) -> bool:
        next = [0] * len(s)

        j = 0
        for i in range(1, len(s)):
            while j > 0 and s[i] != s[j]:
                j = next[j - 1]
            if s[i] == s[j]:
                j += 1
            next[i] = j

        subLen = len(s) - next[-1]
        return subLen != len(s) and subLen != 0 and len(s) % subLen == 0

    # 栈
    def testStack(self):
        stack = []  # 创建栈
        stack.append(1)  # 入栈
        stack.append(2)
        top = stack.pop()  # 出栈 -> 2
        is_empty = len(stack) == 0

    def testDeque(self):
        q = deque()  # 创建队列
        q.append(1)  # 入队（队尾）
        q.append(2)
        front = q.popleft()  # 出队（队头）-> 1
        is_empty = len(q) == 0
        q = deque([1, 2, 3])

        front = q[0]  # peek front -> 1
        back = q[-1]  # peek back  -> 3

    def testHeap(self):
        min_heap = []  # 定义一个小顶堆（本质是 list）
        heapq.heappush(min_heap, 3)
        heapq.heappush(min_heap, 1)
        heapq.heappush(min_heap, 2)

        print(min_heap[0])

        max_heap = []
        heapq.heappush(max_heap, -3)
        heapq.heappush(max_heap, -1)
        heapq.heappush(max_heap, -2)

        top = -max_heap[0]

    # 学习 heapq 使用 不支持自定义排序器
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        cnt = Counter(nums)
        heap = []

        for num, freq in cnt.items():
            if len(heap) < k:
                heapq.heappush(heap, (freq, num))
            else:
                if freq > heap[0][0]:
                    heapq.heapreplace(heap, (freq, num))

        return [num for _, num in heap]

    # from typing import Deque 进行类型限定
    # deque([root]) 在构造函数塞入可迭代对象
    # for _ in range(len(queue)) 只在第一次敲定迭代次数 不会随queue改变而改变
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        ans: List[List[int]] = []
        if not root:
            return ans

        queue: Deque[TreeNode] = deque([root])

        while queue:
            level: List[int] = []
            for _ in range(len(queue)):
                curr = queue.popleft()
                level.append(curr.val)
                if curr.left:
                    queue.append(curr.left)
                if curr.right:
                    queue.append(curr.right)
            ans.append(level)

        return ans

    # 列表拷贝
    def testCopy(self):
        l1 = [1, 2, 3]

        l2 = l1.copy()  # 推荐，语义清晰
        # l2 = l1[:]     # 也常用
        # l2 = list(l1)  # 也可以

        # 如果是嵌套列表，比如[[1], [2]]，上面这些是浅拷贝，内层列表仍共享；要完全独立用深拷贝
        import copy
        l3 = [[1], [2]]
        l4 = copy.deepcopy(l3)


class SolutionForBadCase:
    # 这是不好的实现 把ans和path绑定为成员变量
    def __init__(self):
        self.ans: List[str] = []
        self.path: List[str] = []

    def binaryTreePathsBad(self, root: Optional[TreeNode]) -> List[str]:
        if not root:
            return self.ans
        self.traversalBad(root)
        return self.ans

    # 这是不好的实现 traversalBad函数只属于binaryTreePathsBad 不应该绑定在Solution下
    def traversalBad(self, root: Optional[TreeNode]) -> None:
        if not root.left and not root.right:
            self.ans.append("->".join(self.path))
            self.ans.append(f"->{root.val}")
            return

        self.path.append(str(root.val))
        if root.left:
            self.traversal(root.left)
        if root.right:
            self.traversal(root.right)
        self.path.pop()

    def binaryTreePaths(self, root: Optional[TreeNode]) -> List[str]:
        if not root:
            return []

        ans: List[str] = []
        path: List[str] = []

        # 这是好的实现 traversal只属于binaryTreePaths，并且ans和path不需要绑定到self
        def traversal(root: Optional[TreeNode]) -> None:
            if not root.left and not root.right:
                path.append(str(root.val))
                ans.append("->".join(path))
                path.pop()
                return

            path.append(str(root.val))

            if root.left:
                traversal(root.left)
            if root.right:
                traversal(root.right)
            # [] 删除元素不用remove用pop
            path.pop()

        traversal(root)
        return ans


    # test_list.append(1) 是修改外层列表对象的内容，没有给 test_list 重新赋值，所以 Python 会去外层作用域找到它并正常使用。
    # pre_num = root.val 是赋值语句。Python 一看到函数体里对 pre_num 有赋值，就把 pre_num 认定为 traversal 的局部变量。
    # 于是前面这句 if root.val <= pre_num: 读取到的是“尚未赋值的局部变量”，就会出错（典型是 UnboundLocalError）。
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        pre_num: int = - sys.maxsize - 1
        test_list = []

        def traversal(root: Optional[TreeNode]) -> bool:
            test_list.append(1)

            if not root:
                return True
            left = traversal(root.left)
            # if root.val <= pre_num:
            #     return False
            pre_num = root.val
            right = traversal(root.right)

        pass

    # 成员变量其实可以不定义在 __init__ 内，类java写法
    pre_num: int = - sys.maxsize - 1

    def isValidBST2(self, root: Optional[TreeNode]) -> bool:
        if not root:
            return True

        if not self.isValidBST2(root.left):
            return False

        if root.val <= self.pre_num:
            return False
        self.pre_num = root.val

        return self.isValidBST2(root.right)


    def findMode(self, root: Optional[TreeNode]) -> List[int]:
        if not root:
            return []
        ans: List[int] = []
        pre_num = - sys.maxsize - 1
        max_cnt = 1
        curr_cnt = 1

        def traversal(root: Optional[TreeNode]) -> None:
            # 子函数中通过 nonlocal 关键字引用到外部函数的局部变量
            nonlocal pre_num, max_cnt, curr_cnt

            if not root:
                return

            traversal(root.left)

            if pre_num == - sys.maxsize - 1 or pre_num != root.val:
                curr_cnt = 1
            else:
                curr_cnt += 1
            pre_num = root.val

            if curr_cnt == max_cnt:
                ans.append(root.val)
            elif curr_cnt > max_cnt:
                max_cnt = curr_cnt
                ans.clear()
                ans.append(root.val)

            traversal(root.right)

        traversal(root)
        return ans