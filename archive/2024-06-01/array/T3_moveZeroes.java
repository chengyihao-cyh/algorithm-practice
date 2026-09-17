package org.review2024summer.array;

public class T3_moveZeroes {
    public void moveZeroes_1(int[] nums) {
        int slowIdx = 0, fastIdx = 0;
        while (fastIdx < nums.length) {
            if (nums[fastIdx] != 0) {
                nums[slowIdx] = nums[fastIdx];
                slowIdx++;
            }
            fastIdx++;
        }
        for (int i = slowIdx; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
    public void moveZeroes_2(int[] nums) {
        int slowIdx = 0, fastIdx = 0;
        while (fastIdx < nums.length) {
            if (nums[fastIdx] != 0) {
                int tmp = nums[slowIdx];
                nums[slowIdx] = nums[fastIdx];
                nums[fastIdx] = tmp;
                slowIdx++;
            }
            fastIdx++;
        }
    }
}
