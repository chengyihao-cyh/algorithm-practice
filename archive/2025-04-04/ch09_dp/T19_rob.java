package org.review2025spring.ch09_dp;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/11/23 18:00
 * @comment
 */
public class T19_rob {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }
}

