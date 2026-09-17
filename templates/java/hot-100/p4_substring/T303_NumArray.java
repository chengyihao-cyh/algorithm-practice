/**
 * Practice template for:
 * - 303. Range Sum Query - Immutable
 *   https://leetcode.cn/problems/range-sum-query-immutable/
 */
/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2025/11/9 15:58
 * @comment
 */
public class T303_NumArray {
    class NumArray {
        int[] preSum;

        public NumArray(int[] nums) {
            this.preSum = new int[nums.length];
            preSum[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                preSum[i] = preSum[i - 1] + nums[i];
            }
        }

        public int sumRange(int left, int right) {
            if (left == 0) {
                return preSum[right];
            } else {
                return preSum[right] - preSum[left - 1];
            }
        }
    }
}
