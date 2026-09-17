package org.review2024summer.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class T10_findSubsequences {
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        backtracking(nums, 0);
        return res;
    }

    public void backtracking(int[] nums, int startIdx) {
        if (path.size() >= 2)
            res.add(new ArrayList<>(path));
        if (startIdx == nums.length)
            return;
        HashSet<Integer> set = new HashSet<>();
        for (int i = startIdx; i < nums.length; i++) {
            if ((!path.isEmpty() && nums[i] < path.get(path.size() - 1)) || set.contains(nums[i]))
                continue;
            path.add(nums[i]);
            set.add(nums[i]);
            backtracking(nums, i + 1);
            path.remove(path.size() - 1);

        }
    }
}
