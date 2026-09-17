package org.review2025autumn.ch09_dp;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/11/20 15:10
 * @comment
 */
public class T2_climbStairs {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int prepre = 1, pre = 2;
        for (int i = 3; i <= n; i++) {
            int curr = prepre + pre;
            prepre = pre;
            pre = curr;
        }
        return pre;
    }
}
