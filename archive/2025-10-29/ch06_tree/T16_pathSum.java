package org.review2025autumn.ch06_tree;

import java.util.ArrayList;
import java.util.List;

public class T16_pathSum {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return res;
        }
        backtracking(root, targetSum);
        return res;
    }

    private void backtracking(TreeNode root, int targetSum) {
        if (root.left == null && root.right == null) {
            if (root.val == targetSum) {
                path.add(root.val);
                res.add(new ArrayList<>(path));
                path.remove(path.size() - 1);
            }
            return;
        }
        path.add(root.val);
        if (root.left != null) {
            backtracking(root.left, targetSum - root.val);
        }
        if (root.right != null) {
            backtracking(root.right, targetSum - root.val);

        }
        path.remove(path.size() - 1);
    }

}
