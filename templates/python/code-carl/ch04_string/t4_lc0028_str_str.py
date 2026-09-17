"""LeetCode 28. Find the Index of the First Occurrence in a String
https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string/
"""


class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        pass


if __name__ == "__main__":
    solution = Solution()
    assert solution.strStr("sadbutsad", "sad") == 0
    assert solution.strStr("leetcode", "leeto") == -1
    print("All tests passed.")
