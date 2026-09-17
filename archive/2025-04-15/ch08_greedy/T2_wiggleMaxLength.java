package org.review2025springAgain.ch08_greedy;

public class T2_wiggleMaxLength {
    public int wiggleMaxLength(int[] nums) {
        int count = 1;
        int preDiff = 0;
        for (int i = 1; i < nums.length ; i++) {
            int currDiff = nums[i] - nums[i - 1];
            if ((preDiff >= 0 && currDiff < 0) || (preDiff <= 0 && currDiff > 0)) {
                count++;
                preDiff = currDiff;
            }
        }
        return count;
    }
}
