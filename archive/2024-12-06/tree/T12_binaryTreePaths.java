package org.review2024winter.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class T12_binaryTreePaths {
    List<String> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        backtracking(root);
        return res;
    }

    public void backtracking(TreeNode root) {
        if (root.left == null && root.right == null) {
            StringBuilder pathStr = new StringBuilder();
            for (Integer i : path) {
                pathStr.append(i).append("->");
            }
            pathStr.append(root.val);
            res.add(pathStr.toString());
            return;
        }

        path.add(root.val);
        if (root.left != null) backtracking(root.left);
        if (root.right != null) backtracking(root.right);
        path.remove(path.size() - 1);
    }

}
