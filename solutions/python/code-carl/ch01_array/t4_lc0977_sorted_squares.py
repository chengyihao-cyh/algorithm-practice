"""LeetCode 977. Squares of a Sorted Array
https://leetcode.cn/problems/squares-of-a-sorted-array/
"""
from typing import List


class Solution:
    def sortedSquares(self, nums: List[int]) -> List[int]:
        l, r, idx = 0, len(nums) - 1, len(nums) - 1
        res: List[int] = [0] * len(nums)
        while l <= r:
            if abs(nums[l]) > abs(nums[r]):
                res[idx] = pow(nums[l], 2)
                idx -= 1
                l += 1
            else:
                res[idx] = pow(nums[r], 2)
                idx -= 1
                r -= 1
        return res


if __name__ == "__main__":
    solution = Solution()
    assert solution.sortedSquares([-4, -1, 0, 3, 10]) == [0, 1, 9, 16, 100]
    assert solution.sortedSquares([-7, -3, 2, 3, 11]) == [4, 9, 9, 49, 121]
    assert solution.sortedSquares([0]) == [0]
    assert solution.sortedSquares([-2, -1]) == [1, 4]
    print("All tests passed.")
