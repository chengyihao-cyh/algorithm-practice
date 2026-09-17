package org.learn2024spring.tree;

import java.util.*;

// 说明用两个的原因
public class T1_OrderTraversal {
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


    // 明白先right后left
    public List<Integer> preorderTraversalByIter (TreeNode root) {
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();

        if (root == null)
            return res;

        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode tmp = stack.pop();
            res.add(tmp.val);
            if (tmp.right != null) stack.push(tmp.right);
            if (tmp.left != null) stack.push(tmp.left);

        }
        return res;
    }

    // 明白
    public List<Integer> postorderTraversalByIter (TreeNode root) {
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();

        if (root == null)
            return res;

        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode tmp = stack.pop();
            res.add(tmp.val);
            if (tmp.left != null) stack.push(tmp.left);
            if (tmp.right != null) stack.push(tmp.right);
        }

        Collections.reverse(res);
        return res;
    }

    public List<Integer> inorderTraversalByIter (TreeNode root) {
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();

        TreeNode curr = root;
        // 仅当!(stack.isEmpty && curr == null)
        while (!stack.isEmpty() || curr != null) {
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

    public List<Integer> preorderTraversalByNull (TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();

        if (root != null)
            stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode curr = stack.peek();
            if (curr != null) {
                stack.pop();
                if (curr.right != null) stack.push(curr.right);
                if (curr.left != null) stack.push(curr.left);
                stack.push(curr);
                stack.push(null);
            } else {
                stack.pop();
                curr = stack.peek();
                stack.pop();
                res.add(curr.val);
            }
        }

        return res;
    }

    public List<Integer> postorderTraversalByNull (TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();

        if (root != null)
            stack.push(root);

        while (!stack.empty()) {
            TreeNode curr = stack.peek();
            if (curr != null) {
                stack.pop();

                stack.push(curr);
                stack.push(null);

                if (curr.right != null) stack.push(curr.right);
                if (curr.left != null) stack.push(curr.left);
            } else {
                stack.pop();
                curr = stack.peek();
                stack.pop();
                res.add(curr.val);
            }
        }

        return res;
    }


    public List<Integer> inorderTraversalByNull (TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();

        if (root !=null)
            stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode curr = stack.peek();
            if (curr != null) {
                stack.pop();
                if (curr.right != null) stack.push(curr.right);
                stack.push(curr);
                stack.push(null);
                if (curr.left != null) stack.push(curr.left);
            } else {
                stack.pop();
                curr = stack.pop();
                res.add(curr.val);
            }
        }

        return res;
    }

    public List<Integer> post (TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();

        if (root != null)
            stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode curr = stack.peek();
            if (curr != null) {
                stack.pop();

                stack.push(curr);
                stack.push(null);
                if (curr.right != null) stack.push(curr.right);
                if (curr.left != null) stack.push(curr.left);
            } else {
                stack.pop();
                curr = stack.pop();
                res.add(curr.val);
            }
        }

        return res;
    }


}





















