package org.review2024summer.backtracking;
import java.util.ArrayList;
import java.util.List;

public class T8_subsets {
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        res.add(new ArrayList<>());
        backtracking(nums, 0);
        return res;
    }
    public void backtracking(int[] nums, int startIdx) {
        if (startIdx == nums.length)
            return;
        for (int i = startIdx; i < nums.length; i++) {
            path.add(nums[i]);
            res.add(new ArrayList<>(path));
            backtracking(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
