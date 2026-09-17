package org.review2024winter.tree;

public class T8_maxDepth {
    public int maxDepth(NodeWithChild root) {
        if (root == null) return 0;
        else if (root.children == null) return 1;

        int max = 0;
        for (NodeWithChild child : root.children) {
            max = Math.max(max, maxDepth(child));
        }
        return max + 1;
    }
}
