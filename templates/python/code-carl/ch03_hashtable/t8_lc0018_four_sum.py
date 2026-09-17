"""LeetCode 18. 4Sum
https://leetcode.cn/problems/4sum/
"""

from typing import List


class Solution:
    def fourSum(self, nums: List[int], target: int) -> List[List[int]]:
        pass


if __name__ == "__main__":
    solution = Solution()

    result1 = sorted([sorted(item) for item in solution.fourSum([1, 0, -1, 0, -2, 2], 0)])
    expected1 = sorted([[-2, -1, 1, 2], [-2, 0, 0, 2], [-1, 0, 0, 1]])
    assert result1 == expected1

    result2 = sorted([sorted(item) for item in solution.fourSum([2, 2, 2, 2, 2], 8)])
    assert result2 == [[2, 2, 2, 2]]

    print("All tests passed.")
