"""LeetCode 28. Find the Index of the First Occurrence in a String
https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string/
"""
from typing import List


class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        next: List[int] = [0] * len(needle)

        j = 0
        for i in range(1, len(needle)):
            while j > 0 and needle[i] != needle[j]:
                j = next[j - 1]
            if needle[i] == needle[j]:
                j += 1
            next[i] = j

        j = 0
        for i in range(len(haystack)):
            while j > 0 and haystack[i] != needle[j]:
                j = next[j - 1]
            if haystack[i] == needle[j]:
                j += 1
                if j == len(needle):
                    return i - j + 1

        return -1


if __name__ == "__main__":
    solution = Solution()
    assert solution.strStr("sadbutsad", "sad") == 0
    assert solution.strStr("leetcode", "leeto") == -1
    assert solution.strStr("mississippi", "issip") == 4
    print("All tests passed.")
