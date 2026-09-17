"""LeetCode 209. Minimum Size Subarray Sum
https://leetcode.cn/problems/minimum-size-subarray-sum/
"""

from typing import List


class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        pass


if __name__ == "__main__":
    solution = Solution()
    assert solution.minSubArrayLen(7, [2, 3, 1, 2, 4, 3]) == 2
    assert solution.minSubArrayLen(4, [1, 4, 4]) == 1
    assert solution.minSubArrayLen(11, [1, 1, 1, 1, 1, 1, 1, 1]) == 0
    print("All tests passed.")
