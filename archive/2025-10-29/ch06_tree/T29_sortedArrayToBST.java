package org.review2025autumn.ch06_tree;

public class T29_sortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length);
    }

    private TreeNode build(int[] nums, int left, int right) {
        if (right - left == 1) {
            return new TreeNode(nums[left]);
        } else if (right - left <= 0) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = build(nums, left, mid);
        root.right = build(nums, mid + 1, right);
        return root;
    }
}
