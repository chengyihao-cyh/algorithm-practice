/**
 * Practice template for:
 * - LeetCode 700. Search in a Binary Search Tree
 *   https://leetcode.cn/problems/search-in-a-binary-search-tree/
 */
public class T20_LC0700_SearchBst {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        } else if (root.val > val) {
            return searchBST(root.left, val);
        } else if (root.val < val) {
            return searchBST(root.right, val);
        } else {
            return root;
        }
    }
}
