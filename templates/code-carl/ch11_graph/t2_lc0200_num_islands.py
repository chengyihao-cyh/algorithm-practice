"""LeetCode 200. Number of Islands
https://leetcode.cn/problems/number-of-islands/
"""

from typing import List


class Solution:
    def numIslands_dfs(self, grid: List[List[str]]) -> int:
        pass

    def dfs(self, x: int, y: int) -> None:
        pass

    def numIslands_bfs(self, grid: List[List[str]]) -> int:
        pass

    def bfs(self, x: int, y: int) -> None:
        pass

    def isValid(self, x: int, y: int) -> bool:
        pass


if __name__ == "__main__":
    solution = Solution()

    grid = [
        ["1", "1", "1", "1", "0"],
        ["1", "1", "0", "1", "0"],
        ["1", "1", "0", "0", "0"],
        ["0", "0", "0", "0", "0"],
    ]
    assert (
        solution.numIslands_dfs([row[:] for row in grid]),
        solution.numIslands_bfs([row[:] for row in grid]),
    ) == (1, 1)

    grid = [
        ["1", "1", "0", "0", "0"],
        ["1", "1", "0", "0", "0"],
        ["0", "0", "1", "0", "0"],
        ["0", "0", "0", "1", "1"],
    ]
    assert (
        solution.numIslands_dfs([row[:] for row in grid]),
        solution.numIslands_bfs([row[:] for row in grid]),
    ) == (3, 3)

    print("All tests passed.")
