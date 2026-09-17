package org.review2024summer.practice;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P4_fourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (target > 0 && nums[i] > target)
                break;
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            for (int j = i + 1; j < nums.length; j++) {
                if (target > 0 && (long)nums[i] + nums[j] > target)
                    break;
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;

                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    long sum = (long)nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum < target) {
                        left++;
                    } else if (sum > target) {
                        right--;
                    } else {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1])
                            left++;
                        left++;
                        while (left < right && nums[right] == nums[right - 1])
                            right--;
                        right--;
                    }
                }

            }
        }

        return res;
    }
}

