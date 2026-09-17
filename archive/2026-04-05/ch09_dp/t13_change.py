"""LeetCode 518. Coin Change II
https://leetcode.cn/problems/coin-change-ii/
"""

from typing import List


class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        pass

if __name__ == "__main__":
    solution = Solution()
    assert solution.change(5, [1, 2, 5]) == 4
    assert solution.change(3, [2]) == 0
    assert solution.change(10, [10]) == 1
    print("All tests passed.")
