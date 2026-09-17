package org.learn2024spring.tree;

import java.util.ArrayDeque;

public class T3_InvertTree {
    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }
    public void invert(TreeNode root) {
        if (root == null)
            return;

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        invert(root.left);
        invert(root.right);
    }

    public TreeNode invertTreeByLevel(TreeNode root) {
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();

        if (root != null)
            queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode curr = queue.poll();

                TreeNode tmp = curr.left;
                curr.left = curr.right;
                curr.right = tmp;

                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }
        }

        return root;
    }

}
