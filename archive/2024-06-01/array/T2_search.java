package org.review2024summer.array;

public class T2_search {
    public int search_1(int[] nums, int target) {
        // 左闭右开写法
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }else {
                return mid;
            }
        }
        return -1;
    }
    public int search_2(int[] nums, int target) {
        // 左闭右闭写法
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }else {
                return mid;
            }
        }
        return -1;
    }
}
