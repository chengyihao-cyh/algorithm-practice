"""LeetCode 376. Wiggle Subsequence
https://leetcode.cn/problems/wiggle-subsequence/
"""

from typing import List


class Solution:
    def wiggleMaxLength(self, nums: List[int]) -> int:
        pass

if __name__ == "__main__":
    solution = Solution()
    assert solution.wiggleMaxLength([1, 7, 4, 9, 2, 5]) == 6
    assert solution.wiggleMaxLength([1, 17, 5, 10, 13, 15, 10, 5, 16, 8]) == 7
    assert solution.wiggleMaxLength([1, 2, 3, 4, 5, 6, 7, 8, 9]) == 2
    print("All tests passed.")
