"""LeetCode 76. Minimum Window Substring
https://leetcode.cn/problems/minimum-window-substring/
"""
from collections import defaultdict, Counter
from typing import Dict

import sys


class Solution:
    def minWindow(self, s: str, t: str) -> str:
        check = Counter(t)
        dist = sum(check.values())
        ans_l, ans_r, min_len = 0, 0, sys.maxsize

        l, r = 0, 0
        while r < len(s):
            while r < len(s) and dist > 0:
                if s[r] in check:
                    if check[s[r]] > 0:
                        dist -= 1
                    check[s[r]] -= 1
                r += 1
            while dist == 0:
                if r - l + 1 < min_len:
                    min_len = r - l + 1
                    ans_l, ans_r = l, r
                if s[l] in check:
                    if check[s[l]] == 0:
                        dist += 1
                    check[s[l]] += 1
                l += 1

        return s[ans_l:ans_r] if min_len != sys.maxsize else ""


if __name__ == "__main__":
    solution = Solution()
    assert solution.minWindow("ADOBECODEBANC", "ABC") == "BANC"
    assert solution.minWindow("a", "a") == "a"
    assert solution.minWindow("a", "aa") == ""
    print("All tests passed.")
