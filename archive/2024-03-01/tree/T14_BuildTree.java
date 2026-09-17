package org.learn2024spring.tree;

import java.util.HashMap;
import java.util.Map;

public class T14_BuildTree {
    public TreeNode buildTree1(int[] inorder, int[] postorder) {
        // return bulid(inorder, postorder);
        return bulidByIdx(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }

    // 数组实现
    public TreeNode bulidByArray(int[] inorder, int[] postorder) {
        int len = postorder.length;
        if (len == 0) return null;

        int midElement = postorder[len - 1];
        TreeNode root = new TreeNode(midElement);
        if (len == 1) return root;  // 叶节点

        int idx;
        for (idx = 0; idx < len; idx++)
            if (inorder[idx] == midElement)
                break;

        int[] leftPostOrder = new int[idx];
        int[] leftInOrder = new int[idx];
        int[] rightPostOrder = new int[len - idx - 1];
        int[] rightInOrder = new int[len - idx - 1];

        for (int i = 0; i < idx; i++) {
            leftInOrder[i] = inorder[i];
            leftPostOrder[i] = postorder[i];
        }
        for (int i = idx; i < len - 1; i++) {
            rightInOrder[i - idx] = inorder[i + 1];
            rightPostOrder[i - idx] = postorder[i];
        }

        root.left = bulidByArray(leftInOrder, leftPostOrder);
        root.right = bulidByArray(rightInOrder, rightPostOrder);
        return root;
    }

    // 下标实现
    public TreeNode bulidByIdx(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        int len = postEnd - postStart;
        if (len == 0) return null;

        int midElement = postorder[postEnd - 1];
        TreeNode root = new TreeNode(midElement);
        if (len == 1) return root;  // 叶节点

        int idx;
        for (idx = inStart; idx < inEnd; idx++)
            if (inorder[idx] == midElement)
                break;

        int leftInStart = inStart, leftInEnd = idx, rightInStart = idx + 1, rightInEnd = inEnd;
        int leftPostBegin = postStart, leftPostEnd, rightPostBegin, rightPostEnd = postEnd - 1;

        int leftLen = leftInEnd - leftInStart, rightLen = rightInEnd - rightInStart;
        leftPostEnd = leftPostBegin + leftLen;
        rightPostBegin = rightPostEnd - rightLen;

        root.left = bulidByIdx(inorder, leftInStart, leftInEnd, postorder, leftPostBegin, leftPostEnd);
        root.right = bulidByIdx(inorder, rightInStart, rightInEnd, postorder, rightPostBegin, rightPostEnd);
        return root;
    }


    // 下标 + map 映射实现
    public Map<Integer, Integer> map = new HashMap<>();  // 元素到下标的映射
    public TreeNode buildTree2(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);

        return bulidByMap(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }

    public TreeNode bulidByMap(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        int len = postEnd - postStart;
        if (len == 0) return null;

        int rootVal = postorder[postEnd - 1];
        TreeNode root = new TreeNode(rootVal);
        if (len == 1) return root;  // 叶节点

        int idx = map.get(rootVal);

        int leftLen = idx - inStart;

        root.left = bulidByMap(inorder, inStart, idx, postorder,  postStart, postStart + leftLen);
        root.right = bulidByMap(inorder, idx + 1, inEnd, postorder, postStart + leftLen, postEnd - 1);
        return root;
    }

    // 通过前序遍历和中序遍历 构造树
    Map<Integer, Integer> inMap = new HashMap<>();
    public TreeNode buildTreeByPreIn(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++)
            inMap.put(inorder[i], i);
        return buildByPreIn(preorder, 0, inorder.length, inorder, 0, inorder.length);
    }

    public TreeNode buildByPreIn(int [] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        int len = preEnd - preStart;
        if (len == 0) return null;

        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        if (len == 1) return root;

        int idx = inMap.get(rootVal);
        int leftLen = idx - inStart;

        root.left = buildByPreIn(preorder,preStart + 1, preStart + 1 + leftLen, inorder, inStart, idx);
        root.right = buildByPreIn(preorder,preStart + 1 + leftLen, preEnd, inorder, idx + 1, inEnd);
        return root;
    }

}
