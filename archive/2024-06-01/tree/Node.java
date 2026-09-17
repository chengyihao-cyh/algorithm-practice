package org.review2024summer.tree;
import java.util.*;

public class Node {
}

class NodeWithChild {
    public int val;
    public List<NodeWithChild> children;

    public NodeWithChild() {}

    public NodeWithChild(int _val) {
        val = _val;
    }

    public NodeWithChild(int _val, List<NodeWithChild
            > _children) {
        val = _val;
        children = _children;
    }
}

class NodeWithNext {
    public int val;
    public NodeWithNext left;
    public NodeWithNext right;
    public NodeWithNext next;

    public NodeWithNext() {}

    public NodeWithNext(int _val) {
        val = _val;
    }

    public NodeWithNext(int _val, NodeWithNext _left, NodeWithNext _right, NodeWithNext _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};