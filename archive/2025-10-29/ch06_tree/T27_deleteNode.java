package org.review2025autumn.ch06_tree;

public class T27_deleteNode {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.left == null) {
            return root.right;
        } else if (root.right == null) {
            return root.left;
        } else {
            TreeNode rightBottom = root.right;
            while (rightBottom.left != null) {
                rightBottom = rightBottom.left;
            }
            rightBottom.left = root.left;
            return root.right;
        }

        return root;
    }
}