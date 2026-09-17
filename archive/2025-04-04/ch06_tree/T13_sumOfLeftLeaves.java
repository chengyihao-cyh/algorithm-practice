package org.review2025spring.ch06_tree;

public class T13_sumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        int left;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            left = root.left.val;
        } else {
            left = sumOfLeftLeaves(root.left);
        }
        return left + sumOfLeftLeaves(root.right);
    }
}
