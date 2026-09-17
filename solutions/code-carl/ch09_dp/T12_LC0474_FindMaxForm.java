/**
 * Practice template for:
 * - LeetCode 474. Ones and Zeroes
 *   https://leetcode.cn/problems/ones-and-zeroes/
 */
/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/11/22 16:52
 * @comment
 */
public class T12_LC0474_FindMaxForm {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            int count0 = 0, count1 = 0;
            for (int k = 0; k < str.length(); k++) {
                if (str.charAt(k) == '0') {
                    count0++;
                } else if (str.charAt(k) == '1') {
                    count1++;
                }
            }
            for (int i = m; i >= count0; i--) {
                for (int j = n; j >= count1; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - count0][j - count1] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
