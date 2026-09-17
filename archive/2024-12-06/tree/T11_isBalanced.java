package org.review2024winter.tree;

public class T11_isBalanced {
    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }

    public int getHeight(TreeNode root) {
        if (root == null) return 0;
        int leftH, rightH;
        if (((leftH = getHeight(root.left)) == -1) || ((rightH = getHeight(root.right)) == -1))
            return -1;
        return Math.abs(leftH - rightH) <= 1 ? Math.max(leftH, rightH) +1 : -1;
    }
}
