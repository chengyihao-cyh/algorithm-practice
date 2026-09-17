/**
 * Practice template for:
 * - LeetCode 977. Squares of a Sorted Array
 *   https://leetcode.cn/problems/squares-of-a-sorted-array/
 */
public class T4_LC0977_SortedSquares {
    public int[] sortedSquares(int[] nums) {
        int left = 0, right = nums.length - 1;
        int[] res = new int[nums.length];
        int i = nums.length - 1;
        while (left <= right) {
            int m1 = nums[left] * nums[left];
            int m2 = nums[right] * nums[right];
            if (m1 > m2) {
                res[i--] = m1;
                left++;
            } else {
                res[i--] = m2;
                right--;
            }
        }
        return res;
    }
}
