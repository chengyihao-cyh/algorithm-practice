package org.review2025autumn.ch06_tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class T14_findBottomLeftValue {

    public int findBottomLeftValue(TreeNode root) {
        if (root == null) {
            return -1;
        }

        int res = root.val;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            res = deque.peek().val;
            while (size -- > 0) {
                TreeNode curr = deque.poll();
                if (curr.left != null) {
                    deque.offer(curr.left);
                }
                if (curr.right != null) {
                    deque.offer(curr.right);
                }
            }
        }
        return res;
    }
}
