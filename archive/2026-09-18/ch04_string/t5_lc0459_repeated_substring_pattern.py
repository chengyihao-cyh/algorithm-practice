"""LeetCode 459. Repeated Substring Pattern
https://leetcode.cn/problems/repeated-substring-pattern/
"""
from typing import List


class Solution:
    def repeatedSubstringPattern(self, s: str) -> bool:
        j = 0
        next: List[int] = [0] * len(s)
        for i in range(1, len(s)):
            while j > 0 and s[i] != s[j]:
                j = next[j - 1]
            if s[i] == s[j]:
                j += 1
            next[i] = j

        return len(s) > next[-1] > 0 == len(s) % (len(s) - next[-1])


if __name__ == "__main__":
    solution = Solution()
    assert solution.repeatedSubstringPattern("abab") is True
    assert solution.repeatedSubstringPattern("aba") is False
    assert solution.repeatedSubstringPattern("abcabcabcabc") is True
    print("All tests passed.")
