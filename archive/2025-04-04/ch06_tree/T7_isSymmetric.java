package org.review2025spring.ch06_tree;

public class T7_isSymmetric {
    public boolean isSymmetric(TreeNode root) {
        return traversal(root.left, root.right);
    }

    public boolean traversal(TreeNode left, TreeNode right) {
        if ((left == null && right != null) || (left != null && right == null)) return false;
        else if (left == null && right == null) return true;
        else if (left.val != right.val) return false;
        else return traversal(left.left, right.right) && traversal(left.right, right.left);
    }
}
