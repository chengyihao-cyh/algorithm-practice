package org.review2025spring.ch08_greedy;

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

        // 滑动
        List<int[]> list = new ArrayList<>();
        int left = intervals[0][0], right = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= right) {
                // 重叠
                right = Math.max(right, intervals[i][1]);
            } else {
                // 没重叠
                list.add(new int[]{left, right});
                left = intervals[i][0];
                right = intervals[i][1];
            }
        }
        list.add(new int[]{left, right});

        // 返回
        return list.toArray(new int[list.size()][]);
    }
}
