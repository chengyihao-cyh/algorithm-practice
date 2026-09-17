"""LeetCode 45. Jump Game II
https://leetcode.cn/problems/jump-game-ii/
"""

from typing import List


class Solution:
    def jump(self, nums: List[int]) -> int:
        if len(nums) <= 1:
            return 0

        curr_cover: int = 0
        next_cover: int = 0
        cnt: int = 0
        i: int = 0

        while i <= curr_cover:
            next_cover = max(next_cover, i + nums[i])
            if next_cover >= len(nums) - 1:
                return cnt + 1
            elif i == curr_cover:
                curr_cover = next_cover
                cnt += 1
            i += 1

        return cnt


if __name__ == "__main__":
    solution = Solution()
    assert solution.jump([2, 3, 1, 1, 4]) == 2
    assert solution.jump([2, 3, 0, 1, 4]) == 2
    print("All tests passed.")
