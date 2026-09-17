/**
 * Practice template for:
 * - LeetCode 309. Best Time to Buy and Sell Stock with Cooldown
 *   https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 */
/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/11/24 19:05
 * @comment
 */
public class T26_LC0309_MaxProfit {
    public int maxProfit(int[] prices) {
        int[] dp = new int[4];
        dp[0] = -prices[0];
        dp[1] = dp[2] = dp[3] = 0;
        for (int i  =1; i < prices.length; i++) {
            int[] pre = dp.clone();
            dp[0] = Math.max(pre[0], Math.max(pre[2], dp[3]) - prices[i]);
            dp[1] = pre[0] + prices[i];
            dp[2] = pre[1];
            dp[3] = Math.max(pre[3], pre[2]);
        }
        return Math.max(dp[1], Math.max(dp[2], dp[3]));
    }

}
