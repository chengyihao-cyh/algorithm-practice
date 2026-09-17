"""LeetCode 1005. Maximize Sum Of Array After K Negations
https://leetcode.cn/problems/maximize-sum-of-array-after-k-negations/
"""

from typing import List


class Solution:
    def largestSumAfterKNegations(self, nums: List[int], k: int) -> int:
        pass

if __name__ == "__main__":
    solution = Solution()
    assert solution.largestSumAfterKNegations([4, 2, 3], 1) == 5
    assert solution.largestSumAfterKNegations([3, -1, 0, 2], 3) == 6
    assert solution.largestSumAfterKNegations([2, -3, -1, 5, -4], 2) == 13
    print("All tests passed.")
