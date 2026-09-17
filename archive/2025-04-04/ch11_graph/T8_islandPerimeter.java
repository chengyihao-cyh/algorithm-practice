package org.review2025spring.ch11_graph;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/12/2 17:46
 * @comment
 */
public class T8_islandPerimeter {
    int[][] grid;
    int count;
    int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int islandPerimeter(int[][] grid) {
        this.grid = grid;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    dfs(i, j);
                }
            }
        }

        return count;
    }

    public void dfs(int x, int y) {
        if (!isValid(x, y) || grid[x][y] == 0) {
            count++;
            return;
        }
        if (grid[x][y] == 2)
            return;
        grid[x][y] = 2;
        for (int[] dir : dirs) {
            dfs(x + dir[0], y + dir[1]);
        }
    }

    public boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < grid.length && y < grid[0].length;
    }
}