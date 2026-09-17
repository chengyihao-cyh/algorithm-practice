"""LeetCode 1005. Maximize Sum Of Array After K Negations
https://leetcode.cn/problems/maximize-sum-of-array-after-k-negations/
"""
import sys
from typing import List


class Solution:
    def largestSumAfterKNegations(self, nums: List[int], k: int) -> int:
        nums.sort()
        ans: int = 0
        min_abs: int = sys.maxsize

        for i, num in enumerate(nums):
            min_abs = min(min_abs, abs(num))
            if num < 0 < k:
                k -= 1
                nums[i] = -num
            ans += nums[i]

        return ans if k % 2 == 0 else ans - 2 * min_abs


if __name__ == "__main__":
    solution = Solution()
    assert solution.largestSumAfterKNegations([4, 2, 3], 1) == 5
    assert solution.largestSumAfterKNegations([3, -1, 0, 2], 3) == 6
    assert solution.largestSumAfterKNegations([2, -3, -1, 5, -4], 2) == 13
    print("All tests passed.")
