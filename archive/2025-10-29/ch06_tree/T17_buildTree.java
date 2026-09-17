package org.review2025autumn.ch06_tree;

import java.util.HashMap;
import java.util.Map;

public class T17_buildTree {
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }

    public TreeNode build(int[] inorder, int inL, int inR, int[] postorder, int postL, int postR) {
        if (inL >= inR) {
            return null;
        } else if (inR - inL == 1) {
            return new TreeNode(inorder[inL]);
        }
        int midVal = postorder[postR - 1];
        Integer midIdx = map.get(midVal);
        TreeNode root = new TreeNode(midVal);
        root.left = build(inorder, inL, midIdx, postorder, postL, postL + midIdx - inL);
        root.right = build(inorder, midIdx + 1, inR, postorder, postL + midIdx - inL, postR - 1);
        return root;
    }

}
