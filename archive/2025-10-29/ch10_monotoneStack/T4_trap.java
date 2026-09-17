package org.review2025autumn.ch10_monotoneStack;

import java.util.ArrayDeque;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/11/28 23:36
 * @comment
 */
public class T4_trap {
    public int trap(int[] height) {
        int sum = 0;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                Integer midIdx = stack.pop();
                if (!stack.isEmpty()) {
                    Integer leftIdx = stack.peek();
                    int h = Math.min(height[i], height[leftIdx]) - height[midIdx];
                    int w = i - leftIdx - 1;
                    sum += h * w;
                }
            }
            while (!stack.isEmpty() && height[stack.peek()] == height[i]) {
                stack.pop();
            }
            stack.push(i);
        }

        return sum;
    }
}




















