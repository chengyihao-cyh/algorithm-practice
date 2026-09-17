"""LeetCode 55. Jump Game
https://leetcode.cn/problems/jump-game/
"""

from typing import List


class Solution:
    def canJump(self, nums: List[int]) -> bool:
        pass

if __name__ == "__main__":
    solution = Solution()
    assert solution.canJump([2, 3, 1, 1, 4]) == True
    assert solution.canJump([3, 2, 1, 0, 4]) == False
    print("All tests passed.")
