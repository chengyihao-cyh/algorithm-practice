package org.review2024summer.tree;
import java.util.*;

public class T16_pathSum {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        traversal(root, targetSum, path, res);
        return res;
    }

    public void traversal(TreeNode root, int targetSum, List<Integer> path,List<List<Integer>> res) {

        targetSum -= root.val;
        path.add(root.val);

        if (root.left == null && root.right == null) {
            if (targetSum == 0)
                res.add(new ArrayList<>(path));
            return;
        }

        if (root.left != null) {
            traversal(root.left, targetSum, path, res);
            path.remove(path.size() - 1);
        }
        if (root.right != null) {
            traversal(root.right, targetSum, path, res);
            path.remove(path.size() - 1);
        }
    }
}
