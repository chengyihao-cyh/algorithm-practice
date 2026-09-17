/**
 * Practice template for:
 * - LeetCode 45. Jump Game II
 *   https://leetcode.cn/problems/jump-game-ii/
 */
public class T6_LC0045_Jump {
    public int jump(int[] nums) {
        if (nums.length == 1) return 0;
        int currCover = 0;
        int nextCover = 0;
        int count = 0;

        for (int i = 0; i <= currCover; i++) {
            nextCover = Math.max(nextCover, i + nums[i]);
            if (nextCover >= nums.length - 1) {
                count++;
                return count;
            }
            if ( i == currCover) {
                count++;
                currCover = nextCover;
            }
        }
        return -1;
    }
}
