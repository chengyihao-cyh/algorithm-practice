package org.learn2024winter.dp;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/11/22 21:47
 * @comment
 */
public class T15_climbStairsPlus {
    public int climbStairsPlus(int n, int m) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int j = 1; j <= n; j++) {
            for (int i = 1; i <= m; i++) {
                if (j >= i)
                    dp[j] += dp[j - i];
            }
        }
        return dp[n];
    }
}
