/**
 * Practice template for:
 * - LeetCode 188. Best Time to Buy and Sell Stock IV
 *   https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iv/
 */
/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/11/24 18:20
 * @comment
 */
public class T25_LC0188_MaxProfit {
    public int maxProfit(int k, int[] prices) {
        int[] dp = new int[2 * k];
        for (int i = 0; i < k; i++) {
            dp[2 * i] = -prices[0];
        }
        for (int i = 1; i < prices.length; i++) {
            for (int j = 0; j < k; j++) {
                if (j == 0) {
                    dp[0] = Math.max(dp[0], -prices[i]);
                } else {
                    dp[2 * j] = Math.max(dp[2 * j], dp[2 * j - 1] - prices[i]);
                }
                dp[2 * j + 1] = Math.max(dp[2 * j + 1], dp[2 * j] + prices[i]);
            }
        }
        return dp[2 * k - 1];
    }
}
