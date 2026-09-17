package org.review2025spring.ch09_dp;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/11/22 21:21
 * @comment
 */
public class T17_numSquares {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        int INF = 0x3f3f3f3f;
        Arrays.fill(dp, 1, dp.length, INF);
        for (int i = 1; i * i < n; i++) {
            for (int j = i * i; j <= n; j++) {
                dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
            }
        }
        return dp[n] > INF ? -1 : dp[n];
    }
}
