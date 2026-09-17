"""LeetCode 463. Island Perimeter
https://leetcode.cn/problems/island-perimeter/
"""

from typing import List


class Solution:
    def islandPerimeter(self, grid: List[List[int]]) -> int:
        pass

    def dfs(self, x: int, y: int) -> None:
        pass

    def isValid(self, x: int, y: int) -> bool:
        pass


if __name__ == "__main__":
    solution = Solution()
    assert solution.islandPerimeter([[0, 1, 0, 0], [1, 1, 1, 0], [0, 1, 0, 0], [1, 1, 0, 0]]) == 16
    assert solution.islandPerimeter([[1]]) == 4
    assert solution.islandPerimeter([[1, 0]]) == 4

    print("All tests passed.")
