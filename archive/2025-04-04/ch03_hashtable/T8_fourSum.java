package org.review2025spring.ch03_hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T8_fourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int left, right;
        long sum;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (nums[i] > 0)
                break;
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (nums[i] + nums[j] > 0)
                    break;
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;
                left = j + 1;
                right = nums.length - 1;
                while (left < right) {
                    sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum < 0) {
                        left++;
                    } else if (sum > 0) {
                        right--;
                    } else {
                        res.add(Arrays.asList(nums[i], nums[j], left, right));
                        while (left < right && nums[left] == nums[left + 1])
                            left++;
                        while (left < right && nums[right] == nums[right - 1])
                            right--;
                        left++;
                        right--;
                    }
                }
            }
        }
        return res;
    }
}