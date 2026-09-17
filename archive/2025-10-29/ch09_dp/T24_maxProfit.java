package org.review2025autumn.ch09_dp;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/11/24 00:15
 * @comment
 */
public class T24_maxProfit {
    public int maxProfit(int[] prices) {
        int[] dp = new int[4];
        dp[0] = dp[2] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[0] = Math.max(dp[0], -prices[i]);
            dp[1] = Math.max(dp[1], dp[0] + prices[i]);
            dp[2] = Math.max(dp[2], dp[1] - prices[i]);
            dp[3] = Math.max(dp[3], dp[2] + prices[i]);
        }
        return dp[3];
    }
}
























