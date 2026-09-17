package org.review2025spring.ch07_backtracking;

import java.util.ArrayList;
import java.util.List;

public class T2_combinationSum3 {
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtracking(k, n, 1);
        return res;
    }

    public void backtracking(int k, int n, int startIdx) {
        if (n == 0 && path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIdx; i <= 9 - (k - path.size()) + 1 && n - i >= 0; i++) {
            path.add(i);
            backtracking(k, n - i, i + 1);
            path.remove(path.size() - 1);
        }
    }

}
