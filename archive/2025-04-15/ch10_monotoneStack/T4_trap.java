package org.review2025springAgain.ch10_monotoneStack;

import java.util.ArrayDeque;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/11/28 23:36
 * @comment
 */
public class T4_trap {
    public int trap(int[] height) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int len = height.length;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                Integer midIdx = stack.pop();
                if (!stack.isEmpty()) {
                    int h = Math.min(height[i], height[stack.peek()]) - height[midIdx];
                    int w = i - stack.peek() - 1;
                    sum += h * w;
                }
            }
            stack.push(i);
        }
        return sum;
    }
}




















