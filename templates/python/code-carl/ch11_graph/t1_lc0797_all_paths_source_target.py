"""LeetCode 797. All Paths From Source to Target
https://leetcode.cn/problems/all-paths-from-source-to-target/
"""

from typing import List


class Solution:
    def allPathsSourceTarget(self, graph: List[List[int]]) -> List[List[int]]:
        pass

    def dfs(self, curr: int, end: int) -> None:
        pass


if __name__ == "__main__":
    solution = Solution()

    result = sorted(solution.allPathsSourceTarget([[1, 2], [3], [3], []]))
    assert result == sorted([[0, 1, 3], [0, 2, 3]])

    result = sorted(solution.allPathsSourceTarget([[4, 3, 1], [3, 2, 4], [3], [4], []]))
    assert result == sorted([[0, 4], [0, 3, 4], [0, 1, 3, 4], [0, 1, 2, 3, 4], [0, 1, 4]])

    print("All tests passed.")
