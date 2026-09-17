package org.rereview2024summer.array;

public class T5_minSubArrayLen {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;
        int sum = 0;

        for ( ; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {
                minLen = Math.min(minLen, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
