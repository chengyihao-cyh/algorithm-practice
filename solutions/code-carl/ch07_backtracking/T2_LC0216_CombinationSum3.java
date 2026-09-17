/**
 * Practice template for:
 * - LeetCode 216. Combination Sum III
 *   https://leetcode.cn/problems/combination-sum-iii/
 */
import java.util.ArrayList;
import java.util.List;

public class T2_LC0216_CombinationSum3 {
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtracking(k, n, 1, 0);
        return res;
    }

    public void backtracking(int k, int n, int startIdx, int sum) {
        if (path.size() == k) {
            if (sum == n) {
                res.add(new ArrayList<>(path));
            }
            return;
        }

        for (int i = startIdx; i <= 10 - (k - path.size()) && sum + i <= n ; i++) {
            path.add(i);
            backtracking(k, n, i + 1, sum + i);
            path.remove(path.size() - 1);
        }
    }
}
