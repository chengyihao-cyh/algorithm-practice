/**
 * Practice template for:
 * - LeetCode 1005. Maximize Sum Of Array After K Negations
 *   https://leetcode.cn/problems/maximize-sum-of-array-after-k-negations/
 */
import java.util.Arrays;

public class T7_LC1005_LargestSumAfterKNegations {
    public int largestSumAfterKNegations(int[] nums, int k) {
        int minAbs = Integer.MAX_VALUE;
        int sum = 0;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            minAbs = Math.min(minAbs, Math.abs(nums[i]));
            if (k > 0 && nums[i] < 0) {
                k--;
                nums[i] = -nums[i];
            }
            sum += nums[i];
        }

        if (k % 2 == 1) {
            sum -= 2 * minAbs;
        }
        return sum;
    }
}
