"""LeetCode 417. Pacific Atlantic Water Flow
https://leetcode.cn/problems/pacific-atlantic-water-flow/
"""

from typing import List, Set, Tuple


class Solution:
    def waterFlow(self, grid: List[List[int]]) -> List[List[int]]:
        pass

    def dfs(self, x: int, y: int, visited: Set[Tuple[int, int]]) -> None:
        pass

    def isValid(self, x: int, y: int) -> bool:
        pass


if __name__ == "__main__":
    solution = Solution()

    result = sorted(solution.waterFlow([[1, 2, 2, 3, 5], [3, 2, 3, 4, 4], [2, 4, 5, 3, 1], [6, 7, 1, 4, 5], [5, 1, 1, 2, 4]]))
    expected = sorted([[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]])
    assert result == expected

    assert solution.waterFlow([[1]]) == [[0, 0]]

    print("All tests passed.")
