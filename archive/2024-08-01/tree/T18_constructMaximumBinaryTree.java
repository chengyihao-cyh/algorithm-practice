package org.rereview2024summer.tree;

public class T18_constructMaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0)
            return null;
        return construct(nums, 0, nums.length);
    }
    public TreeNode construct(int[] nums, int left, int right) {
        int len = right - left;
        if (len == 0)
            return null;
        if (len == 1)
            return new TreeNode(nums[left]);
        int maxValue = Integer.MIN_VALUE;
        int maxIdx = 1;
        for (int i = left; i < right; i++) {
            if (nums[i] > maxValue) {
                maxValue = nums[i];
                maxIdx = i;
            }
        }
        TreeNode node = new TreeNode(maxValue);
        node.left = construct(nums, left, maxIdx);
        node.right = construct(nums, maxIdx + 1, right);
        return node;
    }
}
