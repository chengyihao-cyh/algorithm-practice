package org.review2024summer.tree;

public class T21_isValidBST {
    public boolean isValidBST_false(TreeNode root) {
        if (root == null)
            return true;
        if (root.left != null && root.left.val >= root.val)
            return false;
        if (root.right != null && root.right.val <= root.val)
            return false;

        boolean leftValid = isValidBST(root.left);
        boolean rightValid = isValidBST(root.right);
        return leftValid && rightValid;
    }

    TreeNode preNode = null;
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        // left
        boolean leftValid = isValidBST(root.left);
        if (!leftValid)
            return false;
        // mid
        if (preNode != null && preNode.val >= root.val)
            return false;
        else
            preNode = root;
        // right
        return  isValidBST(root.right);
    }





}
