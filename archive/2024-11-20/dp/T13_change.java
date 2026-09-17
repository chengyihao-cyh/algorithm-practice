package org.learn2024winter.dp;

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
        for (int j = 0; j <= amount; j++) {
            for (int i = 0; i < coins.length; i++) {
                if (j >= coins[i])
                    dp[j] += dp[j - coins[i]];
            }
        }
        return dp[amount];
    }
}
