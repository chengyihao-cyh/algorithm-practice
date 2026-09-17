package org.learn2024spring.hash.q4_twoSum;

import java.util.HashMap;
import java.util.Map;

public class Main {
}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];

        if (nums == null || nums.length == 0){
            return res;
        }

        Map<Integer, Integer> records = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int tmp = nums[i];
            if (records.containsKey(target - tmp)) {
                res[0] = records.get(target - tmp);
                res[1] = i;
                break;
            }
            records.put(tmp, i);
        }

        return res;
    }
}