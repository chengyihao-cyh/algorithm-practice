package org.review2025springAgain.ch09_dp;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/11/20 14:41
 * @comment
 */
public class T1_fib {
    public int fib(int n) {
        if (n < 2) return n;
        int pre = 0;
        int post = 1;
        for (int i = 2; i <= n; i++) {
            int tmp = pre + post;
            pre = post;
            post = tmp;
        }
        return post;
    }
}
