/**
 * Practice template for:
 * - LeetCode 257. Binary Tree Paths
 *   https://leetcode.cn/problems/binary-tree-paths/
 */
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class T12_LC0257_BinaryTreePaths {
    List<Integer> path = new ArrayList<>();
    List<String> res = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        backtracking(root);
        return res;
    }

    public void backtracking(TreeNode root) {
        if (root.left == null && root.right == null) {
            path.add(root.val);
            res.add(path.stream().map(String::valueOf).collect(Collectors.joining("->")));
            path.remove(path.size() - 1);
        }

        path.add(root.val);
        if (root.left != null) {
            backtracking(root.left);
        }
        if (root.right != null) {
            backtracking(root.right);
        }
        path.remove(path.size() - 1);
    }

}
