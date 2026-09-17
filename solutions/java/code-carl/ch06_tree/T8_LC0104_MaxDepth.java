/**
 * Practice template for:
 * - LeetCode 104. Maximum Depth of Binary Tree
 *   https://leetcode.cn/problems/maximum-depth-of-binary-tree/
 */
public class T8_LC0104_MaxDepth {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }
}
