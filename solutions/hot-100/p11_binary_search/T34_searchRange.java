/**
 * Practice template for:
 * - 34. Find First and Last Position of Element in Sorted Array
 *   https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2025/11/7 21:06
 * @comment
 */
public class T34_searchRange {
    public int[] searchRange(int[] nums, int target) {
        int start = lowerBound(nums, target);
        if (start == nums.length || nums[start] != target) {
            return new int[]{-1, -1};
        }
        int end = lowerBound(nums, target + 1) - 1;
        return new int[]{start, end};
    }

    public int lowerBound(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] >= target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
