package org.learn2024spring.tree;

public class T11_sumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 0;

        int leftNum = sumOfLeftLeaves(root.left);
        int rightNum = sumOfLeftLeaves(root.right);
        int plusNum = 0;
        if (root.left != null && root.left.left == null && root.left.right == null)
            plusNum = root.left.val;

        int sum = leftNum + rightNum + plusNum;
        return sum;
    }

    public int sumOfLeftLeaves2(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 0;

        int leftNum = sumOfLeftLeaves2(root.left);
        if (root.left != null && root.left.left == null && root.left.right == null)
            leftNum = root.left.val;
        int rightNum = sumOfLeftLeaves2(root.right);

        int sum = leftNum + rightNum;
        return sum;
    }
}
