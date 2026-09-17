"""LeetCode 122. Best Time to Buy and Sell Stock II
https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/
"""

from typing import List


class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        pass

if __name__ == "__main__":
    solution = Solution()
    assert solution.maxProfit([7, 1, 5, 3, 6, 4]) == 7
    assert solution.maxProfit([1, 2, 3, 4, 5]) == 4
    assert solution.maxProfit([7, 6, 4, 3, 1]) == 0
    print("All tests passed.")
