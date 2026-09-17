package org.review2025spring.ch09_dp;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/11/22 16:52
 * @comment
 */
public class T12_findMaxForm {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            int n0 = 0, n1 = 0;
            for (char ch : str.toCharArray()) {
                if (ch == '0') n0++;
                else n1++;
            }
            for (int i = m; i >= n0; i--) {
                for (int j = n; j >= n1; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - n0][j - n1] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
