/**
 * Practice template for:
 * - 162. Find Peak Element
 *   https://leetcode.cn/problems/find-peak-element/
 */
/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2025/11/7 21:59
 * @comment
 */
public class T162_findPeakElement {
    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 2;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] < nums[mid + 1]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}
