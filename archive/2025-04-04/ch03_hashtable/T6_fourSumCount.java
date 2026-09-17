package org.review2025spring.ch03_hashtable;

import java.util.HashMap;

public class T6_fourSumCount {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int sum = 0;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n1 : nums1) {
            for (int n2 : nums2) {
                sum = n1 + n2;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        for (int n3 : nums3) {
            for (int n4 : nums4) {
                int tmp = -1 * (n3 + n4);
                if (map.containsKey(tmp)) {
                    count += map.get(tmp);
                }
            }
        }

        return count;
    }
}
