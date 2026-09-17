package org.learn2024spring.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class T2_levelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();

        if (root != null)
            queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> level = new ArrayList<>();

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
        orderByRes(root, 0, res);
        return res;
    }

    public void orderByRes(TreeNode root, int depth, List<List<Integer>> res) {
        if (root == null)
            return;

        if (res.size() == depth)
            res.add(new ArrayList<Integer>());

        res.get(depth).add(root.val);
        orderByRes(root.left, depth + 1, res);
        orderByRes(root.right, depth + 1, res);
    }


    public List<List<Integer>> levelOrder_II(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();

        if (root != null)
            queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> level = new ArrayList<>();

            while (size-- > 0) {
                TreeNode curr = queue.poll();
                level.add(curr.val);
                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }

            res.add(0, level);
        }

        return res;
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();

        if (root != null)
            queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode curr = queue.poll();
                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
                if (size == 0)
                    res.add(curr.val);
            }
        }
        return res;
    }

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();

        if (root != null)
            queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            double sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                sum += curr.val;
                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }
            res.add(sum / size);
        }
        return res;
    }

    public List<List<Integer>> levelOrderByMultiTree(Node root) {

        List<List<Integer>> res = new ArrayList<>();
        Deque<Node> queue = new ArrayDeque<>();

        if (root != null)
            queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            while (size-- > 0) {
                Node curr = queue.poll();
                level.add(curr.val);
                if (curr.children != null)
                    for (Node chil : curr.children)
                        queue.offer(chil);
            }
            res.add(level);
        }
        return res;
    }

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();

        if (root != null)
            queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            while (size-- > 0) {
                TreeNode curr = queue.poll();
                max = Math.max(curr.val, max);
                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }
            res.add(max);
        }
        return res;
    }

    public PerfectNode connect(PerfectNode root) {
        ArrayDeque<PerfectNode> queue = new ArrayDeque<>();

        if (root != null)
            queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                PerfectNode curr = queue.poll();
                curr.next = size > 0 ? queue.peek() : null;
                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }
        }
        return root;
    }

    public int maxDepth(TreeNode root) {
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        int depth = 0;

        if (root != null)
            queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }
        }
        return depth;
    }

    public int minDepth(TreeNode root) {
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        int depth = 0;

        if (root != null)
            queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (curr.left == null && curr.right == null) return depth;
                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }
        }
        return depth;
    }
}






























