"""LeetCode 1035. Uncrossed Lines
https://leetcode.cn/problems/uncrossed-lines/
"""

from typing import List


class Solution:
    def maxUncrossedLines(self, nums1: List[int], nums2: List[int]) -> int:
        pass

if __name__ == "__main__":
    solution = Solution()
    assert solution.maxUncrossedLines([1, 4, 2], [1, 2, 4]) == 2
    assert solution.maxUncrossedLines([2, 5, 1, 2, 5], [10, 5, 2, 1, 5, 2]) == 3
    assert solution.maxUncrossedLines([1, 3, 7, 1, 7, 5], [1, 9, 2, 5, 1]) == 2
    print("All tests passed.")
