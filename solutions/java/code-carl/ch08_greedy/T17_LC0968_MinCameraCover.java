/**
 * Practice template for:
 * - LeetCode 968. Binary Tree Cameras
 *   https://leetcode.cn/problems/binary-tree-cameras/
 */
/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2025/4/7 16:51
 * @comment
 */
public class T17_LC0968_MinCameraCover {
    public class TreeNode {
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

    int count = 0;
    public int minCameraCover(TreeNode root) {
        int rootVal = traversal(root);
        if (rootVal == 0) {
            count++;
        }
        return count;
    }

    public int traversal(TreeNode root) {
        // 0 未被覆盖
        // 1 有摄像头
        // 2 被覆盖
        if (root == null) {
            return 2;
        }
        int left = traversal(root.left);
        int right = traversal(root.right);
        if (left == 0 || right == 0) {
            count++;
            return 1;
        } else if (left == 1 || right == 1) {
            return 2;
        } else if (left == 2 && right == 2) {
            return 0;
        } else {
            return -1;
        }
    }

}
