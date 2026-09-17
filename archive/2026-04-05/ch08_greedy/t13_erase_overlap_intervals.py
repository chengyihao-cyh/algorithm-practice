"""LeetCode 435. Non-overlapping Intervals
https://leetcode.cn/problems/non-overlapping-intervals/
"""

from typing import List


class Solution:
    def eraseOverlapIntervals(self, intervals: List[List[int]]) -> int:
        intervals = sorted(intervals, key=lambda i: i[0])
        right_border = intervals[0][1]
        cnt = 0

        for interval in intervals[1:]:
            if interval[0] < right_border:
                cnt += 1
                right_border = min(right_border, interval[1])
            else:
                right_border = interval[1]

        return cnt

if __name__ == "__main__":
    solution = Solution()
    assert solution.eraseOverlapIntervals([[1, 2], [2, 3], [3, 4], [1, 3]]) == 1
    assert solution.eraseOverlapIntervals([[1, 2], [1, 2], [1, 2]]) == 2
    assert solution.eraseOverlapIntervals([[1, 2], [2, 3]]) == 0
    print("All tests passed.")
