/**
 * Practice template for:
 * - LeetCode 701. Insert into a Binary Search Tree
 *   https://leetcode.cn/problems/insert-into-a-binary-search-tree/
 */
public class T26_LC0701_InsertIntoBst {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (root.val < val) {
            root.right = insertIntoBST(root.right, val);
        } else if (root.val > val) {
            root.left = insertIntoBST(root.left, val);
        }
        return root;
    }
}
