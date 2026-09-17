package org.rereview2024summer.tree;

import java.util.ArrayList;
import java.util.List;

public class T2_preorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        traversal(root, list);
        return list;
    }
    public void traversal(TreeNode root, List<Integer> list) {
        if (root == null)
            return;
        list.add(root.val);
        traversal(root.left, list);
        traversal(root.right, list);
    }
}
