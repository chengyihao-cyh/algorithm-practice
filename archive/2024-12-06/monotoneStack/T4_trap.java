package org.review2024winter.monotoneStack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/11/28 23:36
 * @comment
 */
public class T4_trap {
    public int trap(int[] height) {
        int len = height.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int sum = 0;
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int midH = height[stack.pop()];
                if (!stack.isEmpty()) {
                    int h = Math.min(height[stack.peek()], height[i]) - midH;
                    int w = i - stack.peek() - 1;
                    sum += h * w;
                }
            }
            if (!stack.isEmpty() && height[i] == height[stack.peek()]) {
                stack.pop();
            }
            stack.push(i);
        }
        return sum;
    }
}




















