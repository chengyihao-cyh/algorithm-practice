/**
 * Practice template for:
 * - LeetCode 516. Longest Palindromic Subsequence
 *   https://leetcode.cn/problems/longest-palindromic-subsequence/
 */
/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/11/28 15:05
 * @comment
 */
public class T39_LC0516_LongestPalindromeSubseq {
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        for (int i = len - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][len - 1];
    }

}
