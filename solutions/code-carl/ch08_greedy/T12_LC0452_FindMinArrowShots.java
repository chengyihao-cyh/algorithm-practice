/**
 * Practice template for:
 * - LeetCode 452. Minimum Number of Arrows to Burst Balloons
 *   https://leetcode.cn/problems/minimum-number-of-arrows-to-burst-balloons/
 */
import java.util.Arrays;
import java.util.Map;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2025/4/7 10:11
 * @comment
 */
public class T12_LC0452_FindMinArrowShots {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        int rightBorder = points[0][1];
        int count = 1;

        for (int i = 1; i < points.length; i++) {
            if (points[i][0] <= rightBorder) {
                rightBorder = Math.min(rightBorder, points[i][1]);
            } else {
                rightBorder = points[i][1];
                count++;
            }
        }
        return count;
    }
}
