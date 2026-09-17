package org.learn2024winter.dp;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/11/24 00:15
 * @comment
 */
public class T24_maxProfit {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int[][] dp = new int[len][4];
        // 0:firstHold 1:firstNotHold 2:secondHold 3:secondNotHold
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        dp[0][2] = -prices[0];
        dp[0][3] = 0;

        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] - prices[i]);
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] + prices[i]);
        }
        return dp[len - 1][3];
    }

    public int maxProfit2(int[] prices) {
        int len = prices.length;
        int curr1Hold = -prices[0], curr2Hold = -prices[0];
        int curr1NotHold = 0, curr2NotHold = 0;

        for (int i = 1; i < len; i++) {
            int pre1Hold = curr1Hold, pre2Hold = curr2Hold,
                    pre1NotHold = curr1NotHold, pre2NotHold = curr2NotHold;
            curr1Hold = Math.max(pre1Hold, -prices[i]);
            curr1NotHold = Math.max(pre1NotHold, pre1Hold + prices[i]);
            curr2Hold = Math.max(pre2Hold, pre1NotHold - prices[i]);
            curr2NotHold = Math.max(pre2NotHold, pre2Hold + prices[i]);
        }
        return curr2NotHold;
    }

    public int maxProfit3(int[] prices) {
        int len = prices.length;
        int[][] dp = new int[len][4];
        // 0:firstHold 1:firstNotHold 2:secondHold 3:secondNotHold
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        dp[0][2] = -prices[0];
        dp[0][3] = 0;
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] - prices[i]);
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] + prices[i]);
        }
        return dp[len - 1][3];
    }

    public int maxProfit4(int[] prices) {
        int len = prices.length;
        int[] dp = new int[4];
        // 0:firstHold 1:firstNotHold 2:secondHold 3:secondNotHold
        dp[0] = dp[2] = -prices[0];
        for (int i = 1; i < len; i++) {
            dp[0] = Math.max(dp[0], -prices[i]);
            dp[1] = Math.max(dp[1], dp[0] + prices[i]);
            dp[2] = Math.max(dp[2], dp[1] - prices[i]);
            dp[3] = Math.max(dp[3], dp[2] + prices[i]);
        }
        return dp[3];
    }
}
























