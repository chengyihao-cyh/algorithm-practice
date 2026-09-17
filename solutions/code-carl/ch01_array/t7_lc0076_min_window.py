"""LeetCode 76. Minimum Window Substring
https://leetcode.cn/problems/minimum-window-substring/
"""
import sys
from collections import Counter


class Solution:
    def minWindow(self, s: str, t: str) -> str:
        l, distance, = 0, len(t)
        minLen, resL, resR = sys.maxsize, -1, -1
        freq = Counter(t)

        for r, nextCh in enumerate(s):
            if nextCh in freq:
                freq[nextCh] -= 1
                if freq[nextCh] >= 0:
                    distance -= 1
                    while distance == 0:
                        if r - l + 1 < minLen:
                            minLen = r - l + 1
                            resL, resR = l, r
                        delCh = s[l]
                        l += 1
                        if delCh in freq:
                            freq[delCh] += 1
                            if freq[delCh] > 0:
                                distance += 1

        return "" if minLen == sys.maxsize else s[resL: resR + 1]


if __name__ == "__main__":
    solution = Solution()

    assert solution.minWindow("ADOBECODEBANC", "ABC") == "BANC"
    assert solution.minWindow("a", "a") == "a"
    assert solution.minWindow("a", "aa") == ""
    print("All tests passed.")
