package org.learn2024winter.graph;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/12/2 12:22
 * @comment
 */
public class T3_maxAreaOfIsland_dfs {
    int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    int[][] grid;
    boolean[][] visited;
    int count = 0;

    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        this.visited = new boolean[grid.length][grid[0].length];
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    count = 1;
                    visited[i][j] = true;
                    dfs(i, j);
                    result = Math.max(result, count);
                }
            }
        }
        return result;
    }

    public void dfs(int x, int y) {
        for (int[] dir : dirs) {
            int nextX = x + dir[0];
            int nextY = y + dir[1];
            if (nextX < 0 || nextX >= grid.length || nextY < 0 || nextY >= grid[0].length)
                continue;
            if (grid[nextX][nextY] == 1 && !visited[nextX][nextY]) {
                visited[nextX][nextY] = true;
                count++;
                dfs(nextX, nextY);
            }
        }
    }
}
