"""LeetCode 62. Unique Paths
https://leetcode.cn/problems/unique-paths/
"""
from typing import List


class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        dp: List[List[int]] = [[0] * n for _ in range(m)]
        for i in range(m):
            dp[i][0] = 1
        for j in range(n):
            dp[0][j] = 1

        for i in range(1, m):
            for j in range(1, n):
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1]

        return dp[-1][-1]


if __name__ == "__main__":
    solution = Solution()
    assert solution.uniquePaths(3, 7) == 28
    assert solution.uniquePaths(3, 2) == 3
    print("All tests passed.")
