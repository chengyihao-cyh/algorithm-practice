/**
 * Practice template for:
 * - 153. Find Minimum in Rotated Sorted Array
 *   https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array/
 */
/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2025/11/7 21:55
 * @comment
 */
public class T153_findMin {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 2;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] < nums[nums.length - 1]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return nums[l];
    }


}
