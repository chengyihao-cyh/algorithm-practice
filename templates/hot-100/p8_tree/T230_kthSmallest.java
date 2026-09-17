/**
 * Practice template for:
 * - 230. Kth Smallest Element in a BST
 *   https://leetcode.cn/problems/kth-smallest-element-in-a-bst/
 */
/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2025/11/8 20:27
 * @comment
 */
public class T230_kthSmallest {
    int count;

    public int kthSmallest(TreeNode root, int k) {
        this.count = k;
        return traversal(root);
    }

    public int traversal(TreeNode root) {
        if (root == null) {
            throw new UnsupportedOperationException("TODO");
        }

        int left = traversal(root.left);
        if (left != -1) {
            return left;
        }

        if (--count == 0) {
            return root.val;
        }

        return traversal(root.right);
    }


}
