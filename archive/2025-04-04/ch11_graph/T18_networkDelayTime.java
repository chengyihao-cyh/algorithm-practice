package org.review2025spring.ch11_graph;

import java.util.*;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/12/4 16:55
 * @comment
 */
public class T18_networkDelayTime {
    public int networkDelayTime(int[][] times, int n, int k) {
        int INF = 0x3f3f3f3f;
        List<List<int[]>> graph = new ArrayList<>(n + 1);
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        for (int i = 0; i < n + 1; i++) {
            graph.add(new LinkedList<>());
        }
        for (int[] time : times) {
            graph.get(time[0]).add(new int[]{time[1], time[2]});
        }

        int[] minDist = new int[n + 1];
        Arrays.fill(minDist, 1, n + 1, INF);
        minDist[k] = 0;
        boolean[] visited = new boolean[n + 1];
        queue.offer(new int[]{k, 0});

        int res = 0;
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int to = curr[0], currCost = curr[1];
            if (visited[to]) continue;
            visited[to] = true;
            res = Math.max(res, minDist[to]);
            for (int[] next : graph.get(to)) {
                if (visited[next[0]]) continue;
                minDist[next[0]] = Math.min(minDist[next[0]], currCost + next[1]);
                queue.offer(new int[]{next[0], minDist[next[0]]});
            }
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i])
                return -1;
        }
        return res;
    }
}



























