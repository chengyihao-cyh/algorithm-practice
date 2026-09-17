package org.review2024summer.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T4_combinationSum {
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtracking(candidates, target, 0, 0);
        return res;
    }

    public void backtracking(int[] candidates, int target, int sum, int startIdx) {
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIdx; i < candidates.length && sum + candidates[i] <= target; i++) {
            path.add(candidates[i]);
            sum += candidates[i];
            backtracking(candidates, target, sum, i);
            sum -= candidates[i];
            path.remove(path.size() - 1);
        }
    }
}
