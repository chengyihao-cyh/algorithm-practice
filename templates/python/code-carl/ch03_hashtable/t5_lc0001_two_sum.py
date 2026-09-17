"""LeetCode 1. Two Sum
https://leetcode.cn/problems/two-sum/
"""

from typing import List


class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        pass


if __name__ == "__main__":
    solution = Solution()
    nums = [2, 7, 11, 15]
    i, j = solution.twoSum(nums, 9)
    assert i != j
    assert nums[i] + nums[j] == 9

    nums2 = [3, 2, 4]
    i2, j2 = solution.twoSum(nums2, 6)
    assert i2 != j2
    assert nums2[i2] + nums2[j2] == 6

    print("All tests passed.")
