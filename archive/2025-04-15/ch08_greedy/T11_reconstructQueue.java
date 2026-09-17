package org.review2025springAgain.ch08_greedy;

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
        LinkedList<int[]> queue = new LinkedList<>();
        Arrays.sort(people, (a, b) -> {
            int compare = Integer.compare(b[0], a[0]);
            if (compare == 0) compare = Integer.compare(a[1], b[1]);
            return compare;
        });
        for (int i = 0; i < people.length; i++) {
            queue.add(people[i][1], people[i]);
        }
        return queue.toArray(new int[queue.size()][2]);
    }
}
