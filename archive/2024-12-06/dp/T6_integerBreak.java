package org.review2024winter.dp;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/11/20 23:47
 * @comment
 */
public class T6_integerBreak {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i < n + 1; i++) {
            for (int j = 1; j <= i / 2; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }
}
