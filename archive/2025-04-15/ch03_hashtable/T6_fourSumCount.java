package org.review2025springAgain.ch03_hashtable;

import java.util.HashMap;

public class T6_fourSumCount {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Long, Integer> map = new HashMap<>();
        long sum, minus;
        int res = 0;
        for (int num1 : nums1) {
            for (int num2 : nums2) {
                sum = num1 + num2;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        for (int num3 : nums3) {
            for (int num4 : nums4) {
                minus = -1 * ((long) num3 + num4);
                res += map.getOrDefault(minus, 0);
            }
        }
        return res;
    }
}
