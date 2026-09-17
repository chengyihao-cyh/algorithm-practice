package org.learn2024winter.dp;

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
        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        // Arrays.fill(dp, 1, dp.length, Integer.MAX_VALUE);

        for (int i = 0; i * i <= n; i ++) {
            for (int j = i * i; j <= n; j++) {
                if (dp[j - i * i] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
                }
            }
        }

        return dp[n] == Integer.MAX_VALUE ? -1 : dp[n];
    }
}
