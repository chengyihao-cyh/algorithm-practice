package org.learn2024winter.graph;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/12/2 16:03
 * @comment
 */
public class T7_createIsland {
    int[][] grid;
    boolean[][] visited;
    int count;
    int mark = 2;
    int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        this.grid = grid;
        this.visited = new boolean[n][m];
        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        boolean isAllGrid = true;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0)
                    isAllGrid = false;
                if (!visited[i][j] && grid[i][j] == 1) {
                    count = 0;
                    dfs(i, j);
                    map.put(mark, count);
                    mark++;
                }
            }
        }

        if (isAllGrid)
            return n * m;

        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    int count = 1;
                    for (int[] dir : dirs) {
                        int nearI = i + dir[0];
                        int nearJ = j + dir[1];
                        if (nearI < 0 || nearJ < 0 || nearI >= n || nearJ >= m)
                            continue;
                        if (grid[nearI][nearJ] != 0 && !set.contains(grid[nearI][nearJ])) {
                            count += map.get(grid[nearI][nearJ]);
                            set.add(grid[nearI][nearJ]);
                        }
                    }
                    set.clear();
                    result = Math.max(result, count);
                }
            }
        }


        return result;
    }

    public void dfs(int x, int y) {
        count++;
        grid[x][y] = mark;
        visited[x][y] = true;
        for (int[] dir : dirs) {
            int nextX = x + dir[0];
            int nextY = y + dir[1];
            if (nextX < 0 || nextX >= grid.length || nextY < 0 || nextY >= grid[0].length)
                continue;
            if (!visited[nextX][nextY] && grid[nextX][nextY] == 1)
                dfs(nextX, nextY);
        }
    }

}
