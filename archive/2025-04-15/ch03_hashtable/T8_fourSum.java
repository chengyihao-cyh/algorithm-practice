package org.review2025springAgain.ch03_hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class T8_fourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        int l, r;
        long sum;
        Arrays.sort(nums);

        for (int i = 0; i < len - 3; i++) {
            if (target > 0 && nums[i] > target)
                break;
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            for (int j = i + 1; j < len - 2; j++) {
                if (target > 0 && nums[i] + nums[j] > target)
                    break;
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;
                l = j + 1;
                r = len - 1;
                while (l < r) {
                    sum = (long) nums[i] + nums[j] + nums[l] + nums[r];
                    if (sum < target) {
                        l++;
                    } else if (sum > target) {
                        r--;
                    } else {
                        res.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        while (l < r && nums[l] == nums[l + 1])
                            l++;
                        while (l < r && nums[r] == nums[r - 1])
                            r--;
                        l++;
                        r--;
                    }
                }
            }
        }

        return res;
    }
}