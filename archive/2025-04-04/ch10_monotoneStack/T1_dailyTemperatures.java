package org.review2025spring.ch10_monotoneStack;

import java.util.ArrayDeque;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/11/28 16:33
 * @comment
 */
public class T1_dailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] res = new int[len];
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                Integer idx = stack.pop();
                res[idx] = i  - idx;
            }
            stack.push(i);
        }
        return res;
    }
}
