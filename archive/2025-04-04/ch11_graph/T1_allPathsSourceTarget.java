package org.review2025spring.ch11_graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/12/2 09:21
 * @comment
 */
public class T1_allPathsSourceTarget {
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();
    int[][] graph;

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length - 1;
        this.graph = graph;
        path.add(0);
        dfs(0, n);
        return result;
    }

    public void dfs(int curr, int end) {
        if (curr == end) {
            result.add(new ArrayList<>(path));
        }
        for (int next : graph[curr]) {
            path.add(next);
            dfs(next, end);
            path.remove(path.size() - 1);
        }
    }
}