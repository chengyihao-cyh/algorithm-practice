"""LeetCode 37. Sudoku Solver
https://leetcode.cn/problems/sudoku-solver/
"""

from typing import List


class Solution:
    def solveSudoku(self, board: List[List[str]]) -> None:
        candidates = [str(n) for n in range(1, 10)]

        def backtracking(board: List[List[str]], idx: int) -> bool:
            if idx == 81:
                return True

            row = idx // 9
            col = idx % 9

            if board[row][col] != ".":
                return backtracking(board, idx + 1)

            for n in candidates:
                if not is_valid(board, row, col, n):
                    continue
                board[row][col] = n
                if backtracking(board, idx + 1):
                    return True
                board[row][col] = "."

            return False

        def is_valid(board: List[List[str]], row: int, col: int, num: str) -> bool:
            # 行
            for j in range(9):
                if board[row][j] == num:
                    return False
            # 列
            for i in range(9):
                if board[i][col] == num:
                    return False
            # 九宫格
            start_row, start_col = row // 3 * 3, col // 3 * 3
            for i in range(start_row, start_row + 3):
                for j in range(start_col, start_col + 3):
                    if num == board[i][j]:
                        return False
            return True

        backtracking(board, 0)


if __name__ == "__main__":
    solution = Solution()
    board = [
        ["5", "3", ".", ".", "7", ".", ".", ".", "."],
        ["6", ".", ".", "1", "9", "5", ".", ".", "."],
        [".", "9", "8", ".", ".", ".", ".", "6", "."],
        ["8", ".", ".", ".", "6", ".", ".", ".", "3"],
        ["4", ".", ".", "8", ".", "3", ".", ".", "1"],
        ["7", ".", ".", ".", "2", ".", ".", ".", "6"],
        [".", "6", ".", ".", ".", ".", "2", "8", "."],
        [".", ".", ".", "4", "1", "9", ".", ".", "5"],
        [".", ".", ".", ".", "8", ".", ".", "7", "9"],
    ]
    solution.solveSudoku(board)
    assert board[0] == ["5", "3", "4", "6", "7", "8", "9", "1", "2"]

    print("All tests passed.")
