package org.learn2024spring.tree;

import java.util.ArrayList;
import java.util.List;

public class T10_BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        List<String> path = new ArrayList<>();
        traversal(root, paths, path);
        return paths;
    }

    public void traversal(TreeNode root, List<String> paths, List<String> path) {
        path.add("->" + root.val);

        if (root.left == null && root.right == null) {
            path.set(0, path.get(0).replace("->",""));
            StringBuilder stringBuilder = new StringBuilder();
            for (String str : path)
                stringBuilder.append(str);
            paths.add(stringBuilder.toString());
        }

        if (root.left != null) {
            traversal(root.left, paths, path);
            path.remove(path.size() - 1);
        }

        if (root.right != null) {
            traversal(root.right, paths, path);
            path.remove(path.size() - 1);
        }
    }


    public List<String> binaryTreePaths2(TreeNode root) {
        List<String> res = new ArrayList<>();// 存最终的结果
        if (root == null) {
            return res;
        }
        List<Integer> path = new ArrayList<>();// 作为结果中的路径
        traversal2(root, path, res);
        return res;
    }

    private void traversal2(TreeNode root, List<Integer> path, List<String> res) {
        path.add(root.val);

        if (root.left == null && root.right == null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < path.size() - 1; i++)
                sb.append(path.get(i) + "->");
            sb.append(path.get(path.size() - 1));
            res.add(new String(sb));
            return;
        }

        if (root.left != null) {
            traversal2(root.left, path, res);
            path.remove(path.size() - 1);
        }
        if (root.right != null) {
            traversal2(root.right, path, res);
            path.remove(path.size() - 1);
        }
    }


}



















