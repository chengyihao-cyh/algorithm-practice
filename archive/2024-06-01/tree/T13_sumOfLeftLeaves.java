package org.review2024summer.tree;

import java.util.ArrayDeque;

public class T13_sumOfLeftLeaves {
    public int sumOfLeftLeavesByRes(TreeNode root) {
        return traversal(root);
    }

    public int traversal(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 0;

        int leftSum = traversal(root.left);
        if (root.left != null && root.left.left == null && root.left.right == null)
            leftSum = root.left.val;
        int rightSum = traversal(root.right);

        return leftSum + rightSum;
    }

    public int sumOfLeftLeavesByIter(TreeNode root) {
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        int sum = 0;
        if (root != null)
            queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode curr = queue.poll();
                if (curr.left != null && curr.left.left == null && curr.left.right == null)
                    sum += curr.left.val;
                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }
        }

        return sum;
    }
}
