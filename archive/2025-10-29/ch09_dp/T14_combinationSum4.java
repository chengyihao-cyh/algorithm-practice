package org.review2025autumn.ch09_dp;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/11/22 20:33
 * @comment
 */
public class T14_combinationSum4 {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int j = 1; j <= target; j++) {
            for (int num : nums) {
                if (j >= num) {
                    dp[j] += dp[j - num];
                }
            }
        }
        return dp[target];
    }
}
