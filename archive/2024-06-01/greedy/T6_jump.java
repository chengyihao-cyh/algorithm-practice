package org.review2024summer.greedy;

public class T6_jump {
    public int jump(int[] nums) {
        int currDist = 0;
        int nextDist = 0;
        int count = 0;
        if (nums.length == 1)
            return 0;
        for (int i = 0; i < nums.length; i++) {
            nextDist = Math.max(nextDist, i + nums[i]);
            if (i == currDist) {
                count++;
                currDist = nextDist;
                if (currDist >= nums.length - 1)
                    break;
            }
        }
        return count;
    }
}
