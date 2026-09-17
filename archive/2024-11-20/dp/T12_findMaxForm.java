package org.learn2024winter.dp;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/11/22 16:52
 * @comment
 */
public class T12_findMaxForm {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        // 先遍历物品
        for (String str : strs) {
            int zeroNum = 0, oneNum = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '0')
                    zeroNum++;
                else
                    oneNum++;
            }

            // 再遍历背包
            for (int i = m; i >= zeroNum; i--) {
                for (int j = n; j >= oneNum; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - oneNum][j - zeroNum] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
