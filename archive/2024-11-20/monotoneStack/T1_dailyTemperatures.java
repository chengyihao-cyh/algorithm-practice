package org.learn2024winter.monotoneStack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

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
        stack.push(0);

        for (int i = 1; i < len; i++) {
            if (stack.isEmpty() || temperatures[i] <= temperatures[stack.peek()]) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                    Integer idx = stack.pop();
                    res[idx] = i - idx;
                }
                stack.push(i);
            }
        }
        return res;
    }

    public int[] dailyTemperatures2(int[] temperatures) {
        int len = temperatures.length;
        int[] res = new int[len];
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);

        for (int i = 1; i < len; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                Integer idx = stack.pop();
                res[idx] = i - idx;
            }
            stack.push(i);
        }
        return res;
    }
}
