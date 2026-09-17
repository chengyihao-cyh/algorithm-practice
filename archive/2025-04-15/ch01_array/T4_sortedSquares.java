package org.review2025springAgain.ch01_array;

public class T4_sortedSquares {
    public int[] sortedSquares(int[] nums) {
        int left = 0, right = nums.length - 1, idx = nums.length- 1;
        int[] res = new int[nums.length];
        while (left <= right) {
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                res[idx--] = nums[left] * nums[left];
                left++;
            } else {
                res[idx--] = nums[right] * nums[right];
                right--;
            }
        }
        return res;
    }
}
