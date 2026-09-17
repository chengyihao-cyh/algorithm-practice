package org.review2024winter.dp;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/11/22 19:51
 * @comment
 */
public class T13_change {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[amount];
    }
}
