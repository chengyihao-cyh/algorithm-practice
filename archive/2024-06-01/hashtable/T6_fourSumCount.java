package org.review2024summer.hashtable;

import java.util.HashMap;

public class T6_fourSumCount {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> records = new HashMap<>();
        int res = 0;

        for (int n1 : nums1) {
            for (int n2 : nums2) {
                int sum = n1 + n2;
                records.put(sum, records.getOrDefault(sum, 0) + 1);
            }
        }

        for (int n3 : nums3) {
            for (int n4 : nums4) {
                int minus = -1 * (n3 + n4);
                res += records.getOrDefault(minus, 0);
            }
        }

        return res;
    }
}
