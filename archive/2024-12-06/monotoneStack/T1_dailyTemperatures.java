package org.review2024winter.monotoneStack;

import java.util.ArrayDeque;
import java.util.Deque;

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
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                Integer preIdx = stack.pop();
                res[preIdx] = i - preIdx;
            }
            stack.push(i);
        }

        return res;
    }
}
