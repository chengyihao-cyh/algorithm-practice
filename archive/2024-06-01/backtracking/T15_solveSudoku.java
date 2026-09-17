package org.review2024summer.backtracking;

import java.util.ArrayList;
import java.util.List;

public class T15_solveSudoku {
    public void solveSudoku(char[][] board) {
        backtracking(board);
    }
    public boolean backtracking(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (int num = 1; num <= 9; num++) {
                        if (!isValid(board, i, j, num))
                            continue;
                        board[i][j] = (char)(num + '0');
                        boolean res = backtracking(board);
                        if (res)
                            return true;
                        board[i][j] = '.';
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValid(char[][] board, int row, int col, int num) {
        // 判断行重复
        for (int j = 0; j < 9; j++)
            if (board[row][j] == (char)(num + '0'))
                return false;
        // 判断列重复
        for (int i = 0; i < 9; i++)
            if (board[i][col] == (char)(num + '0'))
                return false;
        // 判断九宫格重复
        int startCol = col / 3 * 3;
        int startRow = row / 3 * 3;
        for (int i = startRow; i < startRow + 3; i++)
            for (int j = startCol; j < startCol + 3; j++)
                if (board[i][j] == (char)(num + '0'))
                    return false;
        return true;
    }
}

