package org.review2024winter.monotoneStack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/11/28 17:10
 * @comment
 */
public class T2_nextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] res = new int[nums1.length];
        Arrays.fill(res, -1);
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], i);
        }

        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums2[i] > nums2[stack.peek()]) {
                int preVal = nums2[stack.pop()];
                if (map.containsKey(preVal)) {
                    res[map.get(preVal)] = nums2[i];
                }
            }
            stack.push(i);
        }

        return res;
    }
}
