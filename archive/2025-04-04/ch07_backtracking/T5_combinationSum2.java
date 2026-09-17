package org.review2025spring.ch07_backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T5_combinationSum2 {
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();
    boolean[] used = null;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        used = new boolean[candidates.length];
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
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])
                continue;
            path.add(nums[i]);
            used[i] = true;
            backtracking(nums, target - nums[i], i + 1);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }

}
