package org.review2024summer.backtracking;
import java.util.*;

public class T2_combinationSum3 {
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        backtracking(k, n, 1, 0);
        return res;
    }

    public void backtracking(int k, int targetSum, int startIdx, int sum) {
        if (sum > (float)targetSum / k * path.size())
            return;
        if (path.size() == k) {
            if (sum == targetSum)
                res.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIdx; i <= 9 - (k - path.size()) + 1; i++) {
            sum += i;
            path.add(i);
            backtracking(k, targetSum, i + 1, sum);
            path.remove(path.size() - 1);
            sum -= i;
        }
    }
}
