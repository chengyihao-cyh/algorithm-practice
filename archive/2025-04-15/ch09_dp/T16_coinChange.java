package org.review2025springAgain.ch09_dp;

import java.util.Arrays;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/11/22 20:51
 * @comment
 */
public class T16_coinChange {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        int INF = 0x3f3f3f3f;
        Arrays.fill(dp, 1, dp.length, INF);

        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
            }
        }
        return dp[amount] >= INF ? -1 : dp[amount];
    }
}
