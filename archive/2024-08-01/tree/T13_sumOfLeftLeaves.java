package org.rereview2024summer.tree;

public class T13_sumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 0;
        int leftSum;
        int rightSum;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            leftSum = root.left.val;
        } else {
            leftSum = sumOfLeftLeaves(root.left);
        }
        rightSum = sumOfLeftLeaves(root.right);
        return leftSum + rightSum;
    }
}
