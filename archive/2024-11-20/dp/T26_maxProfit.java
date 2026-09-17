package org.learn2024winter.dp;

import java.util.Arrays;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/11/24 19:05
 * @comment
 */
public class T26_maxProfit {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int[][] dp = new int[len][4];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        dp[0][2] = 0;
        dp[0][3] = 0;
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][2], dp[i - 1][3]) - prices[i]);
            dp[i][1] = dp[i - 1][0] + prices[i];
            dp[i][2] = dp[i - 1][1];
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2]);
        }
        return Math.max(dp[len - 1][1], Math.max(dp[len - 1][2], dp[len - 1][3]));
    }

    public int maxProfit2(int[] prices) {
        int len = prices.length;
        int[] dp = new int[4];
        dp[0] = -prices[0];
        dp[1] = 0;
        dp[2] = 0;
        dp[3] = 0;
        for (int i = 1; i < len; i++) {
            int[] tmp = {dp[0], dp[1], dp[2], dp[3]};
            dp[0] = Math.max(tmp[0], Math.max(tmp[2], tmp[3]) - prices[i]);
            dp[1] = tmp[0] + prices[i];
            dp[2] = tmp[1];
            dp[3] = Math.max(tmp[3], tmp[2]);
        }
        return Math.max(dp[1], Math.max(dp[2], dp[3]));
    }

    public int maxProfit3(int[] prices) {
        int len = prices.length;
        int[][] dp = new int[2][4];
        dp[0][0] = -prices[0];
        for (int i = 1; i < len; i++) {
            dp[i % 2][0] = Math.max(dp[(i - 1) % 2][0], Math.max(dp[(i - 1) % 2][2], dp[(i - 1) % 2][3]) - prices[i]);
            dp[i % 2][1] = dp[(i - 1) % 2][0] + prices[i];
            dp[i % 2][2] = dp[(i - 1) % 2][1];
            dp[i % 2][3] = Math.max(dp[(i - 1) % 2][2], dp[(i - 1) % 2][3]);
        }
        return Math.max(dp[(len - 1) % 2][1], Math.max(dp[(len - 1) % 2][2], dp[(len - 1) % 2][3]));
    }
}
