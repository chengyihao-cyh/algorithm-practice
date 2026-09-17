package org.rereview2024summer.backtracking;

import java.util.ArrayList;
import java.util.List;

public class T6_partition {
    List<String> path = new ArrayList<>();
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {
        backtracking(s.toCharArray(), 0);
        return res;
    }

    public void backtracking(char[] chars, int startIdx) {
        if (startIdx == chars.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIdx; i < chars.length; i++) {
            if (!check(chars, startIdx, i))
                continue;
            path.add(new String(chars, startIdx, i - startIdx + 1));
            backtracking(chars, i + 1);
            path.remove(path.size() - 1);
        }
    }

    // check [start, end]
    public boolean check(char[] chars, int left, int right) {
        while (left < right) {
            if (chars[left] != chars[right])
                return false;
            left++;
            right--;
        }
        return true;
    }
}
