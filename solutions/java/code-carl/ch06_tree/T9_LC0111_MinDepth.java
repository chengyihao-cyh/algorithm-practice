/**
 * Practice template for:
 * - LeetCode 111. Minimum Depth of Binary Tree
 *   https://leetcode.cn/problems/minimum-depth-of-binary-tree/
 */
public class T9_LC0111_MinDepth {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if (left == 0) {
            return right + 1;
        } else if (right == 0) {
            return left + 1;
        } else {
            return Math.min(left, right) + 1;
        }
    }
}
