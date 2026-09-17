package org.review2025autumn.ch07_backtracking;

public class T14_solveSudoku {
    public void solveSudoku(char[][] board) {
        backtracking(board, 0);
    }

    public boolean backtracking(char[][] board, int idx) {
        if (idx == 81) {
            return true;
        }

        int row = idx / 9, col = idx % 9;

        if (board[row][col] != '.') {
            return backtracking(board, idx + 1);
        }

        for (int num = 1; num <= 9; num++) {
            if (isValid(board, row, col, num)) {
                board[row][col] = (char) (num + '0');
                boolean success = backtracking(board, idx + 1);
                if (success) {
                    return true;
                }
                board[row][col] = '.';
            }
        }
        return false;
    }

    public boolean isValid(char[][] board, int row, int col, int num) {
        for (int j = 0; j < 9; j++) {
            if (board[row][j] - '0' == num) {
                return false;
            }
        }
        for (int i = 0; i < 9; i++) {
            if (board[i][col] - '0' == num) {
                return false;
            }
        }
        int startRow = row / 3 * 3;
        int startCol = col / 3 * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] - '0' == num) {
                    return false;
                }
            }
        }
        return true;
    }

}
