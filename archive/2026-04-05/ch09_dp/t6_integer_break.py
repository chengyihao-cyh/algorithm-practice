"""LeetCode 343. Integer Break
https://leetcode.cn/problems/integer-break/
"""
from typing import List


class Solution:
    def integerBreak(self, n: int) -> int:
        dp: List[int] = [0] * (n + 1)
        dp[0], dp[1], dp[2] = 0, 0, 1
        for i in range(3, len(dp)):
            for j in range(1, i // 2 + 1):
                dp[i] = max(dp[i], j * (i - j), j * dp[i - j])

        return dp[-1]


if __name__ == "__main__":
    solution = Solution()
    assert solution.integerBreak(2) == 1
    assert solution.integerBreak(10) == 36
    print("All tests passed.")
