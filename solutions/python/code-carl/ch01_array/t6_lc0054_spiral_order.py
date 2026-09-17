"""LeetCode 54. Spiral Matrix
https://leetcode.cn/problems/spiral-matrix/
"""
from itertools import count
from typing import List


class Solution:
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        row, col = len(matrix), len(matrix[0])
        res: List[int] = [0] * row * col
        idx = count(0)
        for r in range(min(row, col) // 2):
            for j in range(r, col - r - 1):
                res[next(idx)] = matrix[r][j]
            for i in range(r, row - r - 1):
                res[next(idx)] = matrix[i][col - r - 1]
            for j in range(col - r - 1, r, -1):
                res[next(idx)] = matrix[row - r - 1][j]
            for i in range(row - r - 1, r, -1):
                res[next(idx)] = matrix[i][r]

        if min(row, col) % 2 == 1:
            r = min(row, col) // 2
            if row < col:
                for j in range(r, col - r):
                    res[next(idx)] = matrix[r][j]
            else:
                for i in range(r, row - r):
                    res[next(idx)] = matrix[i][r]

        return res


if __name__ == "__main__":
    solution = Solution()
    assert solution.spiralOrder([[1, 2, 3], [4, 5, 6], [7, 8, 9]]) == [1, 2, 3, 6, 9, 8, 7, 4, 5]
    assert solution.spiralOrder([[1, 2, 3, 4], [5, 6, 7, 8], [9, 10, 11, 12]]) == [1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6,
                                                                                   7]
    print("All tests passed.")
