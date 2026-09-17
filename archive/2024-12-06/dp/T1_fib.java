package org.review2024winter.dp;

import java.util.Arrays;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/11/20 14:41
 * @comment
 */
public class T1_fib {
    public int fib(int n) {
        if (n <= 1) return n;
        int[] dp = new int[2];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            dp[i % 2] = dp[(i - 1) % 2] + dp[(i - 2) % 2];
        }
        return dp[n % 2];
    }


    public int jump(int[] nums) {
        int len = nums.length;
        int[] minStep = new int[len];
        int INF = 0x3f3f3f3f;
        Arrays.fill(minStep, 1, len, INF);
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= i + nums[i] && j < len; j++) {
                minStep[j] = Math.min(minStep[j], minStep[i] + 1);
            }
        }
        return minStep[len - 1];
    }
}
