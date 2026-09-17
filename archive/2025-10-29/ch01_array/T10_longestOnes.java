package org.review2025autumn.ch01_array;

public class T10_longestOnes {
    // 1004. 最大连续1的个数 III
    public int longestOnes(int[] nums, int k) {
        int l = 0, maxLen = 0, count = 0;
        for (int r = 0; r < nums.length; r++) {
            if (nums[r] == 0) {
                count++;
                while (count > k) {
                    if (nums[l] == 0) {
                        count--;
                    }
                    l++;
                }
            }
            maxLen = Math.max(maxLen, r - l + 1);
        }
        return maxLen;
    }
}
