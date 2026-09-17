package org.review2024summer.greedy;

import com.sun.source.tree.BreakTree;

import java.util.Arrays;
import java.util.Comparator;

public class T7_largestSumAfterKNegations {
    public int largestSumAfterKNegations(int[] nums, int k) {
        int minAbs = Integer.MAX_VALUE;
        Arrays.sort(nums);
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            minAbs = Math.min(minAbs, Math.abs(nums[i]));
            if (nums[i] < 0 && k > 0) {
                nums[i] = -nums[i];
                k--;
            }
            sum += nums[i];
        }

        if (k % 2 == 1)
            sum -= 2 * minAbs;
        return sum;
    }
}
