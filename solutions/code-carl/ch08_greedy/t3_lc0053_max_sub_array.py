"""LeetCode 53. Maximum Subarray
https://leetcode.cn/problems/maximum-subarray/
"""

from typing import List

import sys


class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        curr_sum: int = 0
        max_sum: int = -sys.maxsize - 1

        for num in nums:
            curr_sum += num
            max_sum = max(curr_sum, max_sum)
            curr_sum = max(curr_sum, 0)

        return max_sum


if __name__ == "__main__":
    solution = Solution()
    assert solution.maxSubArray([-2, 1, -3, 4, -1, 2, 1, -5, 4]) == 6
    assert solution.maxSubArray([1]) == 1
    assert solution.maxSubArray([5, 4, -1, 7, 8]) == 23
    print("All tests passed.")
