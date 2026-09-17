package org.learn2024winter.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/12/3 19:30
 * @comment
 */
public class T14_minCostConnectPoints {
    public int prim(int[][] grid) {
        int n = grid.length;
        boolean[] isInTree = new boolean[n];
        int[] minDist = new int[n];
        int[] parent = new int[n];
        Arrays.fill(minDist, 1, n, Integer.MAX_VALUE);

        for (int i = 0; i < n; i++) {
            int currNode = -1;
            int minCost = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if (!isInTree[j] && minDist[j] < minCost) {

                    currNode = j;
                    minCost = minDist[j];
                }
            }

            isInTree[currNode] = true;

            for (int j = 0; j < n; j++) {
                if (!isInTree[j] && grid[currNode][j] < minDist[j]) {
                    minDist[j] = grid[currNode][j];
                    parent[j] = currNode;
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += minDist[i];
        }
        return sum;
    }

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int[] minDist = new int[n];
        boolean[] isInTree = new boolean[n];
        int[] parent = new int[n];
        parent[0] = -1;
        Arrays.fill(minDist, 1, n, Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) {
            int minVal = Integer.MAX_VALUE;
            int currNode = -1;
            for (int j = 0; j < n; j++) {
                if (!isInTree[j] && minDist[j] < minVal) {
                    minVal = minDist[j];
                    currNode = j;
                }
            }
            isInTree[currNode] = true;
            for (int j = 0; j < n; j++) {
                if (!isInTree[j]) {
                    minDist[j] = Math.min(minDist[j], calculateDist(points[currNode], points[j]));
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += minDist[i];
        }
        return sum;
    }

    public int calculateDist(int[] point1, int[] point2) {
        return Math.abs(point1[0] - point2[0]) + Math.abs(point1[1] - point2[1]);
    }

    public int kruskal(int n, int[][] edges) {
        Arrays.sort(edges, (a, b) -> a[2] - b[2]);
        UnionFind unionFind = new UnionFind(n);
        ArrayList<int[]> tree = new ArrayList<>();
        for (int i = 0; i < edges.length && tree.size() < n - 1; i++) {
            if (unionFind.union(edges[i][0], edges[i][1])) {
                tree.add(edges[i]);
            }
        }

        int sum = 0;
        for (int[] e : tree) {
            sum += e[2];
        }
        return sum;
    }

    class UnionFind {
        int[] parent;

        public UnionFind(int n) {
            this.parent = new int[n];
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
    }

}
























