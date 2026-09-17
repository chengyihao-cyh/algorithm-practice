package org.rereview2024summer.tree;

public class T14_findBottomLeftValue {
    int maxDepth = -1;
    int bottomLeftValue = -1;
    public int findBottomLeftValue(TreeNode root) {
        traversal(root, 1);
        return bottomLeftValue;
    }
    public void traversal(TreeNode root, int depth) {
        if (root == null)
            return;
        if (root.left == null && root.right == null && depth > maxDepth) {
            bottomLeftValue = root.val;
            maxDepth = depth;
        }
        traversal(root.left, depth + 1);
        traversal(root.right, depth + 1);
    }
}
