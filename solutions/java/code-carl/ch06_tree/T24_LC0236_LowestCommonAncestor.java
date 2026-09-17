/**
 * Practice template for:
 * - LeetCode 236. Lowest Common Ancestor of a Binary Tree
 *   https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/
 */
public class T24_LC0236_LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        } else if (root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null && right == null) {
            return null;
        } else if (left != null && right ==null) {
            return left;
        } else if (right != null && left == null ) {
            return right;
        } else {
            return root;
        }
    }
}
