package org.learn2024spring.hash.q6_threeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = solution.threeSum(nums);
        System.out.println(lists);
    }
}

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);


        for (int i = 0; i < nums.length; i++) {
            // 剪枝
            if (nums[i] > 0){
                break;
            }
            // 对a去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 对bc去重
                    while (left < right && nums[left + 1] == nums[left]) left++;
                    while (left < right && nums[right - 1] == nums[right]) right--;
                    left++;
                    right--;
                }
            }
        }
        return result;
    }
}