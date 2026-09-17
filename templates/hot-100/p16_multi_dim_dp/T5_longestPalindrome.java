/**
 * Practice template for:
 * - 5. Longest Palindromic Substring
 *   https://leetcode.cn/problems/longest-palindromic-substring/
 */
/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2025/11/7 19:31
 * @comment
 */
public class T5_longestPalindrome {
    public String longestPalindrome(String s) {
        char[] array = s.toCharArray();
        int len = array.length;
        boolean[][] dp = new boolean[len][len];
        int ansL = 0, ansR = 0, maxLen = 1;


        for (int i = len - 1; i >= 0; i--) {
            dp[i][i] = true;
            for (int j = i + 1; j < len; j++) {
                if (array[i] == array[j] && (j - i == 1 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    if (j + 1 - i > maxLen) {
                        maxLen = j + 1 - i;
                        ansL = i;
                        ansR = j;
                    }
                }
            }
        }
        return String.valueOf(array, ansL, ansR - ansL + 1);
    }
}
