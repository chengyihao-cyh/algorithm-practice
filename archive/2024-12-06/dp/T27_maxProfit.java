package org.review2024winter.dp;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/11/24 22:02
 * @comment
 */
public class T27_maxProfit {
    public int maxProfit(int[] prices, int fee) {
        int[] dp = new int[2];
        dp[0] = -prices[0];
        for (int i = 0; i < prices.length; i++) {
            dp[0] = Math.max(dp[0], dp[1] - prices[i]);
            dp[1] = Math.max(dp[1], dp[0] + prices[i] - fee);
        }
        return dp[1];
    }
}
