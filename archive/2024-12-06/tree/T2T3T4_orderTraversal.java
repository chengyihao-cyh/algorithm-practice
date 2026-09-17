package org.review2024winter.tree;

import java.util.*;

public class T2T3T4_orderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorder(root, list);
        return list;
    }

    public void preorder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        list.add(root.val);
        preorder(root.left, list);
        preorder(root.right, list);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return list;
    }

    public void inorder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postorder(root, list);
        return list;
    }

    public void postorder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        postorder(root.left, list);
        postorder(root.right, list);
        list.add(root.val);
    }

    public List<Integer> preorderTraversalByIter(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            res.add(curr.val);
            // stack 不允许压入 null
            if (curr.left != null) stack.push(curr.right);
            if (curr.right != null) stack.push(curr.left);
        }
        return res;
    }

    public List<Integer> postorderTraversalByIter(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            res.add(curr.val);
            // 中右左
            if (curr.right != null) stack.push(curr.left);
            if (curr.left != null) stack.push(curr.right);
        }

        // 左右中
        Collections.reverse(res);
        return res;
    }

    public List<Integer> inorderTraversalByIter(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        TreeNode curr = root;
        while (!(stack.isEmpty() && curr == null)) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                curr = stack.pop();
                res.add(curr.val);
                curr = curr.right;
            }
        }
        return res;
    }

    public List<Integer> inorderTraversalByMonitor(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            if (curr.val != -1) {
                if (curr.right != null) stack.push(curr.right);
                stack.push(curr);
                stack.push(new TreeNode(-1));
                if (curr.left != null) stack.push(curr.left);
            } else {
                res.add(stack.pop().val);
            }
        }
        return res;
    }

    public List<Integer> preorderTraversalByMonitor(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            if (curr.val != -1) {
                if (curr.right != null) stack.push(curr.right);
                if (curr.left != null) stack.push(curr.left);
                stack.push(curr);
                stack.push(new TreeNode(-1));
            } else {
                res.add(stack.pop().val);
            }
        }
        return res;
    }

    public List<Integer> postorderTraversalByMonitor(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            if (curr.val != -1) {
                stack.push(curr);
                stack.push(new TreeNode(-1));
                if (curr.right != null) stack.push(curr.right);
                if (curr.left != null) stack.push(curr.left);
            } else {
                res.add(stack.pop().val);
            }
        }
        return res;
    }

}
