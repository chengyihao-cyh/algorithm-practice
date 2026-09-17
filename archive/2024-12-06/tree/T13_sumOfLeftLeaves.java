package org.review2024winter.tree;

public class T13_sumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return 0;
        int leftSum, rightSum;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            leftSum = root.left.val;
        } else {
            leftSum = sumOfLeftLeaves(root.left);
        }
        rightSum = sumOfLeftLeaves(root.right);
        return leftSum + rightSum;
    }
}
