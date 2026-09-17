package org.learn2024spring.tree;

public class T6_maxDepth {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return 1 + Math.max(leftDepth, rightDepth);
    }

    public int maxDepth(Node root) {
        if (root == null)
            return 0;
        int depth = 0;
        if (root.children != null)
            for (Node chil : root.children) {
                int curr = maxDepth(chil);
                depth = Math.max(curr, depth);
            }
        return depth + 1;
    }
}
