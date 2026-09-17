package org.learn2024winter.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/12/2 09:21
 * @comment
 */
public class T1_allPathsSourceTarget {
    int[][] graph;
    int n;
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new LinkedList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        this.graph = graph;
        this.n = graph.length - 1;
        path.add(0);
        dfs(0);
        return result;
    }

    public void dfs(int x) {
        if (x == n) {
            result.add(new LinkedList<>(path));
            return;
        }
        for (int i : graph[x]) {
            path.add(i);
            dfs(i);
            path.remove(path.size() - 1);
        }
    }
}