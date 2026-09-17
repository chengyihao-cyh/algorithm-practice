"""LeetCode 1. Two Sum
https://leetcode.cn/problems/two-sum/
"""

from typing import List, Dict


class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        idx_map: Dict[int, int] = {}
        for idx, num in enumerate(nums):
            if target - num in idx_map:
                return [idx_map[target - num], idx]
            idx_map[num] = idx
        return []


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
