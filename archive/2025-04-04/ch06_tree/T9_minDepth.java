package org.review2025spring.ch06_tree;

public class T9_minDepth {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if (root.left == null) return right + 1;
        else if (root.right == null) return left + 1;
        else return Math.min(left, right) + 1;
    }
}
