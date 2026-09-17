package org.review2025autumn.ch10_monotoneStack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/11/29 18:59
 * @comment
 */
public class T5_largestRectangleArea {
    public int largestRectangleArea(int[] heights) {
        int[] h = new int[heights.length + 2];
        System.arraycopy(heights, 0, h, 1, heights.length);
        int maxSum = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < h.length; i++) {
            while (!stack.isEmpty() && h[i] < h[stack.peek()]) {
                int y = h[stack.pop()];
                if (!stack.isEmpty()) {
                    int x = i - stack.peek() - 1;
                    maxSum = Math.max(maxSum, x * y);
                }
            }
            if (!stack.isEmpty() && h[stack.peek()] == h[i]) {
                stack.pop();
            }
            stack.push(i);
        }
        return maxSum;
    }
}
