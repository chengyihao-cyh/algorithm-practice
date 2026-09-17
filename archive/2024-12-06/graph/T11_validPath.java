package org.review2024winter.graph;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/12/3 15:34
 * @comment
 */
public class T11_validPath {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        UnionFind unionFind = new UnionFind(n);
        for (int[] edge : edges) {
            unionFind.union(edge[0], edge[1]);
        }

        return unionFind.isSame(source, destination);
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