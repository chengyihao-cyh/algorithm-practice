"""LeetCode 96. Unique Binary Search Trees
https://leetcode.cn/problems/unique-binary-search-trees/
"""
from typing import List


class Solution:
    def numTrees(self, n: int) -> int:
        if n <= 1:
            return 1

        dp: List[int] = [0] * (n + 1)
        dp[0], dp[1] = 1, 1

        for i in range(2, len(dp)):
            for j in range(1, i + 1):
                dp[i] += dp[j - 1] * dp[i - j]

        return dp[-1]


if __name__ == "__main__":
    solution = Solution()
    assert solution.numTrees(3) == 5
    assert solution.numTrees(1) == 1
    print("All tests passed.")
