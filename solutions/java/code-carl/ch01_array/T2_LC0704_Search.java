/**
 * Practice template for:
 * - LeetCode 704. Binary Search
 *   https://leetcode.cn/problems/binary-search/
 */
public class T2_LC0704_Search {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
