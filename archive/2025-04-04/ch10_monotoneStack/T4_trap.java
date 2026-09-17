package org.review2025spring.ch10_monotoneStack;

import java.util.ArrayDeque;
import java.util.Map;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/11/28 23:36
 * @comment
 */
public class T4_trap {
    public int trap(int[] height) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int sum = 0;

        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                Integer midIdx = stack.pop();
                if (stack.peek() != null) {
                    Integer leftIdx = stack.peek();
                    int w = i - leftIdx - 1;
                    int h = Math.min(height[leftIdx], height[i]) - height[midIdx];
                    sum += w * h;
                }
            }
            if (!stack.isEmpty() && height[i] == height[stack.peek()])
                stack.pop();
            stack.push(i);
        }
        return sum;
    }
}




















