"""LeetCode 827. Making A Large Island
https://leetcode.cn/problems/making-a-large-island/
"""

from typing import List


class Solution:
    def largestIsland(self, grid: List[List[int]]) -> int:
        pass

    def dfs(self, x: int, y: int, mark: int) -> None:
        pass

    def isValid(self, x: int, y: int) -> bool:
        pass


if __name__ == "__main__":
    solution = Solution()
    assert solution.largestIsland([[1, 0], [0, 1]]) == 3
    assert solution.largestIsland([[1, 1], [1, 0]]) == 4
    assert solution.largestIsland([[1, 1], [1, 1]]) == 4

    print("All tests passed.")
