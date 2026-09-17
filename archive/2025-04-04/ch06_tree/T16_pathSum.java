package org.review2025spring.ch06_tree;

import java.util.ArrayList;
import java.util.List;

public class T16_pathSum {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) return res;
        traversal(root, targetSum);
        return res;
    }

    public void traversal(TreeNode root, int sum) {
        if (root.left == null && root.right == null) {
            if (sum == root.val) {
                path.add(root.val);
                res.add(new ArrayList<>(path));
                path.remove(path.size() - 1);
            }
            return;
        }
        path.add(root.val);
        if (root.left != null) traversal(root.left, sum - root.val);
        if (root.right != null) traversal(root.right, sum - root.val);
        path.remove(path.size() - 1);
    }
}
