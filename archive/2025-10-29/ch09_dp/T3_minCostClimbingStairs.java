package org.review2025autumn.ch09_dp;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/11/20 15:24
 * @comment
 */
public class T3_minCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int prepre = 0, pre = 0, curr = 0;
        for (int i = 2; i <= cost.length; i++) {
            curr = Math.min(prepre + cost[i - 2], pre + cost[i - 1]);
            prepre = pre;
            pre = curr;
        }
        return pre;
    }
}
