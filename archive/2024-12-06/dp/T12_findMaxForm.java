package org.review2024winter.dp;

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
            int num0 = 0, num1 = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '1')
                    num1++;
                else
                    num0++;
            }
            for (int i = m; i >= num0; i--) {
                for (int j = n; j >= num1; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - num0][j - num1] + 1);
                }
            }
        }

        return dp[m][n];
    }
}
