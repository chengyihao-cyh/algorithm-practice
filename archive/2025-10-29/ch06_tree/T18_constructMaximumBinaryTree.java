package org.review2025autumn.ch06_tree;

public class T18_constructMaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length);
    }

    public TreeNode build(int[] nums, int left, int right) {
        if (left >= right) {
            return null;
        } else if (right - left == 1) {
            return new TreeNode(nums[left]);
        }

        int maxIdx = left, maxVal = nums[left];
        for (int i = left + 1; i < right; i++) {
            if (nums[i] > maxVal) {
                maxIdx = i;
                maxVal = nums[i];
            }
        }
        TreeNode root = new TreeNode(maxVal);
        root.left = build(nums, left, maxIdx);
        root.right = build(nums, maxIdx + 1, right);
        return root;
    }
}
