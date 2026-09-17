"""LeetCode 55. Jump Game
https://leetcode.cn/problems/jump-game/
"""
from typing import List


class Solution:
    def canJump(self, nums: List[int]) -> bool:
        if len(nums) <= 1:
            return True

        idx: int = 0
        cover: int = 0

        while idx <= cover:
            cover = max(cover, idx + nums[idx])
            if cover >= len(nums) - 1:
                return True
            idx += 1

        return False


if __name__ == "__main__":
    solution = Solution()
    assert solution.canJump([2, 3, 1, 1, 4]) == True
    assert solution.canJump([3, 2, 1, 0, 4]) == False
    print("All tests passed.")
