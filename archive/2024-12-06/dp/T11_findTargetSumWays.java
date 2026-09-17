package org.review2024winter.dp;

import java.util.Arrays;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/11/22 15:36
 * @comment
 */
public class T11_findTargetSumWays {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        if ((sum + target) % 2 == 1) return 0;
        if (Math.abs(target) > sum) return 0;
        int n = nums.length;
        int bagSize = (sum + target) / 2;
        int[] dp = new int[bagSize + 1];
        dp[0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = bagSize; j >= nums[i]; j--) {
                dp[j] = dp[j] + dp[j - nums[i]];
            }
        }

        return dp[bagSize];
    }
}
