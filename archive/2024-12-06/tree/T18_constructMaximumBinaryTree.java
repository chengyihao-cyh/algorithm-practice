package org.review2024winter.tree;

import java.util.PriorityQueue;

public class T18_constructMaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length);
    }

    public TreeNode build(int[] nums, int begin, int end) {
        if (end - begin == 0) {
            return null;
        } else if (end - begin == 1) {
            return new TreeNode(nums[begin]);
        }

        int maxVal = Integer.MIN_VALUE;
        int maxIdx = -1;
        for (int i = begin; i < end; i++) {
            if (nums[i] > maxVal) {
                maxIdx = i;
                maxVal = nums[i];
            }
        }
        TreeNode root = new TreeNode(maxVal);
        root.left = build(nums, begin, maxIdx);
        root.right = build(nums, maxIdx + 1, end);
        return root;
    }
}
