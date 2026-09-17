package org.review2024winter.dp;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/11/23 18:27
 * @comment
 */
public class T20_rob {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        return Math.max(
                robAction(nums, 1, nums.length),
                robAction(nums, 0, nums.length - 1)
        );
    }

    public int robAction(int[] nums, int start, int end) {
        int[] dp = new int[2];
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i < end; i++) {
            int newVal = Math.max(dp[0] + nums[i], dp[1]);
            dp[0] = dp[1];
            dp[1] = newVal;
        }
        return dp[1];
    }
}
