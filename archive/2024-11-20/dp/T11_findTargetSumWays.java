package org.learn2024winter.dp;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/11/22 15:36
 * @comment
 */
public class T11_findTargetSumWays {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum + target) % 2 == 1) return 0;
        if (Math.abs(target) > sum) return 0;

        // 求bagSize
        int bagSize = (sum + target) / 2;
        int n = nums.length;
        int[][] dp = new int[nums.length][bagSize + 1];

        // 初始化
        if (nums[0] <= bagSize) {
            dp[0][nums[0]] = 1;
        }
        dp[0][0] = 1;
/*        int countZero = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                countZero++;
            }
            dp[i][0] = (int) Math.pow(2, countZero);
        }*/

        // 递推
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= bagSize; j++) {
                if (j < nums[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i]];
                }
            }
        }
        return dp[nums.length - 1][bagSize];
    }

    public int findTargetSumWays2(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum + target) % 2 == 1) return 0;
        if (Math.abs(target) > sum) return 0;

        // 求bagSize
        int bagSize = (sum + target) / 2;
        int n = nums.length;

        // 初始化
        int[] dp = new int[bagSize + 1];
        dp[0] = 1;

        // 递推
        for (int i = 0; i < n; i++) {
            for (int j = bagSize; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[bagSize];
    }
}
