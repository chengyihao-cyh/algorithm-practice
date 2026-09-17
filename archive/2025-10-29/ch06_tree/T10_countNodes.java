package org.review2025autumn.ch06_tree;

public class T10_countNodes {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int h = 0;
        TreeNode left = root, right = root;
        while (left != null && right != null) {
            left = left.left;
            right = right.right;
            h++;
        }
        if (left == null && right == null) {
            return (int) Math.pow(2, h) - 1;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
