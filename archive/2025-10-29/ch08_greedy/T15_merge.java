package org.review2025autumn.ch08_greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2025/4/7 14:44
 * @comment
 */
public class T15_merge {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int leftBorder = intervals[0][0];
        int rightBorder = intervals[0][1];

        List<int[]> list = new ArrayList<>();
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= rightBorder) {
                rightBorder = Math.max(rightBorder, intervals[i][1]);
            } else {
                list.add(new int[]{leftBorder, rightBorder});
                leftBorder = intervals[i][0];
                rightBorder = intervals[i][1];
            }
        }
        list.add(new int[]{leftBorder, rightBorder});
        return list.toArray(int[][]::new);
    }
}
