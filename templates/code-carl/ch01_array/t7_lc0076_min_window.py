"""LeetCode 76. Minimum Window Substring
https://leetcode.cn/problems/minimum-window-substring/
"""


class Solution:
    def minWindow(self, s: str, t: str) -> str:
        pass


if __name__ == "__main__":
    solution = Solution()
    assert solution.minWindow("ADOBECODEBANC", "ABC") == "BANC"
    assert solution.minWindow("a", "a") == "a"
    assert solution.minWindow("a", "aa") == ""
    print("All tests passed.")
