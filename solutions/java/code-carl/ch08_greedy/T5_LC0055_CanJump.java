/**
 * Practice template for:
 * - LeetCode 55. Jump Game
 *   https://leetcode.cn/problems/jump-game/
 */
public class T5_LC0055_CanJump {
    public boolean canJump(int[] nums) {
        int cover = 0;
        for (int i = 0; i <= cover; i++) {
            cover = Math.max(cover, i + nums[i]);
            if (cover >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
}
