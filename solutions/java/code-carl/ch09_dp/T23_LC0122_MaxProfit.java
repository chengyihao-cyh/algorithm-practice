/**
 * Practice template for:
 * - LeetCode 122. Best Time to Buy and Sell Stock II
 *   https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/
 */
/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/11/23 23:53
 * @comment
 */
public class T23_LC0122_MaxProfit {
    public int maxProfit(int[] prices) {
        int[] dp = new int[2];
        dp[0] = -prices[0];
        dp[1] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[0] = Math.max(dp[0], dp[1] - prices[i]);
            dp[1] = Math.max(dp[1], dp[0] + prices[i]);
        }
        return dp[1];
    }

}
