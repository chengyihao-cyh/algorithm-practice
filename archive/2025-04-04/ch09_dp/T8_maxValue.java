package org.review2025spring.ch09_dp;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/11/21 17:44
 * @comment
 */
public class T8_maxValue {
    public int maxValue_twoDimensions(int bagWeight, int[] weight, int[] value) {
        int n = weight.length;
        int[] dp = new int[bagWeight + 1];
        for (int i = 0 ;  i< n; i++) {
            for (int j = bagWeight; j >= weight[i];j--) {
                dp[j] = Math.max(dp[j], dp[j-weight[i]] + value[i]);
            }
        }
        return dp[bagWeight];
    }
}
