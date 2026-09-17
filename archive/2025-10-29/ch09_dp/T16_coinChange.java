package org.review2025autumn.ch09_dp;

import java.util.Arrays;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/11/22 20:51
 * @comment
 */
public class T16_coinChange {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        final int INF = 0x3f3f3f3f;
        Arrays.fill(dp, 1, amount + 1, INF);
        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                dp[j] = Math.min(dp[j], dp[j - coin] + 1);
            }
        }
        return dp[amount] < INF ? dp[amount] : -1;
    }
}
