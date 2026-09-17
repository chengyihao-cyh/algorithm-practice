"""LeetCode 494. Target Sum
https://leetcode.cn/problems/target-sum/
"""

from typing import List


class Solution:
    def findTargetSumWays(self, nums: List[int], target: int) -> int:
        pass

if __name__ == "__main__":
    solution = Solution()
    assert solution.findTargetSumWays([1, 1, 1, 1, 1], 3) == 5
    assert solution.findTargetSumWays([1], 1) == 1
    print("All tests passed.")
