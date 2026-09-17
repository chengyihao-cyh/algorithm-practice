/**
 * Practice template for:
 * - 35. Search Insert Position
 *   https://leetcode.cn/problems/search-insert-position/
 */
/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2025/11/7 19:43
 * @comment
 */
public class T35_searchInsert {
    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] > target) {
                r = mid - 1;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                return mid;
            }
        }
        return l;
    }
}
