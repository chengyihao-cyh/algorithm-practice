package org.review2024summer.hashtable;
import java.lang.reflect.Array;
import java.util.*;

public class T8_fourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            // 剪枝
            if ((target > 0 && nums[i] > target) || (target < 0 && (long)nums[i] * 4 > target))
                break;
            // a去重
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            for (int j = i + 1; j < nums.length; j++) {
                long sum1 = (long)nums[i] + nums[j];
                // 剪枝
                if ((target > 0 && sum1 > target) || (target < 0 && sum1 * 4 > target))
                    break;
                // b去重
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;

                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    long sum2 = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum2 > target) {
                        right--;
                    } else if (sum2 < target) {
                        left++;
                    } else {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left <right && nums[left] == nums[left + 1])
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