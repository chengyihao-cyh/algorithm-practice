package org.learn2024winter.dp;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/11/26 15:00
 * @comment
 */
public class T33_maxSubArray {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = dp[0];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public int maxSubArray2(int[] nums) {
        int preSum = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            preSum = Math.max(preSum + nums[i], nums[i]);
            maxSum = Math.max(maxSum, preSum);
        }
        return maxSum;
    }
}
