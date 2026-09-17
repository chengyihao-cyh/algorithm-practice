"""LeetCode 59. Spiral Matrix II
https://leetcode.cn/problems/spiral-matrix-ii/
"""

from typing import List


class Solution:
    def generateMatrix(self, n: int) -> List[List[int]]:
        pass


if __name__ == "__main__":
    solution = Solution()
    assert solution.generateMatrix(1) == [[1]]
    assert solution.generateMatrix(3) == [[1, 2, 3], [8, 9, 4], [7, 6, 5]]
    print("All tests passed.")
    pass
