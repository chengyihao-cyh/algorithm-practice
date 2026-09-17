package org.review2025spring.ch07_backtracking;

import java.util.ArrayList;
import java.util.List;

public class T8_subsets {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtracking(nums, 0);
        return res;
    }

    public void backtracking(int[] nums, int startIdx) {
        res.add(new ArrayList<>(path));
        if (startIdx == nums.length) {
            return;
        }
        for (int i = startIdx; i < nums.length; i++) {
            path.add(nums[i]);
            backtracking(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }

}
