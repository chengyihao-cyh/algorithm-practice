package org.learn2024spring.tree;

public class T13_1_HasPathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null)
            return false;
        return traversal(root, 0, targetSum);
    }

    public boolean traversal(TreeNode root, int currSum, int targetSum) {
        if (root.left == null && root.right == null) {
            currSum += root.val;
            if (currSum == targetSum)
                return true;
            else
                return false;
        }

        boolean hasLeftPath = false, hasRightPath = false;
        if (root.left != null){
            currSum += root.val;
            hasLeftPath = traversal(root.left, currSum, targetSum);
            currSum -= root.val;
        }
        if (root.right != null){
            currSum += root.val;
            hasRightPath =  traversal(root.right, currSum, targetSum);
            currSum += root.val;
        }

        return hasLeftPath || hasRightPath;
    }

    // 找到问题
    // boolean hasPath = false;
    public boolean hasPathSumFailed(TreeNode root, int targetSum) {
        if (root == null)
            return false;
        traversalFailed(root, 0, targetSum);
        return hasPath;
    }

    public void traversalFailed(TreeNode root, int currSum, int targetSum) {
        if (hasPath == true)
            return;

        if (root == null) {
            if (currSum == targetSum)
                hasPath = true;
            return;
        }

        traversalFailed(root.left, currSum + root.val, targetSum);
        traversalFailed(root.right, currSum + root.val, targetSum);
    }


    // 改进版
    boolean hasPath = false;
    public boolean hasPathSumPlus(TreeNode root, int targetSum) {
        if (root == null)
            return false;
        traversalPlus(root, 0, targetSum);
        return hasPath;
    }

    public void traversalPlus(TreeNode root, int currSum, int targetSum) {
        if (hasPath == true)
            return;

        if (root.left == null && root.right == null) {
            currSum += root.val;
            if (currSum == targetSum)
                hasPath = true;
            return;
        }

        if (root.left != null)
            traversalPlus(root.left, currSum + root.val, targetSum);
        if (root.right != null)
            traversalPlus(root.right, currSum + root.val, targetSum);
    }

    public boolean hasPathSum_Lu(TreeNode root, int targetsum) {
        if (root == null) {
            return false;
        }
        targetsum -= root.val;
        // 叶子结点
        if (root.left == null && root.right == null) {
            return targetsum == 0;
        }
        if (root.left != null) {
            boolean left = hasPathSum_Lu(root.left, targetsum);
            if (left) {      // 已经找到
                return true;
            }
        }
        if (root.right != null) {
            boolean right = hasPathSum_Lu(root.right, targetsum);
            if (right) {     // 已经找到
                return true;
            }
        }
        return false;
    }
}

