package org.review2025autumn.ch08_greedy;

import java.util.Arrays;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2025/4/7 10:52
 * @comment
 */
public class T13_eraseOverlapIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int count = 0;
        int rightBorder = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < rightBorder) {
                rightBorder = Math.min(rightBorder, intervals[i][1]);
                count++;
            } else {
                rightBorder = intervals[i][1];
            }
        }
        return count;
    }
}
