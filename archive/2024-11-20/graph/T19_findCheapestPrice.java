package org.learn2024winter.graph;

import java.util.*;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/12/5 16:51
 * @comment
 */
public class T19_findCheapestPrice {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] minDist = new int[n];
        final int INF = 0x3f3f3f3f;

        Arrays.fill(minDist, INF);
        minDist[src] = 0;
        // 松弛 k + 1 次
        for (int i = 0; i < k + 1; i++) {
            int[] clone = minDist.clone();  // 上一轮的
            for (int[] flight : flights) {
                int from = flight[0];
                int to = flight[1];
                int cost = flight[2];
                if (clone[from] + cost < minDist[to]) {
                    minDist[to] = clone[from] + cost;
                }
            }
        }

        return minDist[dst] != INF ? minDist[dst] : -1;
    }

    public int findCheapestPrice_2(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> graph = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            graph.add(new LinkedList<>());
        }
        for (int[] flight : flights) {
            graph.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.offer(src);

        int INF = 0x3f3f3f3f;
        int[] minDist = new int[n];
        Arrays.fill(minDist, INF);
        minDist[src] = 0;
        boolean[] isInQue = new boolean[n];

        int count = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            count++;
            Integer from = deque.poll();
            isInQue[from] = false;
            for (int[] neighbor : graph.get(from)) {
                int to = neighbor[0];
                int cost = neighbor[1];
                if (minDist[from] + cost < minDist[to]) {
                    minDist[to] = minDist[from] + cost;
                    if (!isInQue[to]) {
                        isInQue[to] = true;
                        deque.offer(to);
                    }
                }
            }
        }

        return minDist[dst] != INF ? minDist[dst] : -1;
    }
}




























