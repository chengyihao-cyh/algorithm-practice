/**
 * Practice template for:
 * - LeetCode 538. Convert BST to Greater Tree
 *   https://leetcode.cn/problems/convert-bst-to-greater-tree/
 */
public class T30_LC0538_ConvertBst {
    Integer preSum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        convertBST(root.right);
        root.val += preSum;
        preSum = root.val;
        convertBST(root.left);
        return root;
    }
}
