"""LeetCode 51. N-Queens
https://leetcode.cn/problems/n-queens/
"""
from typing import List


class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        ans: List[List[str]] = []

        def backtracking(board: List[List[bool]], row: int) -> None:
            if row == n:
                one_ans: List[str] = []
                for line in board:
                    one_ans.append("".join(["Q" if b else "." for b in line]))
                ans.append(one_ans)

            for col in range(len(board)):
                if not is_valid(board, row, col):
                    continue
                board[row][col] = True
                backtracking(board, row + 1)
                board[row][col] = False

        def is_valid(board: List[List[bool]], row: int, col: int) -> bool:
            # 竖直
            for i in range(row):
                if board[i][col]:
                    return False

            # 左斜
            i, j = row - 1, col - 1
            while i >= 0 and j >= 0:
                if board[i][j]:
                    return False
                i -= 1
                j -= 1

            # 右斜
            i, j = row - 1, col + 1
            while i >= 0 and j < n:
                if board[i][j]:
                    return False
                i -= 1
                j += 1

            return True

        board: List[List[bool]] = [[False] * n for _ in range(n)]
        backtracking(board, 0)
        return ans


if __name__ == "__main__":
    solution = Solution()
    result = {tuple(x) for x in solution.solveNQueens(4)}
    expected = {
        (".Q..", "...Q", "Q...", "..Q."),
        ("..Q.", "Q...", "...Q", ".Q.."),
    }
    print(result)
    assert result == expected

    solution = Solution()
    assert solution.solveNQueens(1) == [["Q"]]

    print("All tests passed.")
