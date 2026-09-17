package org.review2024summer.tree;

import java.util.LinkedList;

public class T7_isSymmetric {
    public boolean isSymmetric(TreeNode root) {
        return compare(root.left, root.right);
    }

    public boolean compare(TreeNode left, TreeNode right) {
        if ((left == null && right != null) || (left != null && right == null))
            return false;
        else if (left == null && right == null)
            return true;
        else if (left.val != right.val)
            return false;

        boolean compareOutside = compare(left.left, right.right);
        boolean compareInside = compare(left.right, right.left);
        return compareOutside && compareInside;
    }

    public boolean isSymmetricByQueue(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offerFirst(root.left);
        queue.offerLast(root.right);
        while (!queue.isEmpty()) {
            TreeNode left = queue.pollFirst();
            TreeNode right = queue.pollLast();
            if (left == null && right == null) {
                continue;
            } else if ((left == null && right != null) || (left != null && right == null) || (left.val != right.val)) {
                return false;
            }
            queue.offerFirst(left.right);
            queue.offerFirst(left.left);
            queue.offerLast(right.left);
            queue.offerLast(right.right);
        }
        return true;
    }
}
