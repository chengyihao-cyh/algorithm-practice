package org.learn2024winter.dp;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/11/28 14:18
 * @comment
 */
public class T38_countSubstrings {
    public int countSubstrings(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        boolean[][] dp = new boolean[len][len];
        int res = 0;
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (chars[i] == chars[j]) {
                    if (j - i <= 1) {
                        res++;
                        dp[i][j] = true;
                    } else if (dp[i + 1][j - 1]) {
                        res++;
                        dp[i][j] = true;
                    }
                }
            }
        }
        return res;
    }

    public int countSubstrings2(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        boolean[][] dp = new boolean[len][len];
        int res = 0;
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if ((chars[i] == chars[j]) && ((j - i <= 1) || dp[i + 1][j - 1])) {
                    res++;
                    dp[i][j] = true;
                }
            }
        }
        return res;
    }

    public int countSubstrings3(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        boolean[][] dp = new boolean[len][len];
        int res = 0;
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
            res++;
        }
        for (int k = 1; k < len; k++) {
            for (int j = k; j < len; j++) {
                int i = j - k;
                if (chars[i] == chars[j]) {
                    if (j - i <= 1) {
                        dp[i][j] = true;
                        res++;
                    } else if (dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                        res++;
                    }
                }
            }
        }
        return res;
    }

    public int countSubstrings4(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        boolean[][] dp = new boolean[len][len];
        int res = 0;
        // 初始化
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
            res++;
        }
        // 递推
        for (int k = 1; k < len; k++) {
            for (int j = k; j < len; j++) {
                int i = j - k;
                if ((chars[i] == chars[j]) && ((j - i == 1) || (dp[i + 1][j - 1]))) {
                    dp[i][j] = true;
                    res++;
                }
            }
        }
        return res;
    }

    public String longestPalindrome(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int res = 1, currLen = 1;
        int start = 0, end = 0;

        // 初始化
        for (int i = 0; i < len; i++)
            dp[i][i] = true;
        // 递推
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                if ((s.charAt(i) == s.charAt(j)) && ((j == i + 1) || (dp[i + 1][j - 1]))) {
                    dp[i][j] = true;
                    currLen = j - i + 1;
                    if (currLen > res) {
                        res = currLen;
                        start = i;
                        end = j;
                    }
                }
            }
        }
        return s.substring(start, end + 1);
    }
}

























