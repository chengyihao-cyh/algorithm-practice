package org.rereview2024summer.tree;

public class T22_getMinimumDifference {
    TreeNode preNode = null;
    int minMinus = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        traversal(root);
        return minMinus;
    }
    public void traversal(TreeNode root) {
        if (root == null)
            return;
        traversal(root.left);
        if (preNode != null)
            minMinus = Math.min(minMinus, Math.abs(root.val - preNode.val));
        preNode = root;
        traversal(root.right);
    }
}
