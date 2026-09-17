package org.review2024winter.dp;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/11/20 15:10
 * @comment
 */
public class T2_climbStairs {
    public int climbStairs(int n) {
        if (n <= 1) return n;
        int[] dp = new int[]{1, 1};
        for (int i = 2; i < n + 1; i++) {
            dp[i % 2] = dp[(i - 1) % 2] + dp[(i - 2) % 2];
        }
        return dp[n % 2];
    }
}
