package org.review2025spring.ch06_tree;

public class T27_deleteNode {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else {
            // 删除 root
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                TreeNode curr = root.right;
                while (curr.left != null)
                    curr = curr.left;
                curr.left = root.left;
                return root.right;
            }
        }
        return root;
    }
}