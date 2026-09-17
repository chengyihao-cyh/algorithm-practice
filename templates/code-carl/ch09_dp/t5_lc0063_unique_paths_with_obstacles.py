"""LeetCode 63. Unique Paths II
https://leetcode.cn/problems/unique-paths-ii/
"""

from typing import List


class Solution:
    def uniquePathsWithObstacles(self, obstacleGrid: List[List[int]]) -> int:
        pass

if __name__ == "__main__":
    solution = Solution()
    assert solution.uniquePathsWithObstacles([[0, 0, 0], [0, 1, 0], [0, 0, 0]]) == 2
    assert solution.uniquePathsWithObstacles([[0, 1], [0, 0]]) == 1
    print("All tests passed.")
