"""LeetCode 746. Min Cost Climbing Stairs
https://leetcode.cn/problems/min-cost-climbing-stairs/
"""

from typing import List


class Solution:
    def minCostClimbingStairs(self, cost: List[int]) -> int:
        pass

if __name__ == "__main__":
    solution = Solution()
    assert solution.minCostClimbingStairs([10, 15, 20]) == 15
    assert solution.minCostClimbingStairs([1, 100, 1, 1, 1, 100, 1, 1, 100, 1]) == 6
    print("All tests passed.")
