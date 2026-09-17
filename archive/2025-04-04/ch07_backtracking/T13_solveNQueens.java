package org.review2025spring.ch07_backtracking;

import java.util.ArrayList;
import java.util.List;

public class T13_solveNQueens {
    List<List<String>> res = new ArrayList<>();
    int[][] grid = null;

    public List<List<String>> solveNQueens(int n) {
        grid = new int[n][n];
        backtracking(0);
        return res;
    }
    public void backtracking(int i) {
        if (i == grid.length) {
            // 拼接结果
            List<String> gridStr = new ArrayList<>();
            for (int[] line : grid) {
                StringBuilder lineStr = new StringBuilder();
                for (int val :line){
                    if (val == 1) lineStr.append("Q");
                    else lineStr.append(".");
                }
                gridStr.add(lineStr.toString());
            }
            res.add(gridStr);
            return;
        }
        for (int j = 0; j < grid.length; j++) {
            if (!isValid(i, j)) continue;
            grid[i][j] = 1;
            backtracking(i + 1);
            grid[i][j] = 0;
        }
    }

    public boolean isValid(int i, int j) {
        // 行
        for (int row = i - 1; row >= 0; row--) {
            if (grid[row][j] == 1) return false;
        }
        // 左斜上
        for (int row = i - 1, col = j - 1; row >= 0 && col >= 0; row--, col--) {
            if (grid[row][col] == 1) return false;
        }
        // 右斜上
        for (int row = i - 1, col = j + 1; row >= 0 && col < grid.length; row--, col++) {
            if (grid[row][col] == 1) return false;
        }

        return true;
    }

}
