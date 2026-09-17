/**
 * Practice template for:
 * - LeetCode 62. Unique Paths
 *   https://leetcode.cn/problems/unique-paths/
 */
import java.util.Arrays;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/11/20 16:32
 * @comment
 */
public class T4_LC0062_UniquePaths {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }
        return dp[n - 1];
    }
}
