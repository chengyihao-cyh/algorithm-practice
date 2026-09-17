package org.review2025springAgain.ch10_monotoneStack;

import java.util.ArrayDeque;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/11/29 18:59
 * @comment
 */
public class T5_largestRectangleArea {
    public int largestRectangleArea(int[] heights) {
        int[] newHeights = new int[heights.length + 2];
        System.arraycopy(heights, 0, newHeights, 1, heights.length);
        heights = newHeights;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int res = 0;

        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                int h = heights[stack.pop()];
                int w = i - stack.peek() - 1;
                res = Math.max(res, h * w);
            }
            stack.push(i);
        }
        return res;
    }
}
