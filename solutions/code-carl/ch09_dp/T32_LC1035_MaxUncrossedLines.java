/**
 * Practice template for:
 * - LeetCode 1035. Uncrossed Lines
 *   https://leetcode.cn/problems/uncrossed-lines/
 */
/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/11/26 14:53
 * @comment
 */
public class T32_LC1035_MaxUncrossedLines {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}
