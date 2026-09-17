/**
 * Practice template for:
 * - 124. Binary Tree Maximum Path Sum
 *   https://leetcode.cn/problems/binary-tree-maximum-path-sum/
 */
/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2025/11/9 16:48
 * @comment
 */
public class T124_maxPathSum {
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        traversal(root);
        return max;
    }

    public int traversal(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = traversal(root.left);
        int right = traversal(root.right);
        //  左右都过
        max = Math.max(max, left + right + root.val);
        //  只取一边 或 都不取
        int tmpMax = Math.max(root.val, Math.max(left, right) + root.val);
        max = Math.max(max, tmpMax);
        return tmpMax;
    }
}
