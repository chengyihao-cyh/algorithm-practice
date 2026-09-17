package org.review2025springAgain.ch10_monotoneStack;

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
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int len = nums.length;
        int[] res = new int[len];
        Arrays.fill(res, -1);

        for (int i = 0; i < 2 * len; i++) {
            while (!stack.isEmpty() && nums[i % len] > nums[stack.peek()]) {
                res[stack.pop()] = nums[i % len];
            }
            stack.push(i % len);
        }
        return res;
    }
}
