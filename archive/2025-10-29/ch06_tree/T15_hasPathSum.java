package org.review2025autumn.ch06_tree;

public class T15_hasPathSum {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return backtracking(root, targetSum);
    }

    public boolean backtracking(TreeNode root, int sum) {
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }

        if (root.left != null) {
            if (backtracking(root.left, sum - root.val)) {
                return true;
            }
        }
        if (root.right != null) {
            return backtracking(root.right, sum - root.val);
        }
        return false;
    }

}
