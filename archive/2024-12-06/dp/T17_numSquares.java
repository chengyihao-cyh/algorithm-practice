package org.review2024winter.dp;

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
        Arrays.fill(dp, 1, n + 1, INF);
        for (int j = 0; j < n + 1; j++) {
            for (int i = 1; i * i <= j; i++) {
                dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
            }
        }
        return dp[n] == INF ? -1 : dp[n];
    }
}
