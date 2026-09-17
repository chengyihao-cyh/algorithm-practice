package org.review2024summer.tree;

public class T10_countNodes {
    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;
        int leftNum = countNodes(root.left);
        int rightNum = countNodes(root.right);
        return leftNum + rightNum + 1;
    }

    public int countNodesByFull(TreeNode root) {
        if (root == null)
            return 0;
        TreeNode left = root, right = root;
        int depth = 0;
        while (!(left == null || right== null)) {
            depth++;
            left = left.left;
            right = right.right;
        }
        if (left == null && right == null)
            return (int) Math.pow(2, depth) - 1;

        int leftNum = countNodesByFull(root.left);
        int rightNum = countNodesByFull(root.right);
        return leftNum + rightNum + 1;
    }
}
