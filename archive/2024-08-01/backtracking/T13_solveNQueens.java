package org.rereview2024summer.backtracking;

import java.util.ArrayList;
import java.util.List;

public class T13_solveNQueens {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        boolean[][] chessboard = new boolean[n][n];
        backtracking(chessboard, 0);
        return res;
    }

    public void backtracking(boolean[][] chessboard, int row) {
        int n = chessboard.length;
        if (n == row) {
            List<String> ansStr = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder builder = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (chessboard[i][j])
                        builder.append("Q");
                    else
                        builder.append(".");
                }
                ansStr.add(builder.toString());
            }
            res.add(ansStr);
            return;
        }
        for (int j = 0; j < n; j++) {
            if (!check(chessboard, row, j))
                continue;
            chessboard[row][j] = true;
            backtracking(chessboard, row + 1);
            chessboard[row][j] = false;
        }
    }

    public boolean check(boolean[][] chessboard, int row, int col) {
        int n = chessboard.length;
        // col
        for (int i = row - 1; i >= 0; i--)
            if (chessboard[i][col])
                return false;
        // left up
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
            if (chessboard[i][j])
                return false;
        // right up
        for (int i = row - 1, j = col + 1; i >= 0 && j <= n; i--, j++)
            if (chessboard[i][j])
                return false;
        return true;
    }
}
