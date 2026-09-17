package org.rereview2024summer.hashtable;

import java.util.HashMap;

public class T5_twoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int minus = target - nums[i];
            if (map.containsKey(minus)) {
                res[0] = map.get(minus);
                res[1] = i;
                return res;
            }
            map.put(nums[i], i);
        }
        return res;
    }

}
