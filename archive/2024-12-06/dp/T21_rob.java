package org.review2024winter.dp;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/11/23 19:22
 * @comment
 */
public class T21_rob {
    public int rob(TreeNode root) {
        int[] dp = robAction(root);
        return Math.max(dp[0], dp[1]);
    }

    public int[] robAction(TreeNode root) {
        if (root == null)
            return new int[2];
        int[] left = robAction(root.left);
        int[] right = robAction(root.right);
        int[] dp = new int[2];
        // dp[0] 不偷当前
        // dp[1] 偷当前
        dp[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        dp[1] = root.val + left[0] + right[0];
        return dp;
    }


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

