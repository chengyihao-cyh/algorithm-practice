package org.review2024summer.tree;

public class T6_invertTree {
    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }
    public void invert (TreeNode root) {
        if (root == null)
            return;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invert(root.left);
        invert(root.right);
    }
}
