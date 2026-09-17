package org.learn2024winter.dp;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/11/26 15:52
 * @comment
 */
public class T34_isSubsequence {
    public boolean isSubsequence(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[len1][len2] == len1;
    }

    public boolean isSubsequence5(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[len1][len2] == len1;
    }

    // dp为 s*t
    public boolean isSubsequence2(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[len1][len2] == len1;
    }

    // dp为 t*s
    public boolean isSubsequence3(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();
        int[][] dp = new int[len2 + 1][len1 + 1];
        for (int i = 1; i <= len2; i++) {
            for (int j = 1; j <= len1; j++) {
                if (t.charAt(i - 1) == s.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[len2][len1] == len1;
    }

    // 压缩状态
    public boolean isSubsequence4(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();
        int[] dp = new int[len1 + 1];
        for (int i = 1; i <= len2; i++) {
            for (int j = len1; j >= 1; j--) {
                if (t.charAt(i - 1) == s.charAt(j - 1)) {
                    dp[j] = dp[j - 1] + 1;
                }
            }
        }
        return dp[len1] == len1;
    }


}
