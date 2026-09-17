/**
 * Practice template for:
 * - LeetCode 647. Palindromic Substrings
 *   https://leetcode.cn/problems/palindromic-substrings/
 */
import java.util.Arrays;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/11/28 14:18
 * @comment
 */
public class T38_LC0647_CountSubstrings {
    public int countSubstrings(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int count = 0;
        for (int i = len - 1; i >= 0; i--) {
            dp[i][i] = true;
            count++;
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j) && (dp[i + 1][j - 1] || j - i <= 1)) {
                    dp[i][j] = true;
                    count++;
                }
            }
        }
        return count;
    }
}
