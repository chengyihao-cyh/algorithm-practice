package org.review2025springAgain.ch08_greedy;

import java.util.Arrays;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2025/4/7 10:11
 * @comment
 */
public class T12_findMinArrowShots {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        int count = 1;
        int right = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] <= right) {
                // cover
                right = Math.min(right, points[i][1]);
            } else {
                // not cover
                count++;
                right = points[i][1];
            }
        }
        return count;
    }
}
