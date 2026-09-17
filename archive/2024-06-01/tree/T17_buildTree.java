package org.review2024summer.tree;

import java.util.HashMap;
import java.util.Map;

public class T17_buildTree {
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree_post(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);
        int len = inorder.length;
        return build_post(inorder, 0, len, postorder, 0, len);
    }

    public TreeNode build_post(int[] inorder, int inBegin, int inEnd, int[] postorder, int postBegin, int postEnd) {
        int len = inEnd - inBegin;
        if (len == 0)
            return null;

        TreeNode root = new TreeNode(postorder[postEnd - 1]);
        if (len == 1)
            return root;
        Integer idx = map.get(postorder[postEnd - 1]);
        int leftLen = idx - inBegin;
        root.left = build_post(inorder, inBegin, idx, postorder, postBegin, postBegin + leftLen);
        root.right = build_post(inorder, idx + 1, inEnd, postorder, postBegin + leftLen, postEnd - 1);
        return root;
    }

    public TreeNode buildTree_pre(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);
        int len = inorder.length;
        return build_pre(preorder, 0, len, inorder, 0, len);
    }

    public TreeNode build_pre(int[] preorder, int preBegin, int preEnd, int[] inorder, int inBegin, int inEnd) {
        int len = inEnd - inBegin;
        if (len == 0)
            return null;

        TreeNode root = new TreeNode(preorder[preBegin]);
        if (len == 1)
            return root;
        int idx = map.get(preorder[preBegin]);
        int leftLen = idx - inBegin;
        root.left = build_pre(preorder, preBegin + 1, preBegin + 1 + leftLen, inorder, inBegin, idx);
        root.right = build_pre(preorder, preBegin + 1 +leftLen, preEnd, inorder, idx + 1, inEnd);
        return root;
    }
}
