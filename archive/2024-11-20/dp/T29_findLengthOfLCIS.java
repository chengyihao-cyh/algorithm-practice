package org.learn2024winter.dp;

import java.util.Arrays;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/11/25 15:35
 * @comment
 */
public class T29_findLengthOfLCIS {
    public int findLengthOfLCIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        int res = 1;

        for (int i = 1; i < len; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
                res = Math.max(res, dp[i]);
            } else {
                dp[i] = 1;
            }
        }
        return res;
    }

    public int findLengthOfLCIS2(int[] nums) {
        int len = nums.length;
        int res = 1;
        int curr = 1;

        for (int i = 1; i < len; i++) {
            if (nums[i] > nums[i - 1]) {
                curr += 1;
                res = Math.max(res, curr);
            } else {
                curr = 1;
            }
        }
        return res;
    }

    public int findLengthOfLCIS3(int[] nums) {
        int len = nums.length;
        int[] dp = new int[]{1, 1};
        int res = 1;

        for (int i = 1; i < len; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i % 2] = dp[(i - 1) % 2] + 1;
                res = Math.max(res, dp[i % 2]);
            } else {
                dp[i % 2] = 1;
            }
        }
        return res;
    }
}
