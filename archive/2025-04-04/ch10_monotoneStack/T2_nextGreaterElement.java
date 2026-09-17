package org.review2025spring.ch10_monotoneStack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/11/28 17:10
 * @comment
 */
public class T2_nextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[nums1.length];

        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums2[i] > stack.peek()) {
                Integer smaller = stack.pop();
                map.put(smaller, nums2[i]);
            }
            stack.push(nums2[i]);
        }
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.getOrDefault(nums1[i], -1);
        }
        return res;
    }
}
