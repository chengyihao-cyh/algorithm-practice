package org.learn2024winter.dp;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/11/28 15:05
 * @comment
 */
public class T39_longestPalindromeSubseq {
    public int longestPalindromeSubseq(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        int[][] dp = new int[len][len];
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (chars[i] == chars[j]) {
                    if (j - i <= 1) {
                        dp[i][j] = j - i + 1;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    }
                } else {
                    if (j - i <= 1) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.max(Math.max(dp[i + 1][j], dp[i][j - 1]), dp[i + 1][j - 1]);
                    }
                }
            }
        }
        return dp[0][len - 1];
    }


    public int longestPalindromeSubseq2(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) dp[i][i] = 1;
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                if (chars[i] == chars[j]) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][len - 1];
    }
}
