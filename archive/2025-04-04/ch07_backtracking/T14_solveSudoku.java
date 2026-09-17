package org.review2025spring.ch07_backtracking;

import java.util.ArrayList;

public class T14_solveSudoku {
    public void solveSudoku(char[][] board) {
        backtracking(board, 0);
    }

    public boolean backtracking(char[][] board, int idx) {
        if (idx == 81) // 终止条件：遍历完所有 81 个格子
            return true;

        int i = idx / 9, j = idx % 9;
        // 如果当前格子不是空格，直接跳过
        if (board[i][j] != '.') {
            return backtracking(board, idx + 1); // 继续下一个位置
        }

        // 当前格子是空格，尝试填入 1~9
        for (char n = '1'; n <= '9'; n++) {
            if (!isValid(board, i, j, n)) continue;
            board[i][j] = n;
            if (backtracking(board, idx + 1)) return true; // 找到解直接返回
            board[i][j] = '.'; // 回溯
        }

        return false; // 当前格子无法填入有效数字
    }

    public boolean isValid(char[][] board, int row, int col, char num) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num)
                return false;
        }
        for (int j = 0; j < 9; j++) {
            if (board[row][j] == num)
                return false;
        }
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == num)
                    return false;
            }
        }
        return true;
    }

}
