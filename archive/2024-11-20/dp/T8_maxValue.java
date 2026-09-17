package org.learn2024winter.dp;

import java.util.Arrays;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/11/21 17:44
 * @comment
 */
public class T8_maxValue {
    public int maxValue_twoDimensions(int bagWeight, int[] weight, int[] value) {
        int n = weight.length;
        int[][] dp = new int[n][bagWeight + 1];
        for (int j = weight[0]; j <= bagWeight; j++) {
            dp[0][j] = value[0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= bagWeight; j++) {
                if (weight[i] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                }
            }
        }
        return dp[n - 1][bagWeight];
    }

    public int maxValue_oneDimension(int bagWeight, int[] weight, int[] value) {
        int n = weight.length;
        int[] dp = new int[bagWeight + 1];
        for (int i = 0; i < n; i++) {
            for (int j = bagWeight; j >= weight[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
        return dp[bagWeight];
    }
}
