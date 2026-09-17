package org.review2025spring.ch07_backtracking;

import java.util.ArrayList;
import java.util.List;

public class T6_partition {
    List<List<String>> res = new ArrayList<>();
    List<String> path = new ArrayList<>();

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
            if (!isValid(chars, startIdx, i)) {
                continue;
            }
            path.add(new String(chars, startIdx, i - startIdx + 1));
            backtracking(chars, i + 1);
            path.remove(path.size() - 1);
        }
    }

    // [l, r]
    public boolean isValid(char[] chars, int l, int r) {
        while (l < r) {
            if (chars[l] != chars[r])
                return false;
            l++;
            r--;
        }
        return true;
    }

}
