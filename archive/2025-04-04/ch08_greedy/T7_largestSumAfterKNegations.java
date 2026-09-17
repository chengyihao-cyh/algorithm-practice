package org.review2025spring.ch08_greedy;

import java.util.Arrays;

public class T7_largestSumAfterKNegations {
    public int largestSumAfterKNegations(int[] nums, int k) {
        int minAbs = Integer.MAX_VALUE;
        int sum = 0;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            minAbs = Math.min(minAbs, Math.abs(nums[i]));
            if (k > 0 && nums[i] < 0) {
                nums[i] *= -1;
                k--;
            }
            sum += nums[i];
        }

        if (k > 0 && k % 2 == 1) sum -= 2 * minAbs;
        return sum;
    }

}
