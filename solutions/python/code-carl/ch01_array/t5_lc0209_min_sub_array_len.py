"""LeetCode 209. Minimum Size Subarray Sum
https://leetcode.cn/problems/minimum-size-subarray-sum/
"""
import sys
from typing import List


class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        i, currSum, minLen = 0, 0, sys.maxsize
        for j, _ in enumerate(nums):
            currSum += nums[j]
            while currSum >= target:
                currSum -= nums[i]
                minLen = min(minLen, j - i + 1)
                i += 1
        return 0 if minLen == sys.maxsize else minLen


if __name__ == "__main__":
    solution = Solution()
    assert solution.minSubArrayLen(7, [2, 3, 1, 2, 4, 3]) == 2
    assert solution.minSubArrayLen(4, [1, 4, 4]) == 1
    assert solution.minSubArrayLen(11, [1, 1, 1, 1, 1, 1, 1, 1]) == 0
    print("All tests passed.")
