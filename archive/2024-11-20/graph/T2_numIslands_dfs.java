package org.learn2024winter.graph;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/12/2 10:35
 * @comment
 */
public class T2_numIslands_dfs {
    int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    char[][] grid;
    boolean[][] visited;

    public int numIslands(char[][] grid) {
        this.grid = grid;
        this.visited = new boolean[grid.length][grid[0].length];
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    result++;
                    visited[i][j] = true;
                    dfs(i, j);
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
            if (!visited[nextX][nextY] && grid[nextX][nextY] == '1') {
                visited[nextX][nextY] = true;
                dfs(nextX, nextY);
            }
        }
    }

}
