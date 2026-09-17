package org.review2025autumn.ch09_dp;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/11/20 14:41
 * @comment
 */
public class T1_fib {
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        int prepre = 0,  pre = 1;
        for (int i = 2; i <= n; i++) {
            int curr = prepre + pre;
            prepre = pre;
            pre = curr;
        }
        return pre;
    }
}
