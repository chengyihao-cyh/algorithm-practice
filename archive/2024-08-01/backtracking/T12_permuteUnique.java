package org.rereview2024summer.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class T12_permuteUnique {
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();
    boolean[] used;
    public List<List<Integer>> permuteUnique(int[] nums) {
        used = new boolean[nums.length];
        Arrays.sort(nums);
        backtracking(nums);
        return res;
    }

    public void backtracking(int[] nums) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])
                continue;
            if (used[i])
                continue;
            path.add(nums[i]);
            used[i] = true;
            backtracking(nums);
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }
}
