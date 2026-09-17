package org.rereview2024summer.tree;

import java.util.HashMap;

public class T17_buildTree {
    HashMap<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);
        return build(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }
    public TreeNode build(int[] inorder, int inLeft, int inRight, int[] postorder, int postLeft, int postRight) {
        int len = inRight - inLeft;
        if (len == 0)
            return null;
        TreeNode node = new TreeNode(postorder[postRight - 1]);
        if (len == 1)
            return node;

        int idx = map.get(postorder[postRight - 1]);
        int leftLen = idx - inLeft;
        node.left = build(inorder, inLeft, idx, postorder, postLeft, postLeft + leftLen);
        node.right = build(inorder, idx + 1, inRight, postorder, postLeft + leftLen, postRight - 1);
        return node;
    }
}
