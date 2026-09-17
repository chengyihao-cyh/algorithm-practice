package org.review2025spring.ch06_tree;

public class T6_invertTree {
    public TreeNode invertTree(TreeNode root) {
        traversal(root);
        return root;
    }
    public void traversal(TreeNode root) {
        if (root == null)
            return;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        traversal(root.left);
        traversal(root.right);
    }
}
