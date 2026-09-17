package org.review2025spring.ch11_graph;

import java.util.ArrayList;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/12/3 16:27
 * @comment
 */
public class T13_findRedundantDirectedConnection {

    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        int[] inDegree = new int[n + 1];

        for (int[] edge : edges) {
            inDegree[edge[1]]++;
        }

        ArrayList<Integer> delIdxList = new ArrayList<>();
        for (int i = n - 1; i >= 0; i--) {
            if (inDegree[edges[i][1]] == 2) {
                delIdxList.add(i);
            }
        }

        if (delIdxList.size() == 2) {
            if (check_hasDim2(edges, delIdxList.get(0))) return edges[delIdxList.get(0)];
            else return edges[delIdxList.get(1)];
        } else {
            return check_notHasDim2(edges);
        }
    }

    public boolean check_hasDim2(int[][] edges, int delIdx) {
        UnionFind unionFind = new UnionFind(edges.length + 1);
        for (int i = 0; i < edges.length; i++) {
            if (i == delIdx) continue;
            if (!unionFind.union(edges[i][0], edges[i][1])) {
                return false;
            }
        }
        return true;
    }

    public int[] check_notHasDim2(int[][] edges) {
        UnionFind unionFind = new UnionFind(edges.length + 1);
        for (int[] edge : edges) {
            if (!unionFind.union(edge[0], edge[1])) {
                return edge;
            }
        }
        return new int[2];
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
