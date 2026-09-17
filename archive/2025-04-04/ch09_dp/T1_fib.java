package org.review2025spring.ch09_dp;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/11/20 14:41
 * @comment
 */
public class T1_fib {
    public int fib(int n) {
        if (n <= 1) return n;
        int[] dp = {0, 1};
        for (int i = 2; i <= n; i++) {
            dp[i % 2] = dp[(i - 1) % 2] + dp[(i - 2) % 2];
        }
        return dp[n % 2];
    }
}
