"""LeetCode 459. Repeated Substring Pattern
https://leetcode.cn/problems/repeated-substring-pattern/
"""


class Solution:
    def repeatedSubstringPattern(self, s: str) -> bool:
        next = [0] * len(s)

        j = 0
        for i in range(1, len(s)):
            while j > 0 and s[i] != s[j]:
                j = next[j - 1]
            if s[i] == s[j]:
                j += 1
            next[i] = j

        subLen = len(s) - next[-1]
        return subLen != len(s) and subLen != 0 and len(s) % subLen == 0


if __name__ == "__main__":
    solution = Solution()
    assert solution.repeatedSubstringPattern("abab") is True
    assert solution.repeatedSubstringPattern("aba") is False
    assert solution.repeatedSubstringPattern("abcabcabcabc") is True
    print("All tests passed.")
