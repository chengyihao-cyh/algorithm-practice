package org.review2025spring.ch08_greedy;

import java.util.*;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2025/4/7 11:21
 * @comment
 */
public class T14_partitionLabels {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            map.put(chars[i], i);
        }

        List<Integer> list = new ArrayList<>();
        int cover = 0;
        int preIdx = -1;

        for (int i = 0; i < chars.length; i++) {
            cover = Math.max(cover, map.get(chars[i]));
            if (cover == i) {
                list.add(i - preIdx);
                preIdx = i;
            }
        }

        return list;
    }

    public List<Integer> partitionLabels2(String s) {
        int[] map = new int[26];
        char[] chs = s.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            map[chs[i] - 'a'] = i;
        }

        List<Integer> list = new ArrayList<>();
        int right = 0;
        int left = -1;

        for (int i = 0; i < chs.length; i++) {
            right = Math.max(right, map[chs[i] - 'a']);
            if (right == i) {
                list.add(i - left);
                left = i;
            }
        }

        return list;
    }
}
