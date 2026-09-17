package org.review2025springAgain.ch09_dp;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/11/20 15:10
 * @comment
 */
public class T2_climbStairs {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
