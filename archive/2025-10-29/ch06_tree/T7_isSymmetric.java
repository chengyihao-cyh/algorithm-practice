package org.review2025autumn.ch06_tree;

public class T7_isSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return compare(root.left, root.right);
    }

    public boolean compare(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left == null && right != null
                || left != null && right == null) {
            return false;
        } else if (left.val != right.val) {
            return false;
        }

        boolean leftFlag = compare(left.left, right.right);
        if (!leftFlag) {
            return false;
        }
        return compare(left.right, right.left);
    }

}
