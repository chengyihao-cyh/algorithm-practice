package org.review2024summer.greedy;

import java.util.ArrayList;

public class T5_canJump {
    public boolean canJump(int[] nums) {
        if (nums.length == 1)
            return true;
        int cover = nums[0];
        for (int i = 0; i <= cover; i++) {
            cover = Math.max(cover, i + nums[i]);
            if (cover >= nums.length - 1)
                return true;
        }
        return false;
    }
}
