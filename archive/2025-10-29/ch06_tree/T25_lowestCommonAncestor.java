package org.review2025autumn.ch06_tree;

public class T25_lowestCommonAncestor {
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
