package org.review2024winter.tree;

public class T20_searchBST {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        else if (val > root.val) return searchBST(root.right, val);
        else if (val < root.val) return searchBST(root.left, val);
        else return root;
    }
}
