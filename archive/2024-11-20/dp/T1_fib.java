package org.learn2024winter.dp;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/11/20 14:41
 * @comment
 */
public class T1_fib {
    public int fib(int n) {
        if (n == 0 || n == 1)
            return n;
        int[] dp = new int[]{0, 1};
        int sum = 1;
        for (int i = 2; i <= n; i++) {
            sum = dp[0] + dp[1];
            dp[0] = dp[1];
            dp[1] = sum;
        }
        return sum;
    }
}
