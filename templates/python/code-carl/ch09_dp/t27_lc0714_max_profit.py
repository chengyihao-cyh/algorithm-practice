"""LeetCode 714. Best Time to Buy and Sell Stock with Transaction Fee
https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
"""

from typing import List


class Solution:
    def maxProfit(self, prices: List[int], fee: int) -> int:
        pass

if __name__ == "__main__":
    solution = Solution()
    assert solution.maxProfit([1, 3, 2, 8, 4, 9], 2) == 8
    assert solution.maxProfit([1, 3, 7, 5, 10, 3], 3) == 6
    print("All tests passed.")
