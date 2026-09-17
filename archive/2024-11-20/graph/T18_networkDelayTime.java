package org.learn2024winter.graph;

import java.util.*;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/12/4 16:55
 * @comment
 */
public class T18_networkDelayTime {
    public int networkDelayTime(int[][] times, int n, int k) {
        // 初始化
        int[][] graph = new int[n + 1][n + 1];
        int[] minDist = new int[n + 1];
        boolean[] visited = new boolean[n + 1];

        for (int[] line : graph) {
            Arrays.fill(line, Integer.MAX_VALUE);
        }
        Arrays.fill(minDist, 1, minDist.length, Integer.MAX_VALUE);

        for (int[] time : times) {
            graph[time[0]][time[1]] = time[2];
        }

        // 访问所有节点 需要 n 轮
        minDist[k] = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            int curr = -1;
            int minVal = Integer.MAX_VALUE;
            for (int j = 1; j <= n; j++) {
                if (!visited[j] && minDist[j] < minVal) {
                    curr = j;
                    minVal = minDist[j];
                }
            }

            if (curr == -1) return -1; // n 个节点还未全部访问 就已选不出最小节点 说明有节点不可达

            visited[curr] = true;   // 访问该节点
            res = Math.max(res, minDist[curr]);

            for (int j = 1; j <= n; j++) {
                if (!visited[j] && graph[curr][j] != Integer.MAX_VALUE && minDist[curr] + graph[curr][j] < minDist[j]) {
                    minDist[j] = minDist[curr] + graph[curr][j];
                }
            }
        }

        return res;
    }


    public int networkDelayTime_2(int[][] times, int n, int k) {
        // int[2]: to, cost

        // create graph
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new LinkedList<>());
        }
        for (int[] time : times) {
            graph.get(time[0]).add(new int[]{time[1], time[2]});
        }

        // init
        int[] minDist = new int[n + 1];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        minDist[k] = 0;
        boolean[] visited = new boolean[n + 1];

        // add start element k
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
        queue.offer(new int[]{k, 0});

        int res = 0;
        while (!queue.isEmpty()) {
            // get min cost edge that its element not be visited
            int[] curr = queue.poll();
            if (visited[curr[0]])
                continue;
            // visit this point
            visited[curr[0]] = true;
            res = Math.max(res, curr[1]);
            int currCost = curr[1];
            // relax this point's neighbor
            for (int[] neighbor : graph.get(curr[0])) {
                if (!visited[neighbor[0]] && currCost + neighbor[1] < minDist[neighbor[0]]) {
                    minDist[neighbor[0]] = currCost + neighbor[1];
                    // add to queue
                    queue.offer(new int[]{neighbor[0], minDist[neighbor[0]]});
                }
            }
        }

        // there are unreachable elements
        for (int i = 1; i <= n; i++) {
            if (!visited[i])
                return -1;
        }
        return res;
    }
}



























