package org.rereview2024summer.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T8_fourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if ((long)nums[i] * 4 > target)
                break;
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            for (int j = i + 1; j < nums.length; j++) {
                long sum1 = nums[i] + nums[j];
                if ((long)sum1 * 2 > target)
                    break;
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;
                int left = j + 1, right = nums.length - 1;
                while (left < right) {
                    long sum2 = (long)sum1 + nums[left] + nums[right];
                    if (sum2 < target) {
                        left++;
                    } else if (sum2 > target) {
                        right--;
                    } else {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left + 1] == nums[left])
                            left++;
                        left++;
                        while (left < right && nums[right - 1] == nums[right])
                            right--;
                        right--;
                    }
                }
            }
        }

        return res;
    }
}