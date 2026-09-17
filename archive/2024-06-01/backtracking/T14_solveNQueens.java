package org.review2024summer.backtracking;

import java.util.ArrayList;
import java.util.List;

public class T14_solveNQueens {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        boolean[][] chessboard = new boolean[n][n];
        backtracking(chessboard, 0);
        return res;
    }
    public void backtracking(boolean[][] chessboard, int row) {
        int n = chessboard.length;
        if (row == n) {
            ArrayList<String> ansString = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder line = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if(chessboard[i][j])
                        line.append("Q");
                    else
                        line.append(".");
                }
                ansString.add(line.toString());
            }
            res.add(ansString);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (!isValid(chessboard, row, col))
                continue;
            chessboard[row][col] = true;
            backtracking(chessboard, row + 1);
            chessboard[row][col] = false;
        }
    }

    public boolean isValid(boolean[][] chessboard, int row, int col) {
        int n = chessboard.length;
        // 从[row,col] 向上方直线找
        for (int i = row - 1; i >= 0; i--)
            if (chessboard[i][col])
                return false;
        // 行不用检查 一行只会有一个
        // 从[row,col] 向左上方对角线寻找
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
            if (chessboard[i][j])
                return false;
        // 从[row,col] 向右上方对角线寻找
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++)
            if (chessboard[i][j])
                return false;
        return true;
    }
}
