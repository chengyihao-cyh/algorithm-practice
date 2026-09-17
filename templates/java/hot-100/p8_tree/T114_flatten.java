/**
 * Practice template for:
 * - 114. Flatten Binary Tree to Linked List
 *   https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/
 */
/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2025/11/7 18:08
 * @comment
 */
public class T114_flatten {
    public void flatten(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                TreeNode bottom = curr.left;
                while (bottom.right != null) {
                    bottom = bottom.right;
                }
                bottom.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
    }
}
