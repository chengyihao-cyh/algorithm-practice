"""LeetCode 283. Move Zeroes
https://leetcode.cn/problems/move-zeroes/
"""

from typing import List


class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        slow = 0
        for fast, _ in enumerate(nums):
            if nums[fast] != 0:
                nums[slow], nums[fast] = nums[fast], nums[slow]
                slow += 1


if __name__ == "__main__":
    solution = Solution()

    nums1 = [0, 1, 0, 3, 12]
    solution.moveZeroes(nums1)
    assert nums1 == [1, 3, 12, 0, 0]

    nums2 = [0]
    solution.moveZeroes(nums2)
    assert nums2 == [0]

    print("All tests passed.")
