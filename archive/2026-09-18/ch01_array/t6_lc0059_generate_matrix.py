"""LeetCode 59. Spiral Matrix II
https://leetcode.cn/problems/spiral-matrix-ii/
"""
from itertools import count
from typing import List


class Solution:
    def generateMatrix(self, n: int) -> List[List[int]]:
        matrix: List[List[int]] = [[0] * n for _ in range(n)]
        round = n // 2
        cnt = count(1)

        for r in range(round):
            for j in range(r, n - r - 1):
                matrix[r][j] = next(cnt)
            for i in range(r, n - r - 1):
                matrix[i][n - 1 - r] = next(cnt)
            for j in range(n - r - 1, r, -1):
                matrix[n - 1 - r][j] = next(cnt)
            for i in range(n - r - 1, r, -1):
                matrix[i][r] = next(cnt)

        if n % 2 == 1:
            matrix[round][round] = next(cnt)

        return matrix


if __name__ == "__main__":
    solution = Solution()
    assert solution.generateMatrix(1) == [[1]]
    assert solution.generateMatrix(3) == [[1, 2, 3], [8, 9, 4], [7, 6, 5]]
    print("All tests passed.")
