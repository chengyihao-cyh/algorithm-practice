"""LeetCode 42. Trapping Rain Water
https://leetcode.cn/problems/trapping-rain-water/
"""

from typing import List


class Solution:
    def trap(self, height: List[int]) -> int:
        pass

if __name__ == "__main__":
    solution = Solution()
    assert solution.trap([0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]) == 6
    assert solution.trap([4, 2, 0, 3, 2, 5]) == 9
    print("All tests passed.")
