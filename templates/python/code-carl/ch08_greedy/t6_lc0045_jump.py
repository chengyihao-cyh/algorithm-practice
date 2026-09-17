"""LeetCode 45. Jump Game II
https://leetcode.cn/problems/jump-game-ii/
"""

from typing import List


class Solution:
    def jump(self, nums: List[int]) -> int:
        pass

if __name__ == "__main__":
    solution = Solution()
    assert solution.jump([2, 3, 1, 1, 4]) == 2
    assert solution.jump([2, 3, 0, 1, 4]) == 2
    print("All tests passed.")
