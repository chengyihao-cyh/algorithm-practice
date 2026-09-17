package org.review2025autumn.ch07_backtracking;

import java.util.ArrayList;
import java.util.List;

public class T13_solveNQueens {
    List<List<String>> res = new ArrayList<>();
    boolean[][] board;

    public List<List<String>> solveNQueens(int n) {
        board = new boolean[n][n];
        backtracking(0);
        return res;
    }

    public void backtracking(int row) {
        if (row == board.length) {
            List<String> list = new ArrayList<>();
            for (boolean[] line : board) {
                StringBuilder sb = new StringBuilder();
                for (boolean b : line) {
                    sb.append(b ? "Q" : ".");
                }
                list.add(sb.toString());
            }
            res.add(list);
            return;
        }
        for (int j = 0; j < board.length; j++) {
            if (isValid(row, j)) {
                board[row][j] = true;
                backtracking(row + 1);
                board[row][j] = false;
            }
        }
    }

    public boolean isValid(int row, int col) {
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col]) {
                return false;
            }
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j]) {
                return false;
            }
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j]) {
                return false;
            }
        }
        return true;
    }

}
