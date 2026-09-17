package org.learn2024spring.array.q1_search;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1};
//        System.out.println(Solution.searchRange(nums, 1));
//        String s  = "aaa";
//        char[] chars = s.toCharArray();
//        int[] a = {1,2,3};
//        a[1]++;
    }
}

class Solution {
    public static int[] searchRange(int[] nums, int target) {
        int idx = search(nums, 0, nums.length - 1, target);
        int[] res = new int[2];
        if (idx == -1){
            res[0] = -1;
            res[1] = -1;
        } else {
            int left = idx, right = idx;
            while (left > 0 && nums[left - 1] == target){
                left--;
            }
            while (right < nums.length - 1 && nums[right + 1] == target){
                right++;
            }
            res[0] = left;
            res[1] = right;
        }
        return res;
    }

    public static int search(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}