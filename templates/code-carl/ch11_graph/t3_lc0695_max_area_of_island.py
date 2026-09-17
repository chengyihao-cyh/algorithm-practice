"""LeetCode 695. Max Area of Island
https://leetcode.cn/problems/max-area-of-island/
"""

from typing import List


class Solution:
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        pass

    def dfs(self, x: int, y: int) -> None:
        pass

    def isValid(self, x: int, y: int) -> bool:
        pass


if __name__ == "__main__":
    solution = Solution()

    assert solution.maxAreaOfIsland(
        [
            [0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0],
            [0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0],
            [0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0],
            [0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0],
            [0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0],
            [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0],
            [0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0],
            [0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0],
        ]
    ) == 6

    assert solution.maxAreaOfIsland([[0, 0, 0, 0, 0, 0, 0, 0]]) == 0

    print("All tests passed.")
