package org.learn2024winter.graph;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/12/2 16:03
 * @comment
 */
public class T7_createIsland_v2 {
    int[][] grid;
    int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    int count;
    int mark = 1;

    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        this.grid = grid;
        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        boolean isAllGrid = true;

        // 染色部分
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0)
                    isAllGrid = false;
                if (grid[i][j] == 1) {
                    mark++;
                    count = 0;
                    dfs(i, j);
                    map.put(mark, count);
                }
            }
        }
        if (isAllGrid)
            return n * m;

        // 人工岛连接部分
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    count = 1;
                    for (int[] dir : dirs) {
                        int nextI = i + dir[0];
                        int nextJ = j + dir[1];
                        if (!isValid(nextI, nextJ))
                            continue;
                        int mark = grid[nextI][nextJ];
                        if (set.contains(mark) || mark == 0)
                            continue;
                        set.add(mark);
                        count += map.get(mark);
                    }
                    set.clear();
                    result = Math.max(result, count);
                }
            }
        }

        return result;
    }

    public void dfs(int x, int y) {
        if (!isValid(x, y) || grid[x][y] != 1)
            return;
        grid[x][y] = mark;
        count++;
        for (int[] dir : dirs) {
            dfs(x + dir[0], y + dir[1]);
        }
    }

    public boolean isValid(int x, int y) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length;
    }
}
