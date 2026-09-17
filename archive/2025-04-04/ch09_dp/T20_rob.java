package org.review2025spring.ch09_dp;

import org.review2025spring.ch11_graph.T17_Trie;

import java.util.*;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/11/23 18:27
 * @comment
 */
public class T20_rob {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);

        return Math.max(
                robAction(nums, 0, nums.length - 1),
                robAction(nums, 1, nums.length)
        );
    }

    public int robAction(int[] nums, int start, int end) {
        int pre = nums[start], post = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i < end; i++) {
            int tmp = Math.max(post, pre + nums[i]);
            pre = post;
            post = tmp;
        }
        return post;
    }

    public int[] diStringMatch(String s) {
        int[] res = new int[s.length() + 1];
        LinkedList<Integer> list = new LinkedList<>();
        list.add(0);

        for (int i = 1; i <= s.length(); i++) {
            if (s.charAt(i - 1) == 'I') {
                Integer max = list.getLast();
                res[i] = max + 1;
                list.offerLast(max + 1);
            } else {
                Integer min = list.getFirst();
                res[i] = min - 1;
                list.offerFirst(min - 1);
            }
        }
        int min = list.getFirst();
        for (int i = 0; i < res.length; i++) {
            res[i] -= min;
        }
        return res;
    }

    public int[] diStringMatch2(String s) {
        int[] res = new int[s.length() + 1];
        int min = 0, max = 0;

        for (int i = 1; i <= s.length(); i++) {
            if (s.charAt(i - 1) == 'I') {
                res[i] = ++max;
            } else {
                res[i] = --min;
            }
        }
        for (int i = 0; i < res.length; i++) {
            res[i] -= min;
        }
        return res;
    }
}
