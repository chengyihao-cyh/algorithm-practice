package org.review2025autumn.ch08_greedy;

public class T6_jump {
    public int jump(int[] nums) {
        if (nums.length == 1) return 0;
        int currCover = 0;
        int nextCover = 0;
        int count = 0;

        for (int i = 0; i <= currCover; i++) {
            nextCover = Math.max(nextCover, i + nums[i]);
            if (nextCover >= nums.length - 1) {
                count++;
                return count;
            }
            if ( i == currCover) {
                count++;
                currCover = nextCover;
            }
        }
        return -1;
    }
}
