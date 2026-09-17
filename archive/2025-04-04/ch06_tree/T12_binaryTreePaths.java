package org.review2025spring.ch06_tree;

import java.util.ArrayList;
import java.util.List;

public class T12_binaryTreePaths {
    List<String> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        traversal(root);
        return res;
    }

    public void traversal(TreeNode root) {
        if (root.left == null && root.right == null) {
            StringBuilder builder = new StringBuilder();
            for (Integer num : path) {
                builder.append(num).append("->");
            }
            builder.append(root.val);
            res.add(builder.toString());
            return;
        }
        path.add(root.val);
        if (root.left != null) traversal(root.left);
        if (root.right != null) traversal(root.right);
        path.remove(path.size() - 1);
    }
}
