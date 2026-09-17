"""LeetCode 452. Minimum Number of Arrows to Burst Balloons
https://leetcode.cn/problems/minimum-number-of-arrows-to-burst-balloons/
"""

from typing import List


class Solution:
    def findMinArrowShots(self, points: List[List[int]]) -> int:
        points = sorted(points, key=lambda p: p[0])
        right_border = points[0][1]
        cnt = 1

        for point in points[1:]:
            if point[0] <= right_border:
                right_border = min(right_border, point[1])
            else:
                cnt += 1
                right_border = point[1]

        return cnt


if __name__ == "__main__":
    solution = Solution()
    assert solution.findMinArrowShots([[10, 16], [2, 8], [1, 6], [7, 12]]) == 2
    assert solution.findMinArrowShots([[1, 2], [3, 4], [5, 6], [7, 8]]) == 4
    assert solution.findMinArrowShots([[1, 2], [2, 3], [3, 4], [4, 5]]) == 2
    print("All tests passed.")
