"""LeetCode 474. Ones and Zeroes
https://leetcode.cn/problems/ones-and-zeroes/
"""
from collections import Counter
from typing import List


class Solution:
    def findMaxForm(self, strs: List[str], m: int, n: int) -> int:
        dp: List[List[int]] = [[0] * (n + 1) for _ in range(m + 1)]
        for s in strs:
            cnt = Counter(s)
            for i in range(m, cnt['0'] - 1, -1):
                for j in range(n, cnt['1'] - 1, -1):
                    dp[i][j] = max(dp[i][j], dp[i - cnt['0']][j - cnt['1']] + 1)

        return dp[-1][-1]


if __name__ == "__main__":
    solution = Solution()
    assert solution.findMaxForm(['10', '0001', '111001', '1', '0'], 5, 3) == 4
    assert solution.findMaxForm(['10', '0', '1'], 1, 1) == 2
    print("All tests passed.")
