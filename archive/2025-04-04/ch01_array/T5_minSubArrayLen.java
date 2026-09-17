package org.review2025spring.ch01_array;

import javax.swing.plaf.metal.MetalTheme;
import java.util.Map;

public class T5_minSubArrayLen {
    public int minSubArrayLen(int target, int[] nums) {
        int j = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= target) {
                minLen = Math.min(minLen, i - j + 1);
                sum -= nums[j];
                j++;
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
