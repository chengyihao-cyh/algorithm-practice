package org.review2024summer.array;

public class T3_removeElement {
    public int removeElement(int[] nums, int val) {
        int slowIdx = 0, fastIdx = 0;
        while (fastIdx < nums.length) {
            if (nums[fastIdx] != val) {
                nums[slowIdx] = nums[fastIdx];
                slowIdx++;
            }
            fastIdx++;
        }
        return slowIdx;
    }
}
