package org.review2024winter.dp;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/11/25 16:11
 * @comment
 */
public class T30_findLength {
    public int findLength(int[] nums1, int[] nums2) {
        int[] dp = new int[nums2.length + 1];
        int res = 0;

        for (int i = 1; i < nums1.length + 1; i++) {
            for (int j = nums2.length; j >= 1; j--) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[j] = dp[j - 1] + 1;
                    res = Math.max(res, dp[j]);
                } else {
                    dp[j] = 0;
                }
            }
        }
        return res;
    }
}
