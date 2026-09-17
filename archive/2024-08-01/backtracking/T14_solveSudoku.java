package org.rereview2024summer.backtracking;

public class T14_solveSudoku {
    public void solveSudoku(char[][] board) {
        backtracking(board);
    }

    public boolean backtracking(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (int num = 1; num <= 9; num++) {
                        if (!check(board, i, j, num))
                            continue;
                        board[i][j] = (char)(num + '0') ;
                        boolean result = backtracking(board);
                        if (result)
                            return true;
                        board[i][j] = '.';
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public boolean check(char[][] board, int row, int col, int num) {
        // line
        for (int j = 0; j < 9; j++)
            if (board[row][j] - '0' == num)
                return false;
        // colum
        for (int i = 0; i < 9; i++)
            if (board[i][col] - '0' == num)
                return false;
        // 9 block
        int startRow = row / 3 * 3;
        int startCol = col / 3 * 3;
        for (int i = startRow; i < startRow + 3; i++)
            for (int j = startCol; j < startCol + 3; j++)
                if (board[i][j] - '0' == num)
                    return false;
        return true;
    }
}
