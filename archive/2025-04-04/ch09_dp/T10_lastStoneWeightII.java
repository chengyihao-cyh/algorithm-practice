package org.review2025spring.ch09_dp;

import java.util.Arrays;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/11/21 19:31
 * @comment
 */
public class T10_lastStoneWeightII {
    public int lastStoneWeightII(int[] stones) {
        int sum = Arrays.stream(stones).sum();
        int bagSize = sum / 2;
        int[] dp = new int[bagSize + 1];

        for (int i = 0; i < stones.length; i++) {
            for (int j = bagSize; j >= stones[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }
        return sum - 2 * dp[bagSize];
    }
}
