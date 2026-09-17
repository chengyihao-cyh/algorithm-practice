/**
 * Practice template for:
 * - LeetCode 235. Lowest Common Ancestor of a Binary Search Tree
 *   https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-search-tree/
 */
public class T25_LC0235_LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return find(root, Math.min(p.val, q.val), Math.max(p.val, q.val));
    }

    public TreeNode find(TreeNode root, int min, int max) {
        if (root == null) {
            return null;
        } else if (root.val < min) {
            return find(root.right, min, max);
        } else if (root.val > max) {
            return find(root.left, min, max);
        } else {
            return root;
        }
    }
}
