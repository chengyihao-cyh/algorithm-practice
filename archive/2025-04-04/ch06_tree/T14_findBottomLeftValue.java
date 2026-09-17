package org.review2025spring.ch06_tree;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class T14_findBottomLeftValue {

    public int findBottomLeftValue(TreeNode root) {
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        ArrayList<Integer> level = new ArrayList<>();

        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            level.clear();
            while (size-- > 0) {
                TreeNode curr = queue.poll();
                level.add(curr.val);
                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }
        }
        return level.get(0);
    }
}
