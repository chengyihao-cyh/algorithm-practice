package org.rereview2024summer.tree;

public class T11_isBalanced {
    public boolean isBalanced(TreeNode root) {
        return getDepth(root) != -1;
    }
    public int getDepth(TreeNode root) {
        if (root == null)
            return 0;
        int leftDepth = getDepth(root.left);
        if (leftDepth == -1)
            return -1;
        int rightDepth = getDepth(root.right);
        if (rightDepth == -1)
            return -1;
        if (Math.abs(leftDepth - rightDepth) > 1)
            return -1;
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
