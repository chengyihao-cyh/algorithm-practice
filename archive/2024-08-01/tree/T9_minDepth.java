package org.rereview2024summer.tree;

public class T9_minDepth {
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;

        int leftDepth = minDepth(root.left) + 1;
        int rightDepth = minDepth(root.right) + 1;
        if (root.left == null && root.right != null)
            return rightDepth;
        if (root.right == null && root.left != null)
            return leftDepth;
        return Math.min(leftDepth, rightDepth);
    }
}
