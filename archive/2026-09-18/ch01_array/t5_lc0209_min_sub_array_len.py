"""LeetCode 209. Minimum Size Subarray Sum
https://leetcode.cn/problems/minimum-size-subarray-sum/
"""
import sys
from typing import List


class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        l, r, sum = 0, 0, 0
        min_len = sys.maxsize

        while r < len(nums):
            while r < len(nums) and sum < target:
                sum += nums[r]
                r += 1
            while sum >= target:
                min_len = min(min_len, r - l)
                sum -= nums[l]
                l += 1

        return 0 if min_len == sys.maxsize else min_len


if __name__ == "__main__":
    solution = Solution()
    assert solution.minSubArrayLen(7, [2, 3, 1, 2, 4, 3]) == 2
    assert solution.minSubArrayLen(4, [1, 4, 4]) == 1
    assert solution.minSubArrayLen(11, [1, 1, 1, 1, 1, 1, 1, 1]) == 0
    print("All tests passed.")
