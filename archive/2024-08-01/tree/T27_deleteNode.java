package org.rereview2024summer.tree;

public class T27_deleteNode {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left == null && root.right != null){
                return root.right;
            } else if (root.left != null && root.right == null) {
                return root.left;
            } else {
                TreeNode tmp = root.right;
                while (tmp.left != null)
                    tmp = tmp.left;
                tmp.left = root.left;
                return root.right;
            }
        }
        return root;
    }
}
