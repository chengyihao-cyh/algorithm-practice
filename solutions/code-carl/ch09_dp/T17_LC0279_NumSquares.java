/**
 * Practice template for:
 * - LeetCode 279. Perfect Squares
 *   https://leetcode.cn/problems/perfect-squares/
 */
import java.util.Arrays;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/11/22 21:21
 * @comment
 */
public class T17_LC0279_NumSquares {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        final int INF = 0x3f3f3f3f;
        dp[0] = 0;
        Arrays.fill(dp, 1, n + 1, INF);

        for (int j = 0; j <= n; j++) {
            for (int i = 1; i * i <= j; i++) {
                dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
            }
        }
        return dp[n] < INF ? dp[n] : -1;
    }
}
