/**
 * Practice template for:
 * - LeetCode 416. Partition Equal Subset Sum
 *   https://leetcode.cn/problems/partition-equal-subset-sum/
 */
/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/11/21 19:18
 * @comment
 */
public class T9_LC0416_CanPartition {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }

        int bagSize = sum / 2;
        int[] dp = new int[bagSize + 1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = bagSize; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }
        return dp[bagSize] == bagSize;
    }
}
