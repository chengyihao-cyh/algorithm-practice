"""LeetCode 42. Trapping Rain Water
https://leetcode.cn/problems/trapping-rain-water/
"""

from typing import List


class Solution:
    def trap(self, height: List[int]) -> int:
        stack: List[int] = []
        ans = 0

        for i, curr_h in enumerate(height):
            while stack and curr_h > height[stack[-1]]:
                midIdx = stack.pop()
                if stack:
                    w = i - stack[-1] - 1
                    h = min(height[stack[-1]], curr_h) - height[midIdx]
                    ans += w * h
            if stack and height[stack[-1]] == curr_h:
                stack.pop()
            stack.append(i)
        return ans


if __name__ == "__main__":
    solution = Solution()

    assert solution.trap([0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]) == 6

    assert solution.trap([0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]) == 6

    print("All tests passed.")
