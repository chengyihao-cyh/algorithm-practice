package org.learn2024spring.tree;

import java.util.ArrayList;
import java.util.List;

public class T13_2_PathSum {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        if (root == null)
            return res;

        traversal2(root, 0, targetSum, res, path);
        return res;
    }

    // 不好的实现
    public void traversal1(TreeNode root, int currSum, int targetSum, List<List<Integer>> res, List<Integer> path) {

        if (root.left == null && root.right == null) {
            currSum += root.val;
            if (currSum == targetSum){
                path.add(root.val);
                res.add(new ArrayList<>(path));
                path.remove(path.size() - 1);
            }
            return;
        }

        if (root.left != null) {
            path.add(root.val);
            traversal1(root.left, currSum + root.val, targetSum, res, path);
            path.remove(path.size() - 1);
        }

        if (root.right != null) {
            path.add(root.val);
            traversal1(root.right, currSum + root.val, targetSum, res, path);
            path.remove(path.size() - 1);
        }

    }

    // 改进的实现
    public void traversal2(TreeNode root, int currSum, int targetSum, List<List<Integer>> res, List<Integer> path) {
        path.add(root.val);

        if (root.left == null && root.right == null) {
            currSum += root.val;
            if (currSum == targetSum){
                res.add(new ArrayList<>(path));
            }
            return;
        }

        if (root.left != null) {
            traversal2(root.left, currSum + root.val, targetSum, res, path);
            path.remove(path.size() - 1);
        }

        if (root.right != null) {
            traversal2(root.right, currSum + root.val, targetSum, res, path);
            path.remove(path.size() - 1);
        }

    }

    // 我最认可的实现
    public void traversal3(TreeNode root, int currSum, int targetSum, List<List<Integer>> res, List<Integer> path) {
        path.add(root.val);
        currSum += root.val;

        if (root.left == null && root.right == null) {
            if (currSum == targetSum){
                res.add(new ArrayList<>(path));
            }
            return;
        }

        if (root.left != null) {
            traversal3(root.left, currSum, targetSum, res, path);
            path.remove(path.size() - 1);
        }

        if (root.right != null) {
            traversal3(root.right, currSum, targetSum, res, path);
            path.remove(path.size() - 1);
        }
    }
}
