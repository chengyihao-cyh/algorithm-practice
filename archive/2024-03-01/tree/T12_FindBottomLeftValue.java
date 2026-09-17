package org.learn2024spring.tree;

public class T12_FindBottomLeftValue {

    int maxDepth = Integer.MIN_VALUE;
    int bottomValue = -1;
    public int findBottomLeftValue(TreeNode root) {
        if (root == null)
            return 0;
        traversal(root, 0);
        return bottomValue;
    }
    public void traversal(TreeNode root, int depth) {
        if (root.left == null && root.right == null)
            if (depth > maxDepth) {
                bottomValue = root.val;
                maxDepth = depth;
            }

        if (root.left != null)
            traversal(root.left, depth + 1);
        if (root.right != null)
            traversal(root.right, depth + 1);
    }


    public int findBottomLeftValue0(TreeNode root) {
        findBottom0(root, 0, 0, -1);
        return 0;
    }

    public int findBottom0(TreeNode root, int depth, int maxDepth, int bottomLeftValue) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return root.val;

        if (root.left != null)
            findBottom0(root.left, depth + 1, maxDepth, bottomLeftValue);

        if (root.right != null)
            findBottom0(root.right, depth + 1, maxDepth, bottomLeftValue);


        return 0;
    }


}
