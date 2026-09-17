package org.review2024winter.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class T16_pathSum {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) return res;
        backtracking(root, targetSum);
        return res;
    }

    public void backtracking(TreeNode root, int target) {
        target -= root.val;
        path.add(root.val);

        if (root.left == null && root.right == null) {
            if (target == 0) {
                res.add(new LinkedList<>(path));
            }
            return;
        }
        if (root.left != null) {
            backtracking(root.left, target);
            path.remove(path.size() - 1);
        }
        if (root.right != null) {
            backtracking(root.right, target);
            path.remove(path.size() - 1);
        }
    }
}
