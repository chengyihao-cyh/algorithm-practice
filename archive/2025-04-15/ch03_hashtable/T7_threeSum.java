package org.review2025springAgain.ch03_hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T7_threeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        int sum = 0;
        int l, r;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            l = i + 1;
            r = len - 1;
            while (l < r) {
                sum = nums[i] + nums[l] + nums[r];
                if (sum < 0) {
                    l++;
                } else if (sum > 0) {
                    r--;
                } else {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[l] == nums[l + 1]) {
                        l++;
                    }
                    while (l < r && nums[r] == nums[r - 1]) {
                        r--;
                    }
                    l++;
                    r--;
                }
            }
        }
        return res;
    }
}
