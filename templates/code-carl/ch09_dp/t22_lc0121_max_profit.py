"""LeetCode 121. Best Time to Buy and Sell Stock
https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/
"""

from typing import List


class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        pass

if __name__ == "__main__":
    solution = Solution()
    assert solution.maxProfit([7, 1, 5, 3, 6, 4]) == 5
    assert solution.maxProfit([7, 6, 4, 3, 1]) == 0
    print("All tests passed.")
