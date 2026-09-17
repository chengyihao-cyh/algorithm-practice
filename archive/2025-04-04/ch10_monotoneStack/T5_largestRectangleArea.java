package org.review2025spring.ch10_monotoneStack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/11/29 18:59
 * @comment
 */
public class T5_largestRectangleArea {
    public int largestRectangleArea(int[] heights) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int[] tmp = new int[heights.length + 2];
        System.arraycopy(heights, 0, tmp, 1, heights.length);
        heights = tmp;

        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                Integer leftIdx = stack.pop();
                int h = Math.min(heights[i], heights[stack.peek()]);
                int w = leftIdx - stack.peek() - 1;
                res = Math.max(res, h * w);
            }
            stack.push(i);
        }




        return res;
    }
}
