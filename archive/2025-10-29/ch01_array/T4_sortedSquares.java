package org.review2025autumn.ch01_array;

public class T4_sortedSquares {
    public int[] sortedSquares(int[] nums) {
        int left = 0, right = nums.length - 1;
        int[] res = new int[nums.length];
        int i = nums.length - 1;
        while (left <= right) {
            int m1 = nums[left] * nums[left];
            int m2 = nums[right] * nums[right];
            if (m1 > m2) {
                res[i--] = m1;
                left++;
            } else {
                res[i--] = m2;
                right--;
            }
        }
        return res;
    }
}
