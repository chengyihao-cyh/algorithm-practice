package org.rereview2024summer.tree;

import java.util.ArrayList;
import java.util.List;

public class T16_pathSum {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root != null)
            backtracking(root, targetSum);
        return res;
    }
    public void backtracking(TreeNode root, int targetSum) {
        path.add(root.val);
        if (root.left == null && root.right == null)
            if (root.val == targetSum)
                res.add(new ArrayList<>(path));
        if (root.left != null) {
            backtracking(root.left, targetSum - root.val);
            path.remove(path.size() - 1);
        }
        if (root.right != null) {
            backtracking(root.right, targetSum -root.val);
            path.remove(path.size() - 1);
        }
    }
}
