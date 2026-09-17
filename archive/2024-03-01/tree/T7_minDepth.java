package org.learn2024spring.tree;

public class T7_minDepth {
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;

        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);

        // 左树为空 取右树高度 + 1
        if (root.left == null && root.right != null)
            return rightDepth + 1;
        // 右树为空 取左树高度 + 1
        else if (root.right == null && root.left != null)
            return leftDepth + 1;
        // 一般结点
        else
            return 1 + Math.min(leftDepth, rightDepth);
    }

}
