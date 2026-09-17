package org.review2025spring.ch06_tree;

public class T30_convertBST {

    int postSum = 0;
    public TreeNode convertBST(TreeNode root) {
        if (root == null) return null;
        convertBST(root.right);
        root.val += postSum;
        postSum = root.val;
        convertBST(root.left);
        return root;
    }
}
