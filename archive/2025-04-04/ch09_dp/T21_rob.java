package org.review2025spring.ch09_dp;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/11/23 19:22
 * @comment
 */
public class T21_rob {
    public int rob(TreeNode root) {
        int[] res = robAction(root);
        return Math.max(res[0], res[1]);
    }

    public int[] robAction(TreeNode root) {
        if (root == null) return new int[2];
        int[] left = robAction(root.left);
        int[] right = robAction(root.right);
        int[] res = new int[2];
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = root.val + left[0] + right[0];
        return res;
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

