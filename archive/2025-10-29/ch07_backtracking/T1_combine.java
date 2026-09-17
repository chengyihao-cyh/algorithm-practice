package org.review2025autumn.ch07_backtracking;

import java.util.ArrayList;
import java.util.List;

public class T1_combine {
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
