package org.review2025spring.ch06_tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class T5_levelOrder {
    public List<List<Integer>> levelOrderByIter(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();

        if (root != null) queue.offer(root);
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


        return null;
    }

    public void orderByRes(TreeNode root, int depth, List<List<Integer>> res) {




    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();

        if (root != null) queue.offer(root);
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




        return null;
    }

    public List<Double> averageOfLevels(TreeNode root) {



        return null;
    }

    public List<List<Integer>> levelOrder(NodeWithChild root) {


        return null;
    }

    public List<Integer> largestValues(TreeNode root) {



        return null;
    }

    public NodeWithNext connect(NodeWithNext root) {




        return null;
    }

    public int maxDepth(TreeNode root) {



        return -1;
    }

    public int minDepth(TreeNode root) {

        return -1;
    }



































}
