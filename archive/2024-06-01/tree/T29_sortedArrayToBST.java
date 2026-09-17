package org.review2024summer.tree;

public class T29_sortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        // 坚持左闭右闭 [left, right]
        return traversal(nums, 0, nums.length - 1);
    }
    public TreeNode traversal(int[] nums, int left, int right) {
        if (left > right)
            return null;
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(mid);
        root.left = traversal(nums, left, mid - 1);
        root.right = traversal(nums, mid + 1, right);
        return root;
    }
}
