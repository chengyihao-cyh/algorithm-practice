package org.review2024summer.greedy;

public class T2_wiggleMaxLength {
    public int wiggleMaxLength(int[] nums) {
        int preDiff = 0;
        int postDiff;
        int count = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            postDiff = nums[i + 1] - nums[i];
            if ((preDiff >= 0 && postDiff < 0) || (preDiff <= 0 && postDiff > 0)) {
                count++;
                preDiff = postDiff;
            }
        }
        return count;
    }
}
