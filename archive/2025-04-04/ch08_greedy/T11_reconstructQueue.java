package org.review2025spring.ch08_greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2025/4/7 09:17
 * @comment
 */
public class T11_reconstructQueue {
    public int[][] reconstructQueue(int[][] people) {
        // 排序
        Arrays.sort(people, (a, b) -> {
            int i = b[0] - a[0];
            if (i == 0) i = a[1] - b[1];
            return i;
        });

        // list插入
        LinkedList<int[]> list = new LinkedList<>();
        for (int i = 0; i < people.length; i++) {
            int[] node = people[i];
            list.add(node[1], node);
        }

        // 返回
        return list.toArray(new int[people.length][2]);
    }
}
