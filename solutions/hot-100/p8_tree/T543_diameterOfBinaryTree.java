/**
 * Practice template for:
 * - 543. Diameter of Binary Tree
 *   https://leetcode.cn/problems/diameter-of-binary-tree/
 */
/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2025/11/7 17:55
 * @comment
 */
public class T543_diameterOfBinaryTree {
    int ans = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        getDepth(root);
        return ans;
    }

    public int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = getDepth(root.left);
        int right = getDepth(root.right);
        ans = Math.max(ans, left + right);
        return Math.max(left, right) + 1;
    }
}
