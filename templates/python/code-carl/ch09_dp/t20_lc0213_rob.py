"""LeetCode 213. House Robber II
https://leetcode.cn/problems/house-robber-ii/
"""

from typing import List


class Solution:
    def rob(self, nums: List[int]) -> int:
        pass

if __name__ == "__main__":
    solution = Solution()
    assert solution.rob([2, 3, 2]) == 3
    assert solution.rob([1, 2, 3, 1]) == 4
    assert solution.rob([1, 2, 3]) == 3
    print("All tests passed.")
