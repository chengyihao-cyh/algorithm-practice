package org.review2025spring.ch01_array;

import java.util.Map;

public class T4_sortedSquares {
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int l = 0, r = res.length - 1;
        int i = res.length - 1;
        while (l <= r) {
            if (Math.abs(nums[l]) > Math.abs(nums[r])) {
                res[i--] = nums[l] * nums[l];
                l++;
            } else {
                res[i--] = nums[r] * nums[r];
                r--;
            }
        }

        return res;
    }
}
