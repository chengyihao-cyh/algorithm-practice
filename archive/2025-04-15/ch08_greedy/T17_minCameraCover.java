package org.review2025springAgain.ch08_greedy;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2025/4/7 16:51
 * @comment
 */
public class T17_minCameraCover {
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
        int res = traversal(root);
        if (res == 0) {
            count++;
        }
        return count;
    }

    // 0无覆盖 1有摄像头 2有覆盖
    public int traversal(TreeNode root) {
        if (root == null) return 2;
        int left = traversal(root.left);
        int right = traversal(root.right);

        if (left == 2 && right == 2) {
            // 当前节点无覆盖 等待父节点摄像头
            return 0;
        } else if (left == 0 || right == 0) {
            // 当前节点要装摄像头
            count++;
            return 1;
        } else if (left == 1 || right == 1) {
            // 当前节点被子节点覆盖
            return 2;
        } else {
            return -1;
        }
    }
}
