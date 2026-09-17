"""LeetCode 198. House Robber
https://leetcode.cn/problems/house-robber/
"""

from typing import List


class Solution:
    def rob(self, nums: List[int]) -> int:
        pass

if __name__ == "__main__":
    solution = Solution()
    assert solution.rob([1, 2, 3, 1]) == 4
    assert solution.rob([2, 7, 9, 3, 1]) == 12
    print("All tests passed.")
