package org.review2025spring.ch08_greedy;

import java.util.Arrays;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2025/4/7 10:11
 * @comment
 */
public class T12_findMinArrowShots {
    public int findMinArrowShots(int[][] points) {
        // 按照左边界排序
        Arrays.sort(points, (a,b)->Integer.compare(a[0],b[0]));

        // 射箭
        int count = 1;
        int rightBorder = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] <= rightBorder) {
                // 重叠
                rightBorder = Math.min(rightBorder, points[i][1]); // 更新右边界
            } else {
                // 没重叠
                count++;
                rightBorder = points[i][1]; // 替换右边界
            }
        }
        return count;
    }
}
