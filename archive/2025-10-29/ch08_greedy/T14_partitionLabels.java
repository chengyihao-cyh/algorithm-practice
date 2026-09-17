package org.review2025autumn.ch08_greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2025/4/7 11:21
 * @comment
 */
public class T14_partitionLabels {
    public List<Integer> partitionLabels(String s) {
        int[] map = new int[26];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            map[chars[i] - 'a'] = i;
        }

        int leftBorder = 0, rightBorder = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            rightBorder = Math.max(rightBorder, map[chars[i] - 'a']);
            if (i == rightBorder) {
                list.add(i - leftBorder + 1);
                leftBorder = i + 1;
            }
        }
        return list;
    }
}
