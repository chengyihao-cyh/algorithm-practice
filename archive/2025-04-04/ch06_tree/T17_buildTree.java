package org.review2025spring.ch06_tree;

import java.util.HashMap;

public class T17_buildTree {
    HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }

    public TreeNode build(int[] inorder, int inBegin, int inEnd, int[] postorder, int postBegin, int postEnd) {
        if (inEnd - inBegin == 0) {
            return null;
        }
        int midIdx = map.get(postorder[postEnd - 1]);
        TreeNode root = new TreeNode(postorder[postEnd - 1]);
        int leftLen = midIdx - inBegin;
        TreeNode left = build(inorder, inBegin, midIdx, postorder, postBegin, postBegin + leftLen);
        TreeNode right = build(inorder, midIdx + 1, inEnd, postorder, postBegin + leftLen, postEnd - 1);
        root.left = left;
        root.right = right;
        return root;
    }
}
