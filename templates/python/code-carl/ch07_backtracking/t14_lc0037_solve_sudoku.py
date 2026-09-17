"""LeetCode 37. Sudoku Solver
https://leetcode.cn/problems/sudoku-solver/
"""

from typing import List


class Solution:
    def solveSudoku(self, board: List[List[str]]) -> None:
        pass


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
