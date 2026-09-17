/**
 * Practice template for:
 * - LeetCode 714. Best Time to Buy and Sell Stock with Transaction Fee
 *   https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
 */
/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/11/24 22:02
 * @comment
 */
public class T27_LC0714_MaxProfit {
    public int maxProfit(int[] prices, int fee) {
        int[] dp = new int[2];
        dp[0] = -prices[0];
        dp[1] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[0] = Math.max(dp[0], dp[1] - prices[i]);
            dp[1] = Math.max(dp[1], dp[0] + prices[i] - fee);
        }
        return dp[1];
    }
}
