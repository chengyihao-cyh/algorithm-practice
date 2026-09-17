/**
 * Practice template for:
 * - LeetCode 77. Combinations
 *   https://leetcode.cn/problems/combinations/
 */
import java.util.ArrayList;
import java.util.List;

public class T1_LC0077_Combine {
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtracking(n, k, 1);
        return res;
    }

    public void backtracking(int n, int k, int startIdx) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIdx; i <= n - (k - path.size()) + 1; i++) {
            path.add(i);
            backtracking(n, k, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
