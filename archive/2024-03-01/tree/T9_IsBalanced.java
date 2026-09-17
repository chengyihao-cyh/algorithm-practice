package org.learn2024spring.tree;

public class T9_IsBalanced {
    public boolean isBalanced(TreeNode root) {
        return getHeight(root) == -1 ? false : true;
    }
    public int getHeight(TreeNode root) {
        if (root == null) return 0;

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        if (leftHeight == -1 || rightHeight == -1)
            return -1;
        else if (Math.abs(leftHeight - rightHeight) > 1)
            return -1;
        else
            return 1 + Math.max(leftHeight, rightHeight);
    }
}
