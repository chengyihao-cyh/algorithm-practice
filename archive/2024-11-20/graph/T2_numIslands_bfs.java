package org.learn2024winter.graph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/12/2 10:35
 * @comment
 */
public class T2_numIslands_bfs {
    int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    char[][] grid;
    boolean[][] visited;

    public int numIslands(char[][] grid) {
        this.grid = grid;
        this.visited = new boolean[grid.length][grid[0].length];
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    result++;
                    visited[i][j] = true;
                    bfs(i, j);
                }
            }
        }
        return result;
    }

    public void bfs(int x, int y) {
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{x, y});
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int currX = curr[0];
            int currY = curr[1];
            for (int[] dir : dirs) {
                int nextX = currX + dir[0];
                int nextY = currY + dir[1];
                if (nextX < 0 || nextX >= grid.length || nextY < 0 || nextY >= grid[0].length)
                    continue;
                if (grid[nextX][nextY] == '1' && !visited[nextX][nextY]) {
                    visited[nextX][nextY] = true;
                    queue.offer(new int[]{nextX, nextY});
                }
            }
        }
    }
}
