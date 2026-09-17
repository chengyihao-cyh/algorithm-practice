"""LeetCode 452. Minimum Number of Arrows to Burst Balloons
https://leetcode.cn/problems/minimum-number-of-arrows-to-burst-balloons/
"""

from typing import List


class Solution:
    def findMinArrowShots(self, points: List[List[int]]) -> int:
        pass

if __name__ == "__main__":
    solution = Solution()
    assert solution.findMinArrowShots([[10, 16], [2, 8], [1, 6], [7, 12]]) == 2
    assert solution.findMinArrowShots([[1, 2], [3, 4], [5, 6], [7, 8]]) == 4
    assert solution.findMinArrowShots([[1, 2], [2, 3], [3, 4], [4, 5]]) == 2
    print("All tests passed.")
