package org.review2024summer.tree;

import java.util.ArrayDeque;

public class T14_findBottomLeftValue {
    int maxDepth = -1;
    int bottomValue = -1;
    public int findBottomLeftValueByCons(TreeNode root) {
        traversal(root, 0);
        return bottomValue;
    }

    public void traversal(TreeNode root, int depth) {
        if (root == null)
            return;

        // 最深的叶节点
        if (root.left == null && root.right == null && depth > maxDepth) {
            maxDepth = depth;
            bottomValue = root.val;
        }
        traversal(root.left, depth + 1);
        traversal(root.right, depth + 1);
    }

    public int findBottomLeftValueByIter(TreeNode root) {
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        int bottomLeftValue = -1;
        if (root != null)
            queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean isLeft = true;
            while (size-- > 0) {
                TreeNode curr = queue.poll();
                if (isLeft && curr.left == null && curr.right == null) {
                    bottomLeftValue = curr.val;
                    isLeft = false;
                }
                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }
        }
        return bottomLeftValue;
    }
}
