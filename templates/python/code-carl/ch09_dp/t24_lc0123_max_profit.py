"""LeetCode 123. Best Time to Buy and Sell Stock III
https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iii/
"""

from typing import List


class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        pass

if __name__ == "__main__":
    solution = Solution()
    assert solution.maxProfit([3, 3, 5, 0, 0, 3, 1, 4]) == 6
    assert solution.maxProfit([1, 2, 3, 4, 5]) == 4
    assert solution.maxProfit([7, 6, 4, 3, 1]) == 0
    print("All tests passed.")
