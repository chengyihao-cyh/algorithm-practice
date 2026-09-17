/**
 * Practice template for:
 * - LeetCode 337. House Robber III
 *   https://leetcode.cn/problems/house-robber-iii/
 */
/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/11/23 19:22
 * @comment
 */
public class T21_LC0337_Rob {
    public int rob(TreeNode root) {
        int[] res = traversal(root);
        return Math.max(res[0], res[1]);
    }

    public int[] traversal(TreeNode root) {
        if (root == null) {
            return new int[2];
        }
        // 0 no
        // 1 do
        int[] left = traversal(root.left);
        int[] right = traversal(root.right);
        int[] res = new int[2];
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = root.val + left[0] + right[0];
        return res;
    }


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
