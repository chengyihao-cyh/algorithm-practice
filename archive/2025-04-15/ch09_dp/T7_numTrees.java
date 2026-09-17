package org.review2025springAgain.ch09_dp;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/11/21 16:36
 * @comment
 */
public class T7_numTrees {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                // j - 1
                // n - j
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
