package org.review2024winter.tree;

public class T15_hasPathSum {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        return traversal(root, targetSum);
    }

    public boolean traversal(TreeNode root, int sum) {
        if (root.left == null && root.right == null)
            return root.val == sum;
        if (root.left != null && traversal(root.left, sum - root.val))
            return true;
        return root.right != null && traversal(root.right, sum - root.val);
    }
}
