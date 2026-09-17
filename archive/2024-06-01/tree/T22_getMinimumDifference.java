package org.review2024summer.tree;

public class T22_getMinimumDifference {
    int min = Integer.MAX_VALUE;
    TreeNode preNode = null;
    public int getMinimumDifference(TreeNode root) {
        if (root == null) return 0;
        traversal(root);
        return min;
    }
    public void traversal(TreeNode root) {
        if (root == null)
            return;
        traversal(root.left);
        if (preNode != null) {
            min = Math.min(min, Math.abs(root.val - preNode.val));
        }
        preNode = root;
        traversal(root.right);
    }
}
