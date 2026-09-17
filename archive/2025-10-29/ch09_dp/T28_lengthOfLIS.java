package org.review2025autumn.ch09_dp;

import java.util.Arrays;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/11/24 23:00
 * @comment
 */
public class T28_lengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int maxLen = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }
}
