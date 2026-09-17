package org.review2025autumn.ch11_graph;

import java.util.ArrayDeque;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/12/4 15:04
 * @comment
 */
public class T16_orangesRotting {
    int[][] grid;
    int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int orangesRotting(int[][] grid) {
        this.grid = grid;
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        int lastFresh = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    deque.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    lastFresh++;
                }
            }
        }
        if (lastFresh == 0) return 0;

        int round = 0;
        while (!deque.isEmpty() && lastFresh > 0) {
            round++;
            int size = deque.size();
            while (size-- > 0) {
                int[] curr = deque.poll();
                for (int[] dir : dirs) {
                    int nextX = curr[0] + dir[0];
                    int nextY = curr[1] + dir[1];
                    if (!isValid(nextX, nextY) || grid[nextX][nextY] != 1)
                        continue;
                    grid[nextX][nextY] = 2;
                    lastFresh--;
                    deque.offer(new int[]{nextX, nextY});
                }
            }
        }

        return lastFresh == 0 ? round : -1;
    }

    public boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < grid.length && y < grid[0].length;
    }
}
