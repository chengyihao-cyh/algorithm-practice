package org.rereview2024summer.tree;

public class T15_hasPathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null)
            return false;
        if (root.left == null && root.right == null)
            return targetSum == root.val;
        if (root.left != null)
            if (hasPathSum(root.left, targetSum - root.val))
                return true;
        if (root.right != null)
            if (hasPathSum(root.right, targetSum - root.val))
                return true;
        return false;
    }
}
