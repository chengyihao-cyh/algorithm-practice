"""LeetCode 674. Longest Continuous Increasing Subsequence
https://leetcode.cn/problems/longest-continuous-increasing-subsequence/
"""

from typing import List


class Solution:
    def findLengthOfLCIS(self, nums: List[int]) -> int:
        pass

if __name__ == "__main__":
    solution = Solution()
    assert solution.findLengthOfLCIS([1, 3, 5, 4, 7]) == 3
    assert solution.findLengthOfLCIS([2, 2, 2, 2, 2]) == 1
    print("All tests passed.")
