/**
 * Practice template for:
 * - LeetCode 209. Minimum Size Subarray Sum
 *   https://leetcode.cn/problems/minimum-size-subarray-sum/
 */
public class T5_LC0209_MinSubArrayLen {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0, j = 0, minLen = Integer.MAX_VALUE;
        for (int i  = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= target) {
                minLen = Math.min(minLen, i - j + 1);
                sum -= nums[j];
                j++;
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
