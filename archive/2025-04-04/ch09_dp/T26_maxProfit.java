package org.review2025spring.ch09_dp;

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

        for (int i = 1; i < len; i++) {
            int[] tmp = dp.clone();
            dp[0] = Math.max(tmp[0], Math.max(tmp[2], tmp[3]) - prices[i]);
            dp[1] = tmp[0] + prices[i];
            dp[2] = tmp[1];
            dp[3] = Math.max(tmp[2], tmp[3]);
        }
        return Math.max(dp[1], Math.max(dp[2], dp[3]));
    }

}
