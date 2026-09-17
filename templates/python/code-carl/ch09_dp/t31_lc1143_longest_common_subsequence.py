"""LeetCode 1143. Longest Common Subsequence
https://leetcode.cn/problems/longest-common-subsequence/
"""


class Solution:
    def longestCommonSubsequence(self, text1: str, text2: str) -> int:
        pass

if __name__ == "__main__":
    solution = Solution()
    assert solution.longestCommonSubsequence('abcde', 'ace') == 3
    assert solution.longestCommonSubsequence('abc', 'abc') == 3
    assert solution.longestCommonSubsequence('abc', 'def') == 0
    print("All tests passed.")
