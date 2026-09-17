package org.review2024summer.tree;

public class T27_deleteNode {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            // solution1: key not found
            return null;
        if (root.val == key) {
            if (root.left == root.right) {
                // solution2: root is a leave
                return null;
            } else if (root.left == null && root.right != null) {
                // solution3: root's left is null, return its right to father
                return root.right;
            } else if (root.left != null && root.right == null) {
                // solution4: root's right is null, return its left to father
                return root.left;
            } else {
                // solution5: both left and right not null
                // put left tree to right tree's bottom left child's left
                // then return right tree's root
                TreeNode bottomLeft = root.right;
                while (bottomLeft.left != null)
                    bottomLeft = bottomLeft.left;
                bottomLeft.left = root.left;
                return root.right;
            }
        }

        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }
}