package org.review2024summer.tree;

public class T18_constructMaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums, 0, nums.length);
    }

    public TreeNode construct(int[] nums, int begin, int end) {
        int max = Integer.MIN_VALUE;
        int idx = -1;
        int len = end - begin;
        if (len == 0)
            return null;

        for (int i = begin; i < end; i++) {
            if (nums[i] > max) {
                max = nums[i];
                idx = i;
            }
        }
        TreeNode root = new TreeNode(nums[idx]);
        if (len == 1)
            return root;
        root.left = construct(nums, begin, idx);
        root.right = construct(nums, idx + 1, end);
        return root;
    }
}
