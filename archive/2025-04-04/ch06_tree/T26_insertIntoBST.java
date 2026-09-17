package org.review2025spring.ch06_tree;

public class T26_insertIntoBST {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val);
        if (val > root.val) {
            root.right = insertIntoBST(root.right, val);
        } else if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        }
        return root;
    }
}
