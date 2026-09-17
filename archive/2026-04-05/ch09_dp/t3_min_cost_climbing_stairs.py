"""LeetCode 746. Min Cost Climbing Stairs
https://leetcode.cn/problems/min-cost-climbing-stairs/
"""

from typing import List


class Solution:
    def minCostClimbingStairs(self, cost: List[int]) -> int:
        if len(cost) == 0:
            return 0
        elif len(cost) == 1:
            return cost[0]
        elif len(cost) == 2:
            return min(cost[0], cost[1])

        dp: List[int] = [0] * (len(cost) + 1)
        for i in range(2, len(dp)):
            dp[i] = min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2])

        return dp[-1]


if __name__ == "__main__":
    solution = Solution()
    assert solution.minCostClimbingStairs([10, 15, 20]) == 15
    assert solution.minCostClimbingStairs([1, 100, 1, 1, 1, 100, 1, 1, 100, 1]) == 6
    print("All tests passed.")
