package org.review2024summer.tree;

public class T20_searchBST {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val)
            return root;

        if (val < root.val)
            return searchBST(root.left, val);
        else
            return searchBST(root.right, val);
    }

    public TreeNode searchBSTByIter(TreeNode root, int val) {
        while (root != null) {
            if (root.val > val)
                root = root.left;
            else if (root.val < val)
                root = root.right;
            else
                break;
        }
        return root;
    }
}
