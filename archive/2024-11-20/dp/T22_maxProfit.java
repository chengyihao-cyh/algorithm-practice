package org.learn2024winter.dp;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/11/23 23:22
 * @comment
 */
public class T22_maxProfit {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int[][] dp = new int[len][2];
        dp[0][0] = -1 * prices[0];
        dp[0][1] = 0;

        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], -1 * prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }
        return dp[len - 1][1];
    }

    public int maxProfit2(int[] prices) {
        int len = prices.length;
        int currHold = -1 * prices[0];
        int currNotHold = 0;

        for (int i = 1; i < len; i++) {
            int preHold = currHold;
            int preNotHold = currNotHold;
            currHold = Math.max(preHold, -1 * prices[i]);
            currNotHold = Math.max(preNotHold, preHold + prices[i]);
        }
        return currNotHold;
    }

    public int maxProfit3(int[] prices) {
        int len = prices.length;
        int[] dp = new int[2];
        dp[0] = -prices[0];
        dp[1] = 0;
        for (int i = 1; i < len; i++) {
            int[] tmp = new int[]{dp[0], dp[1]};
            dp[0] = Math.max(tmp[0], -prices[i]);
            dp[1] = Math.max(tmp[1], tmp[0] + prices[i]);
        }
        return dp[1];
    }
}
