package org.rereview2024summer.backtracking;

import java.util.ArrayList;
import java.util.List;

public class T2_combinationSum3 {
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        backtracking(k ,n , 1, 0);
        return res;
    }
    public void backtracking(int k, int target, int startIdx, int sum) {
        if (sum > (float)target / k * path.size())
            return;
        if (path.size() == k) {
            if (sum == target)
                res.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIdx; i <= 9 - (k - path.size()) + 1; i++) {
            path.add(i);
            backtracking(k , target, i + 1, sum + i);
            path.remove(path.size() - 1);
        }
    }
}
