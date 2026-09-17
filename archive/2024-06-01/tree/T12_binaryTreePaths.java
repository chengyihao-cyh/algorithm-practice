package org.review2024summer.tree;
import java.util.*;

public class T12_binaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<Integer> path = new ArrayList<>();
        ArrayList<String> res = new ArrayList<>();
        traversal(root, path, res);
        return res;
    }

    public void traversal(TreeNode root, List<Integer> path, List<String> res) {
        path.add(root.val);
        if (root.left == null && root.right == null) {
            StringBuilder pathStr = new StringBuilder();
            for (int i = 0; i < path.size() - 1; i++) {
                pathStr.append(path.get(i)).append("->");
            }
            pathStr.append(path.get(path.size() - 1));
            res.add(new String(pathStr));
            return;
        }

        if (root.left != null) {
            traversal(root.left, path, res);
            path.remove(path.size() - 1);
        }
        if (root.right != null) {
            traversal(root.right, path, res);
            path.remove(path.size() - 1);
        }
    }

}
