"""LeetCode 59. Spiral Matrix II
https://leetcode.cn/problems/spiral-matrix-ii/
"""
from itertools import count
from typing import List


class Solution:
    def generateMatrix(self, n: int) -> List[List[int]]:
        res: List[List[int]] = [[0] * n for _ in range(n)]
        cnt = count(1)
        for r in range(n // 2):
            for j in range(r, n - r - 1):
                res[r][j] = next(cnt)
            for i in range(r, n - r - 1):
                res[i][n - r - 1] = next(cnt)
            for j in range(n - r - 1, r, -1):
                res[n - r - 1][j] = next(cnt)
            for i in range(n - r - 1, r, - 1):
                res[i][r] = next(cnt)
        if n % 2 == 1:
            res[n // 2][n // 2] = next(cnt)
        return res


if __name__ == "__main__":
    solution = Solution()

    assert solution.generateMatrix(1) == [[1]]
    assert solution.generateMatrix(3) == [[1, 2, 3], [8, 9, 4], [7, 6, 5]]
    print("All tests passed.")
