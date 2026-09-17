package org.review2025spring.ch07_backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T4_combinationSum {
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtracking(candidates, target, 0);
        return res;
    }

    public void backtracking(int[] nums, int target, int startIdx) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIdx; i < nums.length && target - nums[i] >= 0; i++) {
            path.add(nums[i]);
            backtracking(nums, target - nums[i], i);
            path.remove(path.size() - 1);
        }
    }


}
