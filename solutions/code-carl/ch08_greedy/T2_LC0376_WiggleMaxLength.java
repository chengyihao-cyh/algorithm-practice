/**
 * Practice template for:
 * - LeetCode 376. Wiggle Subsequence
 *   https://leetcode.cn/problems/wiggle-subsequence/
 */
public class T2_LC0376_WiggleMaxLength {
    public int wiggleMaxLength(int[] nums) {
        int preDiff = 0;
        int currDiff;
        int count = 1;

        for (int i = 0; i < nums.length - 1; i++) {
            currDiff = nums[i + 1] - nums[i];
            if (preDiff >= 0 && currDiff < 0 || preDiff <= 0 && currDiff > 0) {
                count++;
                preDiff = currDiff;
            }
        }
        return count;
    }
}
