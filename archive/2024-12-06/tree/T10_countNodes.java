package org.review2024winter.tree;

public class T10_countNodes {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;

        TreeNode currL = root, currR = root;
        int d = 0;
        while (currL != null && currR != null) {
            currL = currL.left;
            currR = currR.right;
            d++;
        }
        if (currL == null && currR == null) return (int) Math.pow(2, d) - 1;
        else return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
