package org.review2024summer.hashtable;

import java.util.HashMap;

public class T5_twoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        if (nums == null || nums.length == 0)
            return res;

        HashMap<Integer, Integer> records = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (records.containsKey(target - nums[i])) {
                res[0] = records.get(target - nums[i]);
                res[1] = i;
                return res;
            }
            records.put(nums[i], i);
        }

        return res;
    }

}
