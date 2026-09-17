package org.review2024winter.dp;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/11/20 15:24
 * @comment
 */
public class T3_minCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int[] dp = new int[2];
        for (int i = 2; i < len + 1; i++) {
            dp[i % 2] = Math.min(dp[(i - 1) % 2] + cost[i - 1], dp[(i - 2) % 2] + cost[i - 2]);
        }
        return dp[len % 2];
    }
}
