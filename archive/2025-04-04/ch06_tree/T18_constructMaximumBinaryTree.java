package org.review2025spring.ch06_tree;

public class T18_constructMaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length);
    }

    public TreeNode build(int[] nums, int left, int right) {
        if (left == right) return null;

        int maxIdx = left;
        for (int i = left; i < right; i++) {
            if (nums[i] > nums[maxIdx])
                maxIdx = i;
        }
        TreeNode root = new TreeNode(nums[maxIdx]);
        TreeNode leftRoot = build(nums, left, maxIdx);
        TreeNode rightRoot = build(nums, maxIdx + 1, right);
        root.left = leftRoot;
        root.right = rightRoot;
        return root;
    }
}
