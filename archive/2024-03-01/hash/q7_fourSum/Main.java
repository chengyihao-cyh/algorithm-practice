package org.learn2024spring.hash.q7_fourSum;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.fourSum(new int[]{1,0,-1,0,-2,2}, 0);
    }
}

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            // 一级剪枝
            if (nums[i] > target && target > 0) {
                break;
            }
            // 对a去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                // 二级剪枝
                if (nums[i] + nums[j] > target && target > 0) {
                    break;
                }
                // 对b去重
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                // 内层双指针收缩
                int left = j + 1, right = nums.length - 1;
                while (left < right) {
                    // 存在测试用例 [1000000000,1000000000,1000000000,1000000000] ,用int做sum会越界
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum < target) {
                        left++;
                    } else if (sum > target) {
                        right--;
                    } else {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        // 对cd去重
                        while (left < right && nums[left + 1] == nums[left]) left++;
                        while (left < right && nums[right - 1] == nums[right]) right--;
                        left++;
                        right--;
                    }
                }
            }
        }
        return result;
    }
}





class Solution2 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (target > 0 && nums[i] > target)
                break;
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            for (int j = i + 1; j < nums.length; j++) {
                if (target > 0 && nums[i] + nums[j] > target)
                    break;
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;

                int left = j + 1, right = nums.length - 1;
                while (left < right) {
                    long sum = (long)nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum < target)
                        left++;
                    else if (sum > target)
                        right--;
                    else {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left + 1] == nums[left]) left++;
                        while (left < right && nums[right - 1] == nums[right]) right--;
                        left++;
                        right--;
                    }

                }
            }
        }

        return res;
    }
}
























