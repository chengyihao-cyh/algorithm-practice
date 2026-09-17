"""LeetCode 994. Rotting Oranges
https://leetcode.cn/problems/rotting-oranges/
"""

from typing import List


class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        pass

    def isValid(self, x: int, y: int) -> bool:
        pass


if __name__ == "__main__":
    solution = Solution()
    assert solution.orangesRotting([[2, 1, 1], [1, 1, 0], [0, 1, 1]]) == 4
    assert solution.orangesRotting([[2, 1, 1], [0, 1, 1], [1, 0, 1]]) == -1
    assert solution.orangesRotting([[0, 2]]) == 0

    print("All tests passed.")
