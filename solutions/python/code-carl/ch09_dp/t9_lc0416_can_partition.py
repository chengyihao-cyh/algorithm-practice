"""LeetCode 416. Partition Equal Subset Sum
https://leetcode.cn/problems/partition-equal-subset-sum/
"""

from typing import List


class Solution:
    def canPartition(self, nums: List[int]) -> bool:
        total = sum(nums)
        if total % 2 == 1:
            return False

        bag_size = total // 2
        dp: List[int] = [0] * (bag_size + 1)
        for w in nums:
            for j in range(bag_size, w - 1, -1):
                dp[j] = max(dp[j], dp[j - w] + w)

        return dp[-1] == bag_size


if __name__ == "__main__":
    solution = Solution()
    assert solution.canPartition([1, 5, 11, 5]) == True
    assert solution.canPartition([1, 2, 3, 5]) == False
    print("All tests passed.")
