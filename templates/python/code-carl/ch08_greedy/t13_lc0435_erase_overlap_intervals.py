"""LeetCode 435. Non-overlapping Intervals
https://leetcode.cn/problems/non-overlapping-intervals/
"""

from typing import List


class Solution:
    def eraseOverlapIntervals(self, intervals: List[List[int]]) -> int:
        pass

if __name__ == "__main__":
    solution = Solution()
    assert solution.eraseOverlapIntervals([[1, 2], [2, 3], [3, 4], [1, 3]]) == 1
    assert solution.eraseOverlapIntervals([[1, 2], [1, 2], [1, 2]]) == 2
    assert solution.eraseOverlapIntervals([[1, 2], [2, 3]]) == 0
    print("All tests passed.")
