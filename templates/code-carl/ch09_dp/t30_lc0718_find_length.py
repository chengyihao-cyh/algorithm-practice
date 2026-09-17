"""LeetCode 718. Maximum Length of Repeated Subarray
https://leetcode.cn/problems/maximum-length-of-repeated-subarray/
"""

from typing import List


class Solution:
    def findLength(self, nums1: List[int], nums2: List[int]) -> int:
        pass

if __name__ == "__main__":
    solution = Solution()
    assert solution.findLength([1, 2, 3, 2, 1], [3, 2, 1, 4, 7]) == 3
    assert solution.findLength([0, 0, 0, 0, 0], [0, 0, 0, 0, 0]) == 5
    print("All tests passed.")
