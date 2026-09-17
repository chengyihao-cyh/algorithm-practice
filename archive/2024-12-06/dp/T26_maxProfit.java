package org.review2024winter.dp;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/11/24 19:05
 * @comment
 */
public class T26_maxProfit {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int[] dp = new int[4];
        dp[0] = -prices[0];
        dp[1] = dp[2] = dp[3] = 0;
        for (int i = 1; i < len; i++) {
            int[] preDp = dp.clone();
            dp[0] = Math.max(preDp[0], Math.max(preDp[2], preDp[3]) - prices[i]);
            dp[1] = preDp[0] + prices[i];
            dp[2] = preDp[1];
            dp[3] = Math.max(preDp[3], preDp[2]);
        }
        return Math.max(dp[1], Math.max(dp[2], dp[3]));
    }
}
