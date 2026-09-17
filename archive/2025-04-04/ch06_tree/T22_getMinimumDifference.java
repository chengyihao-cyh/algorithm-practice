package org.review2025spring.ch06_tree;

public class T22_getMinimumDifference {

    Integer preVal = null;
    int minDiff = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        traversal(root);
        return minDiff;
    }

    public void traversal(TreeNode root) {
        if (root == null)
            return;
        traversal(root.left);
        if (preVal != null)
            minDiff = Math.min(minDiff, root.val - preVal);
        preVal = root.val;
        traversal(root.right);
    }
}
