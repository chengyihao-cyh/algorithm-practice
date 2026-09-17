package org.review2024winter.monotoneStack;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/11/28 20:44
 * @comment
 */
public class T3_nextGreaterElements {
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        Arrays.fill(res, -1);
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < 2 * len; i++) {
            while (!stack.isEmpty() && nums[i % len] > nums[stack.peek()]) {
                int preIdx = stack.pop();
                res[preIdx] = nums[i % len];
            }
            stack.push(i % len);
        }
        return res;
    }
}
