package org.learn2024winter.dp;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/11/21 19:18
 * @comment
 */
public class T9_canPartition {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int target = sum / 2;
        if (target * 2 != sum) { // sum不是2的倍数
            return false;
        }

        int[] dp = new int[target + 1];
        for (int i = 0; i < n; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }
        return dp[target] == target;
    }
}
