package org.review2024winter.dp;

import java.util.Arrays;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/11/24 23:00
 * @comment
 */
public class T28_lengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        int res = 1;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
