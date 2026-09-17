"""LeetCode 454. 4Sum II
https://leetcode.cn/problems/4sum-ii/
"""

from typing import List


class Solution:
    def fourSumCount(
        self, nums1: List[int], nums2: List[int], nums3: List[int], nums4: List[int]
    ) -> int:
        pass


if __name__ == "__main__":
    solution = Solution()
    assert solution.fourSumCount([1, 2], [-2, -1], [-1, 2], [0, 2]) == 2
    assert solution.fourSumCount([0], [0], [0], [0]) == 1
    print("All tests passed.")
