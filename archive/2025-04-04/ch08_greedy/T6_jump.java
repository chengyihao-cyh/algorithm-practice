package org.review2025spring.ch08_greedy;

public class T6_jump {
    public int jump(int[] nums) {
        if (nums.length == 1) return 0;
        int currCover = 0;
        int nextCover = 0;
        int count = 1;
        for (int i = 0; i <= currCover; i++) {
            nextCover = Math.max(nextCover, i + nums[i]);
            if (nextCover >= nums.length - 1) {
                break;
            }
            if (i == currCover) {
                count++;
                currCover = nextCover;
            }
        }
        return count;
    }
}
