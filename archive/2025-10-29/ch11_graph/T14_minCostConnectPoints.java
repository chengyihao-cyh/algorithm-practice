package org.review2025autumn.ch11_graph;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/12/3 19:30
 * @comment
 */
public class T14_minCostConnectPoints {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        final int INF = 0x3f3f3f3f;
        int[] minDist = new int[n];
        int cal;
        boolean[] visited = new boolean[n];
        Arrays.fill(minDist, 1, n, INF);

        for (int i = 0; i < n; i++) {
            int minVal = INF;
            int curr = -1;
            for (int j = 0; j < n; j++) {
                if (!visited[j] && minDist[j] < minVal) {
                    minVal = minDist[j];
                    curr = j;
                }
            }

            visited[curr] = true;
            for (int j = 0; j < n; j++) {
                if (!visited[j] && (cal = calDist(points[curr], points[j])) < minDist[j]) {
                    minDist[j] = cal;
                }
            }
        }

        return Arrays.stream(minDist).sum();
    }

    public int calDist(int[] point1, int[] point2) {
        return Math.abs(point1[0] - point2[0]) + Math.abs(point1[1] - point2[1]);
    }


    public int prim(int[][] graph) {
        int n = graph.length;
        int INF = 0x3f3f3f3f;
        boolean[] isVisited = new boolean[n];
        int[] minDist = new int[n];
        Arrays.fill(minDist, 0, n, INF);

        for (int i = 0; i < n; i++) {
            int minVal = INF;
            int curr = -1;
            for (int j = 0; j < n; j++) {
                if (!isVisited[j] && minDist[j] < minVal) {
                    minVal = minDist[j];
                    curr = j;
                }
            }
            if (curr == -1) return -1;

            isVisited[curr] = true;
            for (int j = 0; j < n; j++) {
                if (!isVisited[j] && graph[curr][j] < minDist[j])
                    minDist[j] = graph[curr][j];
            }
        }

        return Arrays.stream(minDist).sum();
    }

    public int kruskal(int[][] edges, int n) {
        Arrays.sort(edges, (a, b) -> a[2] - b[2]);
        ArrayList<int[]> tree = new ArrayList<>();

        UnionFind unionFind = new UnionFind(edges.length);
        for (int i = 0; i < edges.length && tree.size() < n; i++) {
            if (unionFind.union(edges[i][0], edges[i][1])) {
                tree.add(edges[i]);
            }
        }

        return tree.stream().mapToInt(a -> a[2]).sum();
    }

    class UnionFind {
        int[] parent;

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if (parent[x] == x) return x;
            return parent[x] = find(parent[x]);
        }

        public boolean union(int x, int y) {
            int xRoot = find(x), yRoot = find(y);
            if (xRoot == yRoot) return false;
            parent[yRoot] = xRoot;
            return true;
        }

        public boolean isSame(int x, int y) {
            return find(x) == find(y);
        }
    }
}
























