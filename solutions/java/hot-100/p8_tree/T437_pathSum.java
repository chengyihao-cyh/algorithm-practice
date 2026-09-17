/**
 * Practice template for:
 * - 437. Path Sum III
 *   https://leetcode.cn/problems/path-sum-iii/
 */
import java.util.HashMap;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2025/11/9 16:34
 * @comment
 */
public class T437_pathSum {
    int count = 0;
    HashMap<Long, Integer> map = new HashMap<>();

    public int pathSum(TreeNode root, int targetSum) {
        map.put(0L, 1);
        traversal(root, 0, targetSum);
        return count;
    }

    public void traversal(TreeNode root, long preSum, int target) {
        if (root == null) {
            return;
        }

        preSum += root.val;
        if (map.containsKey(preSum - target)) {
            count += map.get(preSum - target);
        }
        map.put(preSum, map.getOrDefault(preSum, 0) + 1);

        traversal(root.left, preSum , target);
        traversal(root.right, preSum , target);

        map.put(preSum, map.get(preSum) - 1);
        preSum -= root.val;

    }
}
