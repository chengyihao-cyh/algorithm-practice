package org.review2025autumn.ch11_graph;

import java.util.Arrays;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/12/5 16:51
 * @comment
 */
public class T19_findCheapestPrice {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int INF = 0x3f3f3f3f;
        int from, to, cost;
        int[][] minDist = new int[2][n];
        for (int i = 0; i < 2; i++) {
            Arrays.fill(minDist[i], INF);
        }
        minDist[0][src] = 0;
        minDist[1][src] = 0;

        for (int i = 1; i <= k + 1; i++) {
            for (int[] flight : flights) {
                from = flight[0];
                to = flight[1];
                cost = flight[2];
                minDist[i % 2][to] = Math.min(minDist[i % 2][to], minDist[(i - 1) % 2][from] + cost);
            }
        }

        return minDist[(k + 1) % 2][dst] != INF ? minDist[(k + 1) % 2][dst] : -1;
    }
}




























