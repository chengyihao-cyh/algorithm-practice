package org.review2024winter.tree;

import java.util.*;

public class T5_levelOrder {
    public List<List<Integer>> levelOrderByIter(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) return res;

        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            while (size-- > 0) {
                TreeNode curr = queue.poll();
                level.add(curr.val);
                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }
            res.add(level);
        }
        return res;
    }

    public List<List<Integer>> levelOrderByRes(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        orderByRes(root, 0, res);
        return res;
    }

    public void orderByRes(TreeNode root, int depth, List<List<Integer>> res) {
        if (res.size() == depth)
            res.add(new ArrayList<>());
        res.get(depth).add(root.val);
        if (root.left != null) orderByRes(root.left, depth + 1, res);
        if (root.right != null) orderByRes(root.right, depth + 1, res);
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            while (size-- > 0) {
                TreeNode curr = queue.poll();
                level.add(curr.val);
                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }
            res.add(level);
        }
        Collections.reverse(res);
        return res;
    }

    public List<Integer> rightSideView(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode curr = queue.poll();
                if (size == 0) res.add(curr.val);
                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }
        }
        return res;
    }

    public List<Double> averageOfLevels(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        List<Double> res = new ArrayList<>();

        if (root == null) return res;

        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            while (size-- > 0) {
                TreeNode curr = queue.poll();
                level.add(curr.val);
                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }
            res.add(level.stream().mapToInt(a -> a).average().getAsDouble());
        }
        return res;
    }

    public List<List<Integer>> levelOrder(NodeWithChild root) {
        Deque<NodeWithChild> queue = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            while (size-- > 0) {
                NodeWithChild curr = queue.poll();
                level.add(curr.val);
                if (curr.children != null) {
                    queue.addAll(curr.children);
                }
            }
            res.add(level);
        }
        return res;
    }

    public List<Integer> largestValues(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();

        if (root == null) return res;

        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            while (size-- > 0) {
                TreeNode curr = queue.poll();
                max = Math.max(max, curr.val);
                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }
            res.add(max);
        }
        return res;
    }

    public NodeWithNext connect(NodeWithNext root) {
        Deque<NodeWithNext> queue = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) return root;

        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            while (size-- > 0) {
                NodeWithNext curr = queue.poll();
                if (size != 0) {
                    curr.next = queue.peek();
                } else {
                    curr.next = null;
                }
                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }
        }
        return root;
    }

    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null) return 1 + minDepth(root.right);
        else if (root.right == null) return 1 + minDepth(root.left);
        else return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }


}
