/**
 * Practice template for:
 * - LeetCode 343. Integer Break
 *   https://leetcode.cn/problems/integer-break/
 */
/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/11/20 23:47
 * @comment
 */
public class T6_LC0343_IntegerBreak {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i / 2; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }
}
