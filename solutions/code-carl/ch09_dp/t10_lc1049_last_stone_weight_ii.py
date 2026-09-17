"""LeetCode 1049. Last Stone Weight II
https://leetcode.cn/problems/last-stone-weight-ii/
"""

from typing import List


class Solution:
    def lastStoneWeightII(self, stones: List[int]) -> int:
        total = sum(stones)
        bag_size = total // 2
        dp: List[int] = [0] * (bag_size + 1)

        for w in stones:
            for j in range(bag_size, w - 1, -1):
                dp[j] = max(dp[j], dp[j - w] + w)

        return total - 2 * dp[-1]


if __name__ == "__main__":
    solution = Solution()
    assert solution.lastStoneWeightII([2, 7, 4, 1, 8, 1]) == 1
    assert solution.lastStoneWeightII([31, 26, 33, 21, 40]) == 5
    print("All tests passed.")
