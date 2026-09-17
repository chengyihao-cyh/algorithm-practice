"""LeetCode 392. Is Subsequence
https://leetcode.cn/problems/is-subsequence/
"""


class Solution:
    def isSubsequence(self, s: str, t: str) -> bool:
        pass

if __name__ == "__main__":
    solution = Solution()
    assert solution.isSubsequence('abc', 'ahbgdc') == True
    assert solution.isSubsequence('axc', 'ahbgdc') == False
    print("All tests passed.")
