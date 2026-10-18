"""LeetCode 496. Next Greater Element I
https://leetcode.cn/problems/next-greater-element-i/
"""

from typing import List, Dict


class Solution:
    def nextGreaterElement(self, nums1: List[int], nums2: List[int]) -> List[int]:
        dit: Dict[int, int] = {}
        for i, n in enumerate(nums1):
            dit[n] = i

        ans: List[int] = [-1] * len(nums1)
        stack: List[int] = []
        for i, n in enumerate(nums2):
            while stack and nums2[stack[-1]] < n:
                smaller = nums2[stack.pop()]
                if smaller in dit:
                    ans[dit[smaller]] = n
            stack.append(i)

        return ans


if __name__ == "__main__":
    solution = Solution()
    assert solution.nextGreaterElement([4, 1, 2], [1, 3, 4, 2]) == [-1, 3, -1]
    assert solution.nextGreaterElement([2, 4], [1, 2, 3, 4]) == [3, -1]
    print("All tests passed.")
