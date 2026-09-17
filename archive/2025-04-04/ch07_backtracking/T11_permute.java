package org.review2025spring.ch07_backtracking;

import java.util.ArrayList;
import java.util.List;

public class T11_permute {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    boolean[] used = null;

    public List<List<Integer>> permute(int[] nums) {
        used = new boolean[nums.length];
        backtracking(nums);
        return res;
    }

    public void backtracking(int[] nums) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            path.add(nums[i]);
            used[i] = true;
            backtracking(nums);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }

}
