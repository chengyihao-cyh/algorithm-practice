package org.learn2024spring.tree;

import java.util.Deque;
import java.util.LinkedList;

public class T4_IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        return compare(root.left, root.right);
    }
    public boolean compare(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;
        else if ((left == null && right != null) || (left != null && right == null) || (left.val != right.val))
            return false;
        boolean compareOutside = compare(left.left, right.right);
        boolean compareInside = compare(left.right, right.left);
        return compareOutside && compareInside;
    }

    public boolean isSymmetricByQueue(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offerFirst(root.left);
        queue.offerLast(root.right);
        while (!queue.isEmpty()) {
            TreeNode left = queue.pollFirst();
            TreeNode right =queue.pollLast();
            if (left == null && right == null)
                continue;
            else if ((left == null && right != null) || (left != null && right == null) || (left.val != right.val))
                return false;
            queue.offerFirst(left.right);
            queue.offerFirst(left.left);
            queue.offerLast(right.left);
            queue.offerLast(right.right);
        }
        return true;
    }

    public boolean isSymmetricByStack(TreeNode root) {
        Deque<TreeNode> stackLeft = new LinkedList<>();
        Deque<TreeNode> stackRight = new LinkedList<>();
        stackLeft.push(root.left);
        stackRight.push(root.right);

        while (!stackLeft.isEmpty() || !stackRight.isEmpty()) {
            TreeNode left = stackLeft.pop();
            TreeNode right =stackRight.pop();
            if (left == null && right == null)
                continue;
            else if ((left == null && right != null) || (left != null && right == null) || (left.val != right.val))
                return false;
            stackLeft.push(left.right);
            stackLeft.push(left.left);
            stackRight.push(right.left);
            stackRight.push(right.right);
        }
        return true;
    }
}
