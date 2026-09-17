package org.review2024summer.tree;

public class T28_trimBST {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null)
            return null;
        if (root.val < low) {
            TreeNode right = trimBST(root.right, low, high);
            return right;
        }
        if (root.val > high) {
            TreeNode left = trimBST(root.left, low, high);
            return left;
        }

        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }
}
