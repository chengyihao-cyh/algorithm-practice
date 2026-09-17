package org.learn2024winter.dp;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/11/24 18:20
 * @comment
 */
public class T25_maxProfit {
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        int[][] dp = new int[len][2 * k];
        // 初始化 只对持有状态
        for (int j = 0; j < k; j++) {
            dp[0][2 * j] = -prices[0];
        }

        // 递推
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);

            for (int j = 1; j < k; j++) {
                dp[i][2 * j] = Math.max(dp[i - 1][2 * j], dp[i - 1][2 * j - 1] - prices[i]);
                dp[i][2 * j + 1] = Math.max(dp[i - 1][2 * j + 1], dp[i - 1][2 * j] + prices[i]);
            }
        }
        return dp[len - 1][2 * k - 1];
    }

    public int maxProfit2(int k, int[] prices) {
        int len = prices.length;
        int[] dp = new int[2 * k];
        // 初始化 只对持有状态
        for (int j = 0; j < k; j++) {
            dp[2 * j] = -prices[0];
        }
        // 递推
        for (int i = 1; i < len; i++) {
            dp[0] = Math.max(dp[0], -prices[i]);
            dp[1] = Math.max(dp[1], dp[0] + prices[i]);

            for (int j = 1; j < k; j++) {
                dp[2 * j] = Math.max(dp[2 * j], dp[2 * j - 1] - prices[i]);
                dp[2 * j + 1] = Math.max(dp[2 * j + 1], dp[2 * j] + prices[i]);
            }
        }
        return dp[2 * k - 1];
    }
}
