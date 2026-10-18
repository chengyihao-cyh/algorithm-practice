"""LeetCode 84. Largest Rectangle in Histogram
https://leetcode.cn/problems/largest-rectangle-in-histogram/
"""

from typing import List


class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        heights.insert(0, 0)
        heights.append(0)

        stack: List[int] = []
        ans: int = 0
        for i, h in enumerate(heights):
            while stack and h < heights[stack[-1]]:
                mid_h = heights[stack.pop()]
                ans = max(ans, mid_h * (i - stack[-1] - 1))
            stack.append(i)

        return ans


if __name__ == "__main__":
    solution = Solution()
    assert solution.largestRectangleArea([2, 1, 5, 6, 2, 3]) == 10
    assert solution.largestRectangleArea([2, 4]) == 4
    print("All tests passed.")
