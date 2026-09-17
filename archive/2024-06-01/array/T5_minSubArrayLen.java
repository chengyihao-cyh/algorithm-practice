package org.review2024summer.array;

public class T5_minSubArrayLen {
    // for 解法
    public int minSubArrayLen_1(int target, int[] nums) {
        int left = 0, right = 0;
        int sum = 0;
        int res = Integer.MAX_VALUE;
        while (right < nums.length) {
            while (right < nums.length && sum < target) {
                sum += nums[right];
                right++;
            }
            while (sum >= target) {
                res = Math.min(res, right - left);
                sum -= nums[left];
                left++;
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    // while 解法
    public int minSubArrayLen_2(int target, int[] nums) {
        int left = 0, right = 0;
        int sum = 0;
        int res = Integer.MAX_VALUE;
        for (right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {
                res = Math.min(res, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
