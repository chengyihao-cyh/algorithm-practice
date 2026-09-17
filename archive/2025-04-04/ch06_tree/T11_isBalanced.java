package org.review2025spring.ch06_tree;

public class T11_isBalanced {
    public boolean isBalanced(TreeNode root) {
        return traversal(root) != -1;
    }

    public int traversal(TreeNode root) {
        if (root == null) return 0;
        int left = traversal(root.left);
        if (left == -1) return -1;
        int right = traversal(root.right);
        if (right == -1 || Math.abs(left - right) > 1) return -1;
        else return Math.max(left, right) + 1;
    }

}
