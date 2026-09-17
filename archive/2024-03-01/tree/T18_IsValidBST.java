package org.learn2024spring.tree;

public class T18_IsValidBST {
    public boolean isValidBSTFailed(TreeNode root) {
        if (root.left == null && root.right == null)
            return true;
        else if (root.left != null && root.right == null && root.val > root.left.val)
            return isValidBSTFailed(root.left);
        else if (root.right != null && root.left == null && root.val < root.right.val)
            return isValidBSTFailed(root.right);
        else if (root.right != null && root.left != null && root.val > root.left.val && root.val < root.right.val)
            return isValidBSTFailed(root.left) && isValidBSTFailed(root.right);
        else
            return false;
    }

    static int LEFT = 1;
    static int RIGHT = 2;
    boolean flag = true;
    public boolean isValidBST(TreeNode root) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

        if (root == null)
            return false;
        if (root.left != null)
            max = traversal(root.left, LEFT);
        if (root.right != null)
            min = traversal(root.right, RIGHT);

        if (root.val < min && root.val > max)
            return flag;

        return false;
    }

    public int traversal(TreeNode root, int direct) {
        int max =root.val , min = root.val;

        if (root.left == null && root.right == null) {
            max = root.val;
            min = root.val;
        }

        if (root.left != null){
            max = traversal(root.left, LEFT);
            if (root.val < max)
                flag = false;
        }

        if (root.right != null){
            min = traversal(root.right, RIGHT);
            if (root.val > min)
                flag = false;
        }

        if (direct == LEFT)
            return max;
        else
            return min;
    }


}
