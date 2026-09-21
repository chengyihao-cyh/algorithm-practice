"""LeetCode 54. Spiral Matrix
https://leetcode.cn/problems/spiral-matrix/
"""

from typing import List


class Solution:
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        ans: List[int] = []
        m, n = len(matrix), len(matrix[0])
        round = min(m, n) // 2
        for r in range(round):
            for j in range(r, n - r - 1):
                ans.append(matrix[r][j])
            for i in range(r, m - r - 1):
                ans.append(matrix[i][n - 1 - r])
            for j in range(n - r - 1, r, -1):
                ans.append(matrix[m - 1 - r][j])
            for i in range(m - r - 1, r, -1):
                ans.append(matrix[i][r])

        if min(m, n) % 2 == 1:
            if n > m:
                # row
                for j in range(round, n - round):
                    ans.append(matrix[round][j])
            else:
                # col
                for i in range(round, m - round):
                    ans.append(matrix[i][round])

        return ans


if __name__ == "__main__":
    solution = Solution()
    assert solution.spiralOrder([[1, 2, 3], [4, 5, 6], [7, 8, 9]]) == [1, 2, 3, 6, 9, 8, 7, 4, 5]
    assert solution.spiralOrder([[1, 2, 3, 4], [5, 6, 7, 8], [9, 10, 11, 12]]) == [1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6,
                                                                                   7]
    print("All tests passed.")
