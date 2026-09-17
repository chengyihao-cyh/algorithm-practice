package org.rereview2024summer.array;

public class T3_moveZeroes {
    public void moveZeroes(int[] nums) {
        int fast = 0, slow = 0;
        for ( ; fast < nums.length; fast++) {
            if (nums[fast] != 0) {
                int tmp = nums[fast];
                nums[fast] = nums[slow];
                nums[slow] = tmp;
                slow++;
            }
        }
    }
}
