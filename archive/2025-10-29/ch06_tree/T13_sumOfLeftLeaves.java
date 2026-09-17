package org.review2025autumn.ch06_tree;

public class T13_sumOfLeftLeaves {
    /*    public int sumOfLeftLeaves(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int leftSum = 0, rightSum = 0;
            if (root.left != null && root.left.left == null && root.left.right == null) {
                leftSum = root.left.val;
            } else {
                leftSum = sumOfLeftLeaves(root.left);
            }
            rightSum = sumOfLeftLeaves(root.right);
            return leftSum + rightSum;
        }*/
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            left = root.left.val;
        } else {
            left = sumOfLeftLeaves(root.left);
        }
        int right = sumOfLeftLeaves(root.right);
        return left + right;
    }
}
