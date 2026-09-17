package org.review2024summer.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class T5_levelOrder {
    public List<List<Integer>> levelOrderByIter(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        if (root != null)
            queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            while (size-- > 0) {
                TreeNode curr = queue.poll();
                level.add(curr.val);
                if (curr.left != null)
                    queue.add(curr.left);
                if (curr.right != null)
                    queue.add(curr.right);
            }
            res.add(level);
        }
        return res;
    }

    public List<List<Integer>> levelOrderByRes(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        orderByRes(root, 0, res);
        return res;
    }

    public void orderByRes(TreeNode root, int depth, List<List<Integer>> res) {
        if (root == null)
            return;
        if (res.size() == depth)
            res.add(new ArrayList<>());
        res.get(depth).add(root.val);
        orderByRes(root.left, depth + 1, res);
        orderByRes(root.right, depth + 1, res);
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        if (root != null)
            queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> level = new ArrayList<>();
            while (size-- > 0) {
                TreeNode curr = queue.poll();
                level.add(curr.val);
                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
            }
            res.add(0, level);
        }
        return res;
    }

    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        if (root != null)
            queue.push(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (i == size - 1)
                    res.add(curr.val);
                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
            }
        }
        return res;
    }

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        if (root != null)
            queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            double sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                sum += curr.val;
                if (curr.left != null)
                    queue.add(curr.left);
                if (curr.right != null)
                    queue.add(curr.right);
            }
            res.add(sum / size);
        }
        return res;
    }

    public List<List<Integer>> levelOrder(NodeWithChild root) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayDeque<NodeWithChild> queue = new ArrayDeque<>();
        if (root != null)
            queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            while (size-- > 0) {
                NodeWithChild curr = queue.poll();
                level.add(curr.val);
                List<NodeWithChild> children = curr.children;
                queue.addAll(children);
            }
            res.add(level);
        }
        return res;
    }

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        if (root != null)
            queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            while (size-- > 0) {
                TreeNode curr = queue.poll();
                max = Math.max(max, curr.val);
                if (curr.left != null)
                    queue.add(curr.left);
                if (curr.right != null)
                    queue.add(curr.right);
            }
            res.add(max);
        }
        return res;
    }

    public NodeWithNext connect(NodeWithNext root) {
        ArrayDeque<NodeWithNext> queue = new ArrayDeque<>();
        if (root != null)
            queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayDeque<NodeWithNext> level = new ArrayDeque<>();
            while (size-- > 0) {
                NodeWithNext curr = queue.poll();
                level.add(curr);
                if (curr.left != null)
                    queue.add(curr.left);
                if (curr.right != null)
                    queue.add(curr.right);
            }

            NodeWithNext curr = level.pollFirst();
            while (curr != null) {
                NodeWithNext tmp = level.pollFirst();
                curr.next = tmp;
                curr = tmp;
            }
        }
        return root;
    }

    public int maxDepth(TreeNode root) {
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        int depth = 0;
        if (root != null)
            queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            while (size-- > 0) {
                TreeNode curr = queue.poll();
                if (curr.left != null)
                    queue.add(curr.left);
                if (curr.right != null)
                    queue.add(curr.right);
            }
        }
        return depth;
    }

    public int minDepth(TreeNode root) {
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        int depth = 0;
        if (root != null)
            queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            while (size-- > 0) {
                TreeNode curr = queue.poll();
                if (curr.left == null && curr.right == null)
                    return depth;
                if (curr.left != null)
                    queue.add(curr.left);
                if (curr.right != null)
                    queue.add(curr.right);
            }
        }
        return depth;
    }



































}
