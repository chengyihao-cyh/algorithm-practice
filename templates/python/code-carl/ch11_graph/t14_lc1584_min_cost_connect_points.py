"""LeetCode 1584. Min Cost to Connect All Points
https://leetcode.cn/problems/min-cost-to-connect-all-points/
"""

from typing import List


class Solution:
    def minCostConnectPoints(self, points: List[List[int]]) -> int:
        pass

    def calDist(self, point1: List[int], point2: List[int]) -> int:
        pass

    def prim(self, graph: List[List[int]]) -> int:
        pass

    def kruskal(self, edges: List[List[int]], n: int) -> int:
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
    assert solution.minCostConnectPoints([[0, 0], [2, 2], [3, 10], [5, 2], [7, 0]]) == 20
    assert solution.minCostConnectPoints([[3, 12], [-2, 5], [-4, 1]]) == 18
    print("All tests passed.")
