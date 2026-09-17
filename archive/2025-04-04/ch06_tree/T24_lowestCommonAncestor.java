package org.review2025spring.ch06_tree;

public class T24_lowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        else if (root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null && right != null) return right;
        else if (left != null && right == null) return left;
        else if (left != null && right != null) return root;
        else return null;
    }
}
