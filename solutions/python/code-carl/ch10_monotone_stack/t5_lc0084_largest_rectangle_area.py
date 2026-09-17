"""LeetCode 84. Largest Rectangle in Histogram
https://leetcode.cn/problems/largest-rectangle-in-histogram/
"""

from typing import List


class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        heights.insert(0, 0)
        heights.append(0)
        stack: List[int] = []
        ans = 0

        for i, curr_h in enumerate(heights):
            while stack and curr_h < heights[stack[-1]]:
                h = heights[stack.pop()]
                w = i - stack[-1] - 1
                ans = max(ans, w * h)
            stack.append(i)

        return ans


if __name__ == "__main__":
    solution = Solution()
    assert solution.largestRectangleArea([2, 1, 5, 6, 2, 3]) == 10
    print("All tests passed.")
