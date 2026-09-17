package org.learn2024winter.monotoneStack;

import java.util.*;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/11/28 17:10
 * @comment
 */
public class T2_nextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        Deque<Integer> stack = new ArrayDeque<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        // 初始化
        int[] res = new int[len1];
        Arrays.fill(res, -1);
        for (int i = 0; i < len1; i++) {
            map.put(nums1[i], i);
        }

        // 单调栈遍历
        for (int i = 0; i < len2; i++) {
            while (!stack.isEmpty() && nums2[i] > nums2[stack.peek()]) {
                Integer pre = nums2[stack.pop()];
                if (map.containsKey(pre)) {
                    res[map.get(pre)] = nums2[i];
                }
            }
            stack.push(i);
        }
        return res;
    }
}
