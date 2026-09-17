"""LeetCode 491. Non-decreasing Subsequences
https://leetcode.cn/problems/non-decreasing-subsequences/
"""

from typing import List


class Solution:
    def findSubsequences(self, nums: List[int]) -> List[List[int]]:
        pass


if __name__ == "__main__":
    solution = Solution()
    result = {tuple(x) for x in solution.findSubsequences([4, 6, 7, 7])}
    expected = {(4, 6), (4, 7), (4, 6, 7), (4, 6, 7, 7), (4, 7, 7), (6, 7), (6, 7, 7), (7, 7)}
    assert result == expected

    solution = Solution()
    assert solution.findSubsequences([4, 4, 3, 2, 1]) == [[4, 4]]

    print("All tests passed.")
