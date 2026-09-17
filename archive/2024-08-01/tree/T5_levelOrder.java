package org.rereview2024summer.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class T5_levelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        traversal(root, res);
        return res;
    }
    public void traversal(TreeNode root, List<List<Integer>> res) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        if (root != null)
            queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
                level.add(node.val);
            }
            res.add(level);
        }
    }
}
