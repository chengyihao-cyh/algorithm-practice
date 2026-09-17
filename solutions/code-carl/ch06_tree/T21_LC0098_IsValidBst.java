/**
 * Practice template for:
 * - LeetCode 98. Validate Binary Search Tree
 *   https://leetcode.cn/problems/validate-binary-search-tree/
 */
public class T21_LC0098_IsValidBst {
    Integer preVal = null;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST(root.left)) {
            return false;
        }
        if (preVal != null && preVal >= root.val) {
            return false;
        }
        preVal = root.val;
        return isValidBST(root.right);
    }
}
