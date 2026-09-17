package org.review2024winter.graph;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/12/2 12:22
 * @comment
 */
public class T3_maxAreaOfIsland {
    int[][] grid;
    int count;
    int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};


    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        int result = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    count = 0;
                    dfs(i, j);
                    result = Math.max(result, count);
                }
            }
        }
        return result;
    }

    public void dfs(int x, int y) {
        if (!isValid(x, y) || grid[x][y] != 1)
            return;
        count++;
        grid[x][y] = 2;
        for (int[] dir : dirs) {
            dfs(x + dir[0], y + dir[1]);
        }
    }

    public boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < grid.length && y < grid[0].length;
    }
}
