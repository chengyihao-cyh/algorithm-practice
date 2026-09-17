package org.review2025spring.ch06_tree;

public class T15_hasPathSum {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        return traversal(root, targetSum);
    }

    public boolean traversal(TreeNode root, int sum) {
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }
        boolean left = false, right = false;
        if (root.left != null) {
            left = traversal(root.left, sum - root.val);
            if (left) {
                return true;
            }
        }
        if (root.right != null) {
            right = traversal(root.right, sum - root.val);
        }
        return right;
    }

}
