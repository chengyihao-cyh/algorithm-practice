package org.review2025autumn.ch09_dp;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/11/23 18:27
 * @comment
 */
public class T20_rob {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        return Math.max(
                robAction(nums, 0, nums.length - 1),
                robAction(nums, 1, nums.length)
        );
    }

    public int robAction(int[] nums, int start, int end) {
        int prepre = nums[start], pre = Math.max(nums[start], nums[start + 1]), curr = 0;
        for (int i = start + 2; i < end; i++) {
            curr = Math.max(prepre + nums[i], pre);
            prepre = pre;
            pre = curr;
        }
        return pre;
    }
}
