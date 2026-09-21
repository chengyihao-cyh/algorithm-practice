"""LeetCode 977. Squares of a Sorted Array
https://leetcode.cn/problems/squares-of-a-sorted-array/
"""

from typing import List


class Solution:
    def sortedSquares(self, nums: List[int]) -> List[int]:
        l, r = 0, len(nums) - 1
        ans: List[int] = [0] * len(nums)

        for i in range(len(nums) - 1, -1, -1):
            if abs(nums[l]) > abs(nums[r]):
                ans[i] = nums[l] ** 2
                l += 1
            else:
                ans[i] = nums[r] ** 2
                r -= 1
        return ans


if __name__ == "__main__":
    solution = Solution()
    assert solution.sortedSquares([-4, -1, 0, 3, 10]) == [0, 1, 9, 16, 100]
    assert solution.sortedSquares([-7, -3, 2, 3, 11]) == [4, 9, 9, 49, 121]
    print("All tests passed.")
