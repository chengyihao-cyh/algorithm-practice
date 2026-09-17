package org.review2025autumn.ch06_tree;

public class T30_convertBST {
    Integer preSum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        convertBST(root.right);
        root.val += preSum;
        preSum = root.val;
        convertBST(root.left);
        return root;
    }
}
