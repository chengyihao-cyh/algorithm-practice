/**
 * Practice template for:
 * - LeetCode 1049. Last Stone Weight II
 *   https://leetcode.cn/problems/last-stone-weight-ii/
 */
/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/11/21 19:31
 * @comment
 */
public class T10_LC1049_LastStoneWeightIi {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int n : stones) {
            sum += n;
        }

        int bagSize = sum / 2;
        int[] dp = new int[bagSize + 1];
        for (int i = 0; i < stones.length; i++) {
            for (int j = bagSize; j >= stones[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }
        return sum - 2 * dp[bagSize];
    }
}
