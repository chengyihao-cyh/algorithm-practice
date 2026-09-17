"""LeetCode 459. Repeated Substring Pattern
https://leetcode.cn/problems/repeated-substring-pattern/
"""


class Solution:
    def repeatedSubstringPattern(self, s: str) -> bool:
        pass


if __name__ == "__main__":
    solution = Solution()
    assert solution.repeatedSubstringPattern("abab") is True
    assert solution.repeatedSubstringPattern("aba") is False
    assert solution.repeatedSubstringPattern("abcabcabcabc") is True
    print("All tests passed.")
