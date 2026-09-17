package org.review2024winter.graph;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/12/3 15:56
 * @comment
 */
public class T12_findRedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        UnionFind unionFind = new UnionFind(n + 1);

        int[] res = edges[0];
        for (int[] edge : edges) {
            res = edge;
            if (!unionFind.union(edge[0], edge[1])) {
                break;
            }
        }

        return res;
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
