/**
 * Practice template for:
 * - LeetCode 112. Path Sum
 *   https://leetcode.cn/problems/path-sum/
 */
public class T15_LC0112_HasPathSum {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return backtracking(root, targetSum);
    }

    public boolean backtracking(TreeNode root, int sum) {
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }

        if (root.left != null) {
            if (backtracking(root.left, sum - root.val)) {
                return true;
            }
        }
        if (root.right != null) {
            return backtracking(root.right, sum - root.val);
        }
        return false;
    }

}
