"""LeetCode 494. Target Sum
https://leetcode.cn/problems/target-sum/
"""
from symbol import yield_arg
from typing import List


class Solution:
    def findTargetSumWays(self, nums: List[int], target: int) -> int:
        total = sum(nums)
        if abs(target) > total or (total + target) % 2 == 1:
            return 0

        bag_size = (target + total) // 2
        dp: List[int] = [0] * (bag_size + 1)
        dp[0] = 1

        for n in nums:
            for j in range(bag_size, n - 1, -1):
                dp[j] += dp[j - n]

        return dp[-1]


if __name__ == "__main__":
    solution = Solution()
    assert solution.findTargetSumWays([1, 1, 1, 1, 1], 3) == 5
    assert solution.findTargetSumWays([1], 1) == 1
    print("All tests passed.")
