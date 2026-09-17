/**
 * Practice template for:
 * - LeetCode 406. Queue Reconstruction by Height
 *   https://leetcode.cn/problems/queue-reconstruction-by-height/
 */
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2025/4/7 09:17
 * @comment
 */
public class T11_LC0406_ReconstructQueue {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> {
            int compare = Integer.compare(b[0], a[0]);
            return compare == 0 ? Integer.compare(a[1], b[1]) : compare;
        });

        List<int[]> list = new LinkedList<>();
        for (int[] node : people) {
            list.add(node[1], node);
        }
        return list.toArray(int[][]::new);
    }
}
