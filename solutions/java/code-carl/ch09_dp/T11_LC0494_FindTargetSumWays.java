/**
 * Practice template for:
 * - LeetCode 494. Target Sum
 *   https://leetcode.cn/problems/target-sum/
 */
/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/11/22 15:36
 * @comment
 */
public class T11_LC0494_FindTargetSumWays {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if ((target + sum) % 2 == 1 || Math.abs(target) > sum) {
            return 0;
        }
        int bagSize = (target + sum) / 2;

        int[] dp = new int[bagSize + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = bagSize; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[bagSize];
    }
}
