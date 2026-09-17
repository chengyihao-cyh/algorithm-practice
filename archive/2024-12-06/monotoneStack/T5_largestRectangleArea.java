package org.review2024winter.monotoneStack;

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
        int len = heights.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int[] tmp = heights;
        heights = new int[len + 2];
        System.arraycopy(tmp, 0, heights, 1, len);
        int res = 0;
        for (int i = 0; i < len + 2; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                int h = heights[stack.pop()];
                if (!stack.isEmpty()) {
                    int w = i - stack.peek() - 1;
                    res = Math.max(res, h * w);
                }
            }
            if (!stack.isEmpty() && heights[i] == heights[stack.peek()]) {
                stack.pop();
            }
            stack.push(i);
        }
        return res;
    }
}
