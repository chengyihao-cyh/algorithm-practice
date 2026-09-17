/**
 * Practice template for:
 * - LeetCode 115. Distinct Subsequences
 *   https://leetcode.cn/problems/distinct-subsequences/
 */
/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/11/27 15:15
 * @comment
 */
public class T35_LC0115_NumDistinct {
    public int numDistinct(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[len1][len2];
    }
}
