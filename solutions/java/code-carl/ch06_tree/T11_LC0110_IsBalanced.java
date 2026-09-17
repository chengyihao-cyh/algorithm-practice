/**
 * Practice template for:
 * - LeetCode 110. Balanced Binary Tree
 *   https://leetcode.cn/problems/balanced-binary-tree/
 */
public class T11_LC0110_IsBalanced {
    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }

    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftH = getHeight(root.left);
        if (leftH == -1) {
            return -1;
        }
        int rightH = getHeight(root.right);
        if (rightH == -1) {
            return -1;
        }
        if (Math.abs(leftH - rightH) > 1) {
            return -1;
        }

        return Math.max(leftH, rightH) + 1;
    }

}
