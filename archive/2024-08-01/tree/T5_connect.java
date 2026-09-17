package org.rereview2024summer.tree;

import java.util.ArrayDeque;
import java.util.List;

public class T5_connect {
/*    public NodeWithNext connect(NodeWithNext root) {
        traversal(root);
        return root;
    }
    public void traversal(NodeWithNext root) {
        ArrayDeque<NodeWithNext> queue = new ArrayDeque<>();
        if (root != null)
            queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            NodeWithNext preNodeWithNext = null;
            while (size-- > 0) {
                NodeWithNext node = queue.poll();
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
                if (preNodeWithNext != null)
                    preNodeWithNext.next = node;
                preNodeWithNext = node;
            }
        }
    }

    class NodeWithChild {
        public int val;
        public List<org.rereview2024summer.tree.NodeWithChild> children;

        public NodeWithChild() {}

        public NodeWithChild(int _val) {
            val = _val;
        }

        public NodeWithChild(int _val, List<org.rereview2024summer.tree.NodeWithChild
                > _children) {
            val = _val;
            children = _children;
        }
    }*/
}

