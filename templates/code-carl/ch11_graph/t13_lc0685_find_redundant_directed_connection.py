"""LeetCode 685. Redundant Connection II
https://leetcode.cn/problems/redundant-connection-ii/
"""

from typing import List


class Solution:
    def findRedundantDirectedConnection(self, edges: List[List[int]]) -> List[int]:
        pass

    def check_hasDim2(self, edges: List[List[int]], delIdx: int) -> bool:
        pass

    def check_notHasDim2(self, edges: List[List[int]]) -> bool:
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
    assert solution.findRedundantDirectedConnection([[1, 2], [1, 3], [2, 3]]) == [2, 3]
    assert solution.findRedundantDirectedConnection([[1, 2], [2, 3], [3, 4], [4, 1], [1, 5]]) == [4, 1]

    print("All tests passed.")
