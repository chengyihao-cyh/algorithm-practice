package org.review2024summer.tree;

import java.util.ArrayDeque;

public class T8_maxDepth {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public int maxDepth(NodeWithChild root) {
        if (root == null)
            return 0;
        int depth = 0;
        for (NodeWithChild child : root.children)
            depth = Math.max(depth, maxDepth(child));
        return depth + 1;
    }

    public int maxDepthByLevel(NodeWithChild root) {
        ArrayDeque<NodeWithChild> queue = new ArrayDeque<>();
        int depth = 0;
        if (root != null)
            queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            while (size-- > 0) {
                NodeWithChild curr = queue.poll();
                if (curr.children != null)
                    queue.addAll(curr.children);
            }
        }
        return depth;
    }
}
