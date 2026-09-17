package org.review2024summer.tree;

public class T9_minDepth {
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;

        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);

        if (leftDepth == 0) {
            return rightDepth + 1;
        } else if (rightDepth == 0) {
            return leftDepth + 1;
        } else {
            return Math.min(leftDepth, rightDepth) + 1;
        }
    }
}
