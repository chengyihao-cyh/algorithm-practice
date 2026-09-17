package org.rereview2024summer.tree;

public class T21_isValidBST {
    TreeNode preNode = null;
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        if (root.left != null)
            if (!isValidBST(root.left))
                return false;
        if (preNode != null && preNode.val >= root.val)
           return false;
        preNode = root;
        if (root.right != null)
            if (!isValidBST(root.right))
                return false;
        return true;
    }
}
