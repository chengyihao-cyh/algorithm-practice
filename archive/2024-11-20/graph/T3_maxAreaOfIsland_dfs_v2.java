package org.learn2024winter.graph;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/12/2 12:22
 * @comment
 */
public class T3_maxAreaOfIsland_dfs_v2 {
    int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    int[][] grid;
    int count;

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
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != 1)
            return;
        grid[x][y] = 2;
        count++;
        for (int[] dir : dirs) {
            dfs(x + dir[0], y + dir[1]);
        }
    }
}
