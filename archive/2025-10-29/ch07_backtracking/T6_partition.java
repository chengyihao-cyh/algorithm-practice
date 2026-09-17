package org.review2025autumn.ch07_backtracking;

import java.util.ArrayList;
import java.util.List;

public class T6_partition {
    List<String> path = new ArrayList<>();
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {
        backtracking(s, 0);
        return res;
    }

    public void backtracking(String input, int startIdx) {
        if (startIdx == input.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIdx; i < input.length(); i++) {
            String sub = input.substring(startIdx, i + 1);
            if (isValid(sub)) {
                path.add(sub);
                backtracking(input, i + 1);
                path.remove(path.size() - 1);
            }
        }
    }

    public boolean isValid(String sub) {
        int l = 0, r = sub.length() - 1;
        while (l < r) {
            if (sub.charAt(l) != sub.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
