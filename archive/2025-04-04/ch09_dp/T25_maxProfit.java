package org.review2025spring.ch09_dp;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/11/24 18:20
 * @comment
 */
public class T25_maxProfit {
    public int maxProfit(int k, int[] prices) {
        int[] dp = new int[2 * k + 1];
        for (int i = 0; i < k; i++) dp[2 * i + 1] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            // 第 j 次持有   2j+1
            // 第 j 次不持有  2j+2
            for (int j = 0; j < k; j++) {
                dp[2 * j + 1] = Math.max(dp[2 * j + 1], dp[2 * j] - prices[i]);
                dp[2 * j + 2] = Math.max(dp[2 * j + 2], dp[2 * j + 1] + prices[i]);
            }
        }
        return dp[2 * k];
    }
}
