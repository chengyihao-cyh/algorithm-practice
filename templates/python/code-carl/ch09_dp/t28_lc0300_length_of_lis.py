"""LeetCode 300. Longest Increasing Subsequence
https://leetcode.cn/problems/longest-increasing-subsequence/
"""

from typing import List


class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        pass

if __name__ == "__main__":
    solution = Solution()
    assert solution.lengthOfLIS([10, 9, 2, 5, 3, 7, 101, 18]) == 4
    assert solution.lengthOfLIS([0, 1, 0, 3, 2, 3]) == 4
    assert solution.lengthOfLIS([7, 7, 7, 7, 7, 7, 7]) == 1
    print("All tests passed.")
