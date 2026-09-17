package org.review2024summer.backtracking;
import java.util.*;

public class T5_combinationSum2 {
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();
    boolean[] used;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        used = new boolean[candidates.length];
        //Arrays.fill(used, false);
        Arrays.sort(candidates);
        backtracking(candidates, target, 0, 0);
        return res;
    }

    public void backtracking(int[] nums, int target, int sum, int startIdx) {
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIdx; i < nums.length && sum + nums[i] <= target; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])
                continue;
            path.add(nums[i]);
            sum += nums[i];
            used[i] = true;
            backtracking(nums, target, sum, i + 1);
            used[i] = false;
            sum -= nums[i];
            path.remove(path.size() - 1);
        }
    }
}
