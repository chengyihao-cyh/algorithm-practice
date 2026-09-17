package org.review2025spring.ch06_tree;

public class T10_countNodes {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;

        TreeNode left = root, right = root;
        int depth = 0;
        while (left != null && right != null) {
            left = left.left;
            right = right.right;
            depth++;
        }
        if (left == null && right==null)
            return (int) Math.pow(2, depth) - 1;

        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
