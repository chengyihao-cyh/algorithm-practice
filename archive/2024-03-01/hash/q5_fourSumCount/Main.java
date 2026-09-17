package org.learn2024spring.hash.q5_fourSumCount;

import java.util.HashMap;

public class Main {

}

class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> records = new HashMap<>();
        int count = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                int sum = nums1[i] + nums2[j];
                records.put(sum, records.getOrDefault(sum, 0) + 1);
            }
        }
        for (int i = 0; i < nums3.length; i++) {
            for (int j = 0; j < nums4.length; j++) {
                int tmp = -1 * (nums3[i] + nums4[j]);
                if (records.containsKey(tmp)){
                    count += records.get(tmp);
                }
            }
        }
        return count;
    }
}