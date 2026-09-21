"""LeetCode 151. Reverse Words in a String
https://leetcode.cn/problems/reverse-words-in-a-string/
"""
from typing import List


class Solution:
    def reverseWords(self, s: str) -> str:
        s = s.strip()
        l = r = len(s) - 1
        words: List[str] = []

        while l >= 0:
            while l >= 0 and s[l] != " ":
                l -= 1
            words.append(s[l + 1:r + 1])
            while s[l] == " ":
                l -= 1
            r = l

        return " ".join(words)


if __name__ == "__main__":
    solution = Solution()
    assert solution.reverseWords("the sky is blue") == "blue is sky the"
    assert solution.reverseWords("  hello world  ") == "world hello"
    print("All tests passed.")
