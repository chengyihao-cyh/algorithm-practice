package org.review2025autumn.ch01_array;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2025/10/29 20:53
 * @comment
 */
public class T9_findKthLargest {
    Random random = new Random();

    public int findKthLargest(int[] nums, int k) {
        int target = nums.length - k;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int pivotIdx = partition(nums, left, right);
            if (pivotIdx < target) {
                left = pivotIdx + 1;
            } else if (pivotIdx > target) {
                right = pivotIdx - 1;
            } else {
                return nums[pivotIdx];
            }
        }
        return -1;
    }

    public int partition(int[] nums, int left, int right) {
        int idx = random.nextInt(right - left + 1) + left;
        int pivot = nums[idx];
        swap(nums, idx, left);
        int i = left, j = right;
        while (i < j) {
            while (i < j && nums[j] >= pivot) {
                j--;
            }
            while (i < j && nums[i] <= pivot) {
                i++;
            }
            if (i < j) {
                swap(nums, i, j);
            }
        }
        swap(nums, left, i);
        return i;
    }

    public void swap(int[] nums, int l, int r) {
        int tmp = nums[l];
        nums[l] = nums[r];
        nums[r] = tmp;
    }
}
