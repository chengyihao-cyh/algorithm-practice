/**
 * Practice template for:
 * - LeetCode 518. Coin Change II
 *   https://leetcode.cn/problems/coin-change-ii/
 */
/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/11/22 19:51
 * @comment
 */
public class T13_LC0518_Change {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                dp[j] += dp[j - coin];
            }
        }
        return dp[amount];
    }
}
