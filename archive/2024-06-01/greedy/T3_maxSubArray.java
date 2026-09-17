package org.review2024summer.greedy;

public class T3_maxSubArray {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            maxSum = Math.max(sum, maxSum);
            if (sum < 0)
                sum = 0;
        }
        return maxSum;
    }
}
