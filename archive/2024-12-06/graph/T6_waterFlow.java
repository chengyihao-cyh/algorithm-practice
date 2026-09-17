package org.review2024winter.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/12/2 15:11
 * @comment
 */
public class T6_waterFlow {
    int[][] grid;
    int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public List<int[]> waterFlow(int[][] grid) {
        this.grid = grid;
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] firstVisited = new boolean[n][m];
        boolean[][] secondVisited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            dfs(i, 0, firstVisited);
            dfs(i, m - 1, secondVisited);
        }

        for (int j = 0; j < m; j++) {
            dfs(0, j, firstVisited);
            dfs(n - 1, j, secondVisited);
        }

        ArrayList<int[]> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (firstVisited[i][j] && secondVisited[i][j]) {
                    result.add(new int[]{i, j});
                }
            }
        }

        return result;
    }

    public void dfs(int x, int y, boolean[][] visited) {
        visited[x][y] = true;
        for (int[] dir : dirs) {
            int nextX = x + dir[0];
            int nextY = y + dir[1];
            if (!isValid(nextX, nextY) || visited[nextX][nextY] || grid[nextX][nextY] < grid[x][y])
                continue;
            dfs(nextX, nextY, visited);
        }
    }

    public boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < grid.length && y < grid[0].length;
    }
}