/**
 * Practice template for:
 * - 152. Maximum Product Subarray
 *   https://leetcode.cn/problems/maximum-product-subarray/
 */
/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2025/11/7 14:14
 * @comment
 */
public class T152_maxProduct {
    public int maxProduct(int[] nums) {
        // 由于存在负数，那么会导致最大的变最小的，最小的变最大的。因此还需要维护当前最小值imin。
        int max = Integer.MIN_VALUE;
        int imax = 1, imin = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]  < 0 ) {
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }
            imax = Math.max(nums[i], imax * nums[i]);
            imin = Math.min(nums[i], imin * nums[i]);

            max = Math.max(max, imax);
        }
        return max;
    }
}
