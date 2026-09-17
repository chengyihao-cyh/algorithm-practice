package org.review2024winter.tree;

public class T14_findBottomLeftValue {
    int maxDepth = 0;
    int res = 0;

    public int findBottomLeftValue(TreeNode root) {
        traversal(root, 1);
        return res;
    }

    public void traversal(TreeNode root, int depth) {
        if (root == null)
            return;
        if (root.left == null && root.right == null && depth > maxDepth) {
            maxDepth = depth;
            res = root.val;
            return;
        }
        traversal(root.left, depth + 1);
        traversal(root.right, depth + 1);
    }
}
