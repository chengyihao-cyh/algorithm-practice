"""LeetCode 115. Distinct Subsequences
https://leetcode.cn/problems/distinct-subsequences/
"""


class Solution:
    def numDistinct(self, s: str, t: str) -> int:
        pass

if __name__ == "__main__":
    solution = Solution()
    assert solution.numDistinct('rabbbit', 'rabbit') == 3
    assert solution.numDistinct('babgbag', 'bag') == 5
    print("All tests passed.")
