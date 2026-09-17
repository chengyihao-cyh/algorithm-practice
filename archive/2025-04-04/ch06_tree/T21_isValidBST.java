package org.review2025spring.ch06_tree;


public class T21_isValidBST {
    Integer preVal = null;

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;

        boolean left = isValidBST(root.left);
        if (!left) return false;

        if (preVal != null && preVal >= root.val)
            return false;
        preVal = root.val;

        return isValidBST(root.right);
    }
}
