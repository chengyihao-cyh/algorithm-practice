package org.review2024summer.tree;

public class T30_convertBST {
    int preSum = 0;
    public TreeNode convertBST(TreeNode root) {
        traversal(root);
        return root;
    }
    public void traversal(TreeNode root) {
        if (root == null)
            return;
        traversal(root.right);
        preSum += root.val;
        root.val = preSum;
        traversal(root.left);
    }
}
