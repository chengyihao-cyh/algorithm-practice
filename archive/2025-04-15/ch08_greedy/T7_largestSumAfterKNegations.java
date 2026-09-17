package org.review2025springAgain.ch08_greedy;

import java.util.Arrays;

public class T7_largestSumAfterKNegations {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int minAbs = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            minAbs = Math.min(minAbs, Math.abs(nums[i]));
            if (k > 0 && nums[i] < 0) {
                k--;
                nums[i] *= -1;
            }
            sum += nums[i];
        }
        if (k % 2 == 1) sum -= 2 * minAbs;
        return sum;
    }
}
