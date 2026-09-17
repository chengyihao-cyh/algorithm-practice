package org.learn2024winter.graph;

import java.util.ArrayList;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/12/3 16:27
 * @comment
 */
public class T13_findRedundantDirectedConnection {

    public int[] findRedundantDirectedConnection(int[][] edges) {
        // 记录每个节点的入度
        int n = edges.length;
        int[] inDegree = new int[n + 1];
        for (int[] edge : edges) {
            inDegree[edge[1]]++;
        }

        // 记录指向入度为 2 的节点 的两条入边
        ArrayList<Integer> delIdxList = new ArrayList<>();
        for (int idx = n - 1; idx >= 0; idx--) {
            if (inDegree[edges[idx][1]] == 2) {
                delIdxList.add(idx);
            }
        }

        // delIdx 记录待删除的边在 edges 中的编号
        int delIdx = -1;
        if (!delIdxList.isEmpty()) {
            // 情况 12: 存在入度为 2 的节点
            for (Integer idx : delIdxList) {
                delIdx = idx;
                if (isTreeAfterRemove(edges, idx)) {
                    break;
                }
            }
        } else {
            // 情况 3: 不存在入度为 2 的节点
            delIdx = getRemoveEdge(edges);
        }

        return edges[delIdx];
    }


    public boolean isTreeAfterRemove(int[][] edges, int delIdx) {
        UnionFind unionFind = new UnionFind(edges.length + 1);
        for (int i = 0; i < edges.length; i++) {
            if (i == delIdx) continue;
            if (!unionFind.union(edges[i][0], edges[i][1]))
                return false;
        }
        return true;
    }

    public int getRemoveEdge(int[][] edges) {
        UnionFind unionFind = new UnionFind(edges.length + 1);
        for (int i = 0; i < edges.length; i++) {
            if (!unionFind.union(edges[i][0], edges[i][1]))
                return i;
        }
        return -1;
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
