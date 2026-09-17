"""LeetCode 322. Coin Change
https://leetcode.cn/problems/coin-change/
"""

from typing import List


class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        pass

if __name__ == "__main__":
    solution = Solution()
    assert solution.coinChange([1, 2, 5], 11) == 3
    assert solution.coinChange([2], 3) == -1
    assert solution.coinChange([1], 0) == 0
    print("All tests passed.")
