"""LeetCode 42. Trapping Rain Water
https://leetcode.cn/problems/trapping-rain-water/
"""

from typing import List


class Solution:
    def trap(self, height: List[int]) -> int:
        stack: List[int] = []
        ans: int = 0

        for i, right_h in enumerate(height):
            while stack and right_h > height[stack[-1]]:
                mid_h = height[stack.pop()]
                if stack:
                    h = min(right_h, height[stack[-1]]) - mid_h
                    w = i - stack[-1] - 1
                    ans += h * w
            stack.append(i)

        return ans


if __name__ == "__main__":
    solution = Solution()
    assert solution.trap([0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]) == 6
    assert solution.trap([4, 2, 0, 3, 2, 5]) == 9
    print("All tests passed.")
