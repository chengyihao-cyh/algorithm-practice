/**
 * Practice template for:
 * - LeetCode 530. Minimum Absolute Difference in BST
 *   https://leetcode.cn/problems/minimum-absolute-difference-in-bst/
 */
public class T22_LC0530_GetMinimumDifference {
    Integer preVal;
    Integer minDiff = 0x3f3f3f3f;

    public int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return -1;
        }
        traversal(root);
        return minDiff;
    }

    public void traversal(TreeNode root) {
        if (root == null) {
            return;
        }
        traversal(root.left);
        if (preVal != null) {
            minDiff = Math.min(minDiff, root.val - preVal);
        }
        preVal = root.val;
        traversal(root.right);
    }
}
