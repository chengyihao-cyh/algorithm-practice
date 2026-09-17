package org.review2024winter.tree;

import java.util.HashMap;
import java.util.Map;

public class T17_buildTree {
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < postorder.length; i++) {
            map.put(inorder[i], i);
        }
        int n = inorder.length;
        return build(inorder, 0, n, postorder, 0, n);
    }

    public TreeNode build(int[] inorder, int inBegin, int inEnd, int[] postorder, int postBegin, int postEnd) {
        if (inEnd - inBegin == 0) {
            return null;
        } else if (inEnd - inBegin == 1) {
            return new TreeNode(inorder[inBegin]);
        }
        int midVal = postorder[postEnd - 1];
        int midIdx = map.get(midVal);
        TreeNode midRoot = new TreeNode(midVal);
        midRoot.left = build(inorder, inBegin, midIdx, postorder, postBegin, postBegin + midIdx - inBegin);
        midRoot.right = build(inorder, midIdx + 1, inEnd, postorder, postBegin + midIdx - inBegin, postEnd - 1);
        return midRoot;
    }
}
