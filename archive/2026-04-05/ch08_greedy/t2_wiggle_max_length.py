"""LeetCode 376. Wiggle Subsequence
https://leetcode.cn/problems/wiggle-subsequence/
"""

from typing import List


class Solution:
    def wiggleMaxLength(self, nums: List[int]) -> int:
        pre_diff: int = 0
        curr_diff: int

        cnt: int = 1
        for i, num in enumerate(nums[:len(nums) - 1]):
            curr_diff = nums[i + 1] - nums[i]
            if pre_diff >= 0 > curr_diff or pre_diff <= 0 < curr_diff:
                cnt += 1
                pre_diff = curr_diff

        return cnt


if __name__ == "__main__":
    solution = Solution()
    assert solution.wiggleMaxLength([1, 7, 4, 9, 2, 5]) == 6
    assert solution.wiggleMaxLength([1, 17, 5, 10, 13, 15, 10, 5, 16, 8]) == 7
    assert solution.wiggleMaxLength([1, 2, 3, 4, 5, 6, 7, 8, 9]) == 2
    print("All tests passed.")
