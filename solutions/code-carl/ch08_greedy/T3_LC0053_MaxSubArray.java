/**
 * Practice template for:
 * - LeetCode 53. Maximum Subarray
 *   https://leetcode.cn/problems/maximum-subarray/
 */
public class T3_LC0053_MaxSubArray {
    public int maxSubArray(int[] nums) {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];
            maxSum = Math.max(maxSum, currSum);
            if (currSum < 0) {
                currSum = 0;
            }
        }
        return maxSum;
    }
}
