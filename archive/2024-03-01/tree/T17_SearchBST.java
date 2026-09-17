package org.learn2024spring.tree;

public class T17_SearchBST {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null)
            return null;
        if (root.val == val)
            return root;

        TreeNode node;

        if (root.val > val)
            node = searchBST(root.left, val);
        else
            node = searchBST(root.right, val);

        return node;
    }

    public TreeNode searchBST2(TreeNode root, int val) {
        if (root == null || root.val == val)
            return root;

        if (root.val > val)
            return searchBST2(root.left, val);
        else
            return searchBST2(root.right, val);
    }

}
