"""LeetCode 416. Partition Equal Subset Sum
https://leetcode.cn/problems/partition-equal-subset-sum/
"""

from typing import List


class Solution:
    def canPartition(self, nums: List[int]) -> bool:
        pass

if __name__ == "__main__":
    solution = Solution()
    assert solution.canPartition([1, 5, 11, 5]) == True
    assert solution.canPartition([1, 2, 3, 5]) == False
    print("All tests passed.")
