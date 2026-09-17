package org.review2024summer.tree;

import java.util.*;

public class T2T3T4_orderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorder(root, list);
        return list;
    }

    public void preorder(TreeNode root, List<Integer> list) {
        if (root == null)
            return;
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
        if (root == null)
            return;
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
        if (root == null)
            return;
        postorder(root.left, list);
        postorder(root.right, list);
        list.add(root.val);
    }

    public List<Integer> preorderTraversalByIter(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        if (root == null)
            return list;

        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode tmp = stack.pop();
            list.add(tmp.val);
            if (tmp.right != null)
                stack.push(tmp.right);
            if (tmp.left != null)
                stack.push(tmp.left);
        }
        return list;
    }

    public List<Integer> postorderTraversalByIter(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        if (root == null)
            return list;

        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode tmp = stack.pop();
            list.add(tmp.val);
            if (tmp.left != null)
                stack.push(tmp.left);
            if (tmp.right != null)
                stack.push(tmp.right);
        }
        Collections.reverse(list);
        return list;
    }

    public List<Integer> inorderTraversalByIter(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        if (root == null)
            return list;

        TreeNode curr = root;
        while (!(curr == null && stack.isEmpty())) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                curr = stack.pop();
                list.add(curr.val);
                curr = curr.right;
            }
        }

        return list;
    }

    public List<Integer> inorderTraversalByMonitor(TreeNode root) {
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        ArrayList<Integer> list = new ArrayList<>();
        final int VISITED = Integer.MAX_VALUE;
        if (root == null)
            return list;

        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            if (curr.val != VISITED) {
                if (curr.right != null) {stack.push(curr.right);}
                stack.push(curr);
                stack.push(new TreeNode(VISITED));
                if (curr.left != null) {stack.push(curr.left);}
            } else {
                list.add(stack.pop().val);
            }
        }
        return list;
    }

    public List<Integer> preorderTraversalByMonitor(TreeNode root) {
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        ArrayList<Integer> list = new ArrayList<>();
        final int VISITED = Integer.MAX_VALUE;
        if (root == null)
            return list;

        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            if (curr.val != VISITED) {
                if (curr.right != null) {stack.push(curr.right);}
                if (curr.left != null) {stack.push(curr.left);}
                stack.push(curr);
                stack.push(new TreeNode(VISITED));
            } else {
                list.add(stack.pop().val);
            }
        }
        return list;
    }

    public List<Integer> postorderTraversalByMonitor(TreeNode root) {
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        ArrayList<Integer> list = new ArrayList<>();
        final int VISITED = Integer.MAX_VALUE;
        if (root == null)
            return list;

        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            if (curr.val != VISITED) {
                stack.push(curr);
                stack.push(new TreeNode(VISITED));
                if (curr.right != null) {stack.push(curr.right);}
                if (curr.left != null) {stack.push(curr.left);}
            } else {
                list.add(stack.pop().val);
            }
        }
        return list;
    }





}
