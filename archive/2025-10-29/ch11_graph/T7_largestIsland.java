package org.review2025autumn.ch11_graph;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/12/2 16:03
 * @comment
 */
public class T7_largestIsland {
    int[][] grid;
    int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    int area = 0;

    public int largestIsland(int[][] grid) {
        this.grid = grid;
        int n = grid.length;
        int m = grid[0].length;
        int mark = 2;
        boolean isAllLand = true;
        HashMap<Integer, Integer> map = new HashMap<>();

        // 染色
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    area = 0;
                    dfs(i, j, mark);
                    map.put(mark, area);
                    mark++;
                } else if (grid[i][j] == 0) {
                    isAllLand = false;
                }
            }
        }
        if (isAllLand) return n * m;

        // 连接
        int result = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    int sum = 1;
                    for (int[] dir : dirs) {
                        int nextI = i + dir[0];
                        int nextJ = j + dir[1];
                        if (!isValid(nextI, nextJ)) continue;
                        int landMark = grid[nextI][nextJ];
                        if (landMark == 0 || set.contains(landMark)) continue;
                        sum += map.get(landMark);
                        set.add(landMark);
                    }
                    result = Math.max(result, sum);
                    set.clear();
                }
            }
        }


        return result;
    }

    public void dfs(int x, int y, int mark) {
        if (!isValid(x, y) || grid[x][y] != 1)
            return;
        grid[x][y] = mark;
        area++;
        for (int[] dir : dirs) {
            dfs(x + dir[0], y + dir[1], mark);
        }
    }

    public boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < grid.length && y < grid[0].length;
    }
}
