"""LeetCode 188. Best Time to Buy and Sell Stock IV
https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iv/
"""

from typing import List


class Solution:
    def maxProfit(self, k: int, prices: List[int]) -> int:
        pass

if __name__ == "__main__":
    solution = Solution()
    assert solution.maxProfit(2, [2, 4, 1]) == 2
    assert solution.maxProfit(2, [3, 2, 6, 5, 0, 3]) == 7
    print("All tests passed.")
