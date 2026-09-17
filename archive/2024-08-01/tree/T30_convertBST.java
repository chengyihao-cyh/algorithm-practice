package org.rereview2024summer.tree;

public class T30_convertBST {
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        traversal(root);
        return root;
    }
    public void traversal(TreeNode root) {
        if (root == null)
            return;
        traversal(root.right);
        sum += root.val;
        root.val = sum;
        traversal(root.left);
    }
}
