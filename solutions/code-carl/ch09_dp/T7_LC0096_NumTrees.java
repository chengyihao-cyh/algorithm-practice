/**
 * Practice template for:
 * - LeetCode 96. Unique Binary Search Trees
 *   https://leetcode.cn/problems/unique-binary-search-trees/
 */
/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/11/21 16:36
 * @comment
 */
public class T7_LC0096_NumTrees {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }
}
