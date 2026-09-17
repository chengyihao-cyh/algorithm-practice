package org.review2025autumn.ch09_dp;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/11/23 18:00
 * @comment
 */
public class T19_rob {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int prepre = nums[0], pre = Math.max(nums[0], nums[1]), curr = 0;
        for (int i = 2; i < nums.length; i++) {
            curr = Math.max(prepre + nums[i], pre);
            prepre = pre;
            pre = curr;
        }
        return pre;
    }
}

