package org.review2024summer.array;

public class T4_sortedSquares {
    public int[] sortedSquares(int[] nums) {
        int left = 0, right = nums.length - 1;
        int idx = nums.length - 1;
        int[] res = new int[nums.length];
        while (left <= right) {
            int sqr_l = nums[left] * nums[left];
            int sqr_r = nums[right] * nums[right];
            if (sqr_l > sqr_r) {
                res[idx--] = sqr_l;
                left++;
            } else {
                res[idx--] = sqr_r;
                right--;
            }
        }
        return res;
    }
}
