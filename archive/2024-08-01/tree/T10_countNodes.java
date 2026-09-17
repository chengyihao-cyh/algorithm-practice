package org.rereview2024summer.tree;

public class T10_countNodes {
    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;
        int leftNum = isFull(root.left);
        int rightNum = isFull(root.right);
        if (leftNum == -1)
            leftNum = countNodes(root.left);
        if (rightNum == -1)
            rightNum = countNodes(root.right);
        return leftNum + rightNum + 1;
    }
    public int isFull(TreeNode root) {
        TreeNode left = root;
        TreeNode right = root;
        int depth = 0;
        while (left != null && right != null) {
            left = left.left;
            right = right.right;
            depth++;
        }
        if (left == null && right == null) {
            return (int)Math.pow(2, depth) - 1;
        } else {
            return -1;
        }
    }
}
