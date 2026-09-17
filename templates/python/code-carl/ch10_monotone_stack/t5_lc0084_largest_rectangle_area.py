"""LeetCode 84. Largest Rectangle in Histogram
https://leetcode.cn/problems/largest-rectangle-in-histogram/
"""

from typing import List


class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        pass

if __name__ == "__main__":
    solution = Solution()
    assert solution.largestRectangleArea([2, 1, 5, 6, 2, 3]) == 10
    assert solution.largestRectangleArea([2, 4]) == 4
    print("All tests passed.")
