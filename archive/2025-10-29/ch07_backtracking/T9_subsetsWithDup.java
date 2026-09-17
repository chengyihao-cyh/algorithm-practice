package org.review2025autumn.ch07_backtracking;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T9_subsetsWithDup {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    boolean[] used;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        used = new boolean[nums.length];
        backtracking(nums, 0);
        return res;
    }

    public void backtracking(int[] nums, int startIdx) {
        res.add(new ArrayList<>(path));
        if (startIdx == nums.length) {
            return;
        }
        for (int i = startIdx; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            backtracking(nums, i + 1);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }

}
