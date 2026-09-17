package org.review2025autumn.ch06_tree;

public class T22_getMinimumDifference {
    Integer preVal;
    Integer minDiff = 0x3f3f3f3f;

    public int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return -1;
        }
        traversal(root);
        return minDiff;
    }

    public void traversal(TreeNode root) {
        if (root == null) {
            return;
        }
        traversal(root.left);
        if (preVal != null) {
            minDiff = Math.min(minDiff, root.val - preVal);
        }
        preVal = root.val;
        traversal(root.right);
    }
}
