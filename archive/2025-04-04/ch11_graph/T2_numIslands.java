package org.review2025spring.ch11_graph;

import java.util.ArrayDeque;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/12/2 10:35
 * @comment
 */
public class T2_numIslands {
    char[][] grid;
    int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int numIslands_dfs(char[][] grid) {
        this.grid = grid;
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(i, j);
                }
            }
        }
        return count;
    }

    public void dfs(int x, int y) {
        if (!isValid(x, y) || grid[x][y] != '1')
            return;
        grid[x][y] = '2';
        for (int[] dir : dirs) {
            dfs(x + dir[0], y + dir[1]);
        }
    }

    public int numIslands_bfs(char[][] grid) {
        this.grid = grid;
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    grid[i][j] = '2';
                    bfs(i, j);
                }
            }
        }
        return count;
    }

    public void bfs(int x, int y) {
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        deque.offer(new int[]{x, y});
        while (!deque.isEmpty()) {
            int[] curr = deque.poll();
            for (int[] dir : dirs) {
                int nextX = curr[0] + dir[0];
                int nextY = curr[1] + dir[1];
                if (!isValid(nextX, nextY) || grid[nextX][nextY] != '1') continue;
                grid[nextX][nextY] = '2';
                deque.offer(new int[]{nextX, nextY});
            }
        }
    }


    public boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < grid.length && y < grid[0].length;
    }
}
