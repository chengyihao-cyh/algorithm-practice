package org.rereview2024summer.array;

public class T4_sortedSquares {
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int left = 0, right = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            int sqr1 = nums[left] * nums[left];
            int sqr2 = nums[right] * nums[right];
            if (sqr1 > sqr2) {
                res[i] = sqr1;
                left++;
            } else {
                res[i] = sqr2;
                right--;
            }
        }
        return res;
    }
}
