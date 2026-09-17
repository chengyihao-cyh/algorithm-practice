"""LeetCode 1971. Find if Path Exists in Graph
https://leetcode.cn/problems/find-if-path-exists-in-graph/
"""

from typing import List


class Solution:
    def validPath(
        self, n: int, edges: List[List[int]], source: int, destination: int
    ) -> bool:
        pass

    class UnionFind:
        def __init__(self, n: int) -> None:
            pass

        def find(self, x: int) -> int:
            pass

        def union(self, x: int, y: int) -> None:
            pass

        def isSame(self, x: int, y: int) -> bool:
            pass


if __name__ == "__main__":
    solution = Solution()
    assert solution.validPath(3, [[0, 1], [1, 2], [2, 0]], 0, 2) is True
    assert solution.validPath(6, [[0, 1], [0, 2], [3, 5], [5, 4], [4, 3]], 0, 5) is False

    print("All tests passed.")
