package org.learn2024winter.monotoneStack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Map;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/11/29 18:59
 * @comment
 */
public class T5_largestRectangleArea {
    public int largestRectangleArea1(int[] heights) {
        int[] newHeights = new int[heights.length + 2];
        System.arraycopy(heights, 0, newHeights, 1, heights.length);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        int res = 0;
        for (int i = 1; i < newHeights.length; i++) {
            while (!stack.isEmpty() && newHeights[i] < newHeights[stack.peek()]) {
                int h = newHeights[stack.pop()];
                if (!stack.isEmpty()) {
                    int w = i - stack.peek() - 1;
                    res = Math.max(res, h * w);
                }
            }
            stack.push(i);
        }
        return res;
    }


    public int largestRectangleArea2(int[] heights) {
        int[] newHeights = new int[heights.length + 2];
        System.arraycopy(heights, 0, newHeights, 1, heights.length);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        int res = 0;
        for (int i = 1; i < newHeights.length; i++) {
            while (!stack.isEmpty() && newHeights[i] < newHeights[stack.peek()]) {
                int h = newHeights[stack.pop()];
                if (!stack.isEmpty()) {
                    int w = i - stack.peek() - 1;
                    res = Math.max(res, h * w);
                }
            }
            stack.push(i);
        }
        return res;
    }
}
