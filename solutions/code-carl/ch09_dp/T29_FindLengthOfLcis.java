/**
 * Practice template for:
 * - LeetCode 674. Longest Continuous Increasing Subsequence
 *   https://leetcode.cn/problems/longest-continuous-increasing-subsequence/
 */
import java.util.Arrays;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/11/25 15:35
 * @comment
 */
public class T29_FindLengthOfLcis {
    public int findLengthOfLCIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        int maxLen = 1;
        for (int i = 1; i < len; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
                maxLen = Math.max(maxLen, dp[i]);
            } else {
                dp[i] = 1;
            }
        }
        return maxLen;
    }

}
