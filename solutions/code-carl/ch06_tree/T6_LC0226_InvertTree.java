/**
 * Practice template for:
 * - LeetCode 226. Invert Binary Tree
 *   https://leetcode.cn/problems/invert-binary-tree/
 */
public class T6_LC0226_InvertTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

}
