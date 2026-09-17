package org.learn2024spring.tree;

import java.util.HashMap;
import java.util.PriorityQueue;

public class T15_MaxTree {

    // 失败实现
    HashMap<Integer, Integer> map = new HashMap<>();
    PriorityQueue<Integer> maxQueue = new PriorityQueue<>((a, b) -> b - a);
    public TreeNode constructMaximumBinaryTree1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
            maxQueue.offer(nums[i]);
        }
        return bulid1(nums, 0, nums.length);
    }
    public TreeNode bulid1(int[] nums, int start, int end) {
        int len = end - start;
        if (len == 0) return null;

        int maxVal = maxQueue.poll();
        TreeNode root = new TreeNode(maxVal);
        if (len == 1) return root;

        int idx = map.get(maxVal);
        root.left = bulid1(nums, start, idx);
        root.right = bulid1(nums, idx + 1, end);
        return root;
    }


    // 弃用大顶堆
    public TreeNode constructMaximumBinaryTree2(int[] nums) {
        return bulid2(nums, 0, nums.length);
    }
    public TreeNode bulid2(int[] nums, int start, int end) {
        int len = end - start;
        if (len == 0) return null;
        if (len == 1) return new TreeNode(nums[start]);

        int maxVal = nums[start];
        int idx = start;
        for (int i = start + 1; i < end; i++)
            if (nums[i] > maxVal){
                maxVal = nums[i];
                idx = i;
            }

        TreeNode root = new TreeNode(maxVal);
        root.left = bulid2(nums, start, idx);
        root.right = bulid2(nums, idx + 1, end);
        return root;
    }
}
