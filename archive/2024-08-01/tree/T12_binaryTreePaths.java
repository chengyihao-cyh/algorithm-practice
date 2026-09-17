package org.rereview2024summer.tree;

import java.util.ArrayList;
import java.util.List;

public class T12_binaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtracking(root, res, path);
        return res;
    }
    public void backtracking(TreeNode root, List<String> res, List<Integer> path) {
        if (root.left == null && root.right == null) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < path.size(); i++) {
                builder.append(path.get(i));
                builder.append("->");
            }
            builder.append(root.val);
            res.add(builder.toString());
        }

        if (root.left != null) {
            path.add(root.val);
            backtracking(root.left, res, path);
            path.remove(path.size() - 1);
        }
        if (root.right != null) {
            path.add(root.val);
            backtracking(root.right, res, path);
            path.remove(path.size() - 1);
        }
    }
}
