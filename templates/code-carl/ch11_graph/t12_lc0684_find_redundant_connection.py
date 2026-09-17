"""LeetCode 684. Redundant Connection
https://leetcode.cn/problems/redundant-connection/
"""

from typing import List


class Solution:
    def findRedundantConnection(self, edges: List[List[int]]) -> List[int]:
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
    assert solution.findRedundantConnection([[1, 2], [1, 3], [2, 3]]) == [2, 3]
    assert solution.findRedundantConnection([[1, 2], [2, 3], [3, 4], [1, 4], [1, 5]]) == [1, 4]

    print("All tests passed.")
