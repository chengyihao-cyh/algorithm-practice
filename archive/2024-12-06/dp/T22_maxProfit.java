package org.review2024winter.dp;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/11/23 23:22
 * @comment
 */
public class T22_maxProfit {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        // 0 持有
        // 1 不持有
        int[] dp = new int[2];
        dp[0] = -prices[0];
        dp[1] = 0;
        for (int i = 1; i < len; i++) {
            dp[0] = Math.max(dp[0], -prices[i]);
            dp[1] = Math.max(dp[1], dp[0] + prices[i]);
        }
        return dp[1];
    }
}
