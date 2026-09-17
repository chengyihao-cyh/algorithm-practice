package org.review2025autumn.ch03_hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T7_threeSum {
        public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {

            if (nums[i] > 0) {
                break;
            }
            if (i > 0 &&nums[i] == nums[i-1]) {
                continue;
            }

            int l = i + 1, r = nums.length - 1;
            while (l < r && nums[r] >= 0) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum > 0) {
                    r--;
                } else if (sum < 0) {
                    l++;
                } else {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[l + 1] == nums[l]) l++;
                    l++;
                    while (l < r && nums[r - 1] == nums[r]) r--;
                    r--;
                }
            }

        }
        return res;
    }
}
