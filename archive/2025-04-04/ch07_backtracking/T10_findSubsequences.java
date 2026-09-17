package org.review2025spring.ch07_backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class T10_findSubsequences {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        backtracking(nums, 0);
        return res;
    }

    public void backtracking(int[] nums, int startIdx) {
        if (path.size() >= 2) {
            res.add(new ArrayList<>(path));
        }
        if (startIdx == nums.length) {
            return;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = startIdx; i < nums.length; i++) {
            if (set.contains(nums[i]) ||
                    (!path.isEmpty() && nums[i] < path.get(path.size() - 1)))
                continue;
            set.add(nums[i]);
            path.add(nums[i]);
            backtracking(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }

}
