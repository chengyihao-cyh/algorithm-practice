"""LeetCode 309. Best Time to Buy and Sell Stock with Cooldown
https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-cooldown/
"""

from typing import List


class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        pass

if __name__ == "__main__":
    solution = Solution()
    assert solution.maxProfit([1, 2, 3, 0, 2]) == 3
    assert solution.maxProfit([1]) == 0
    print("All tests passed.")
