package org.learn2024winter.graph;

import java.util.ArrayDeque;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/12/4 15:04
 * @comment
 */
public class T16_orangesRotting {
    int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int orangesRotting(int[][] grid) {
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        int countFresh = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    deque.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    countFresh++;
                }
            }
        }

        int round = 0;
        while (!deque.isEmpty() && countFresh > 0) {
            round++;
            int size = deque.size();
            while (size-- > 0) {
                int[] curr = deque.poll();
                for (int[] dir : dirs) {
                    int nextX = curr[0] + dir[0];
                    int nextY = curr[1] + dir[1];
                    if (nextX < 0 || nextY < 0 || nextX >= grid.length || nextY >= grid[0].length)
                        continue;
                    if (grid[nextX][nextY] == 1) {
                        grid[nextX][nextY] = 2;
                        countFresh--;
                        deque.offer(new int[]{nextX, nextY});
                    }
                }
            }
        }

        if (countFresh > 0) {
            return -1;
        } else {
            return round;
        }
    }

}
