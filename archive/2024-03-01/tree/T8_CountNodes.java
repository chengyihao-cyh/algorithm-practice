package org.learn2024spring.tree;

public class T8_CountNodes {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int leftNum = countNodes(root.left);
        int rightNum = countNodes(root.right);
        return leftNum + rightNum + 1;
    }

    public int countNodesByFull(TreeNode root) {
        if (root == null)
            return 0;

        int depth = 0;
        TreeNode currL = root, currR = root;
        while (currL != null && currR != null) {
            currL = currL.left;
            currR = currR.right;
            depth++;
        }
        if (currL == null && currR == null)
            return (int) Math.pow(2, depth) - 1;

        int leftNum = countNodes(root.left);
        int rightNum = countNodes(root.right);
        return leftNum + rightNum + 1;
    }
}
