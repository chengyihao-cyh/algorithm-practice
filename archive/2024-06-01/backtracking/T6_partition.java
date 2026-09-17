package org.review2024summer.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class T6_partition {
    List<String> path = new ArrayList<>();
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {
        backtracking(s.toCharArray(), 0);
        return res;
    }

    public void backtracking(char[] chars, int startIdx) {
        if (startIdx > chars.length - 1) {
            StringBuilder stringBuilder = new StringBuilder();
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIdx; i < chars.length; i++) {
            if (check(chars, startIdx, i)) {
                path.add(new String(chars, startIdx, i - startIdx + 1));
            } else {
                continue;
            }
            backtracking(chars, i + 1);
            path.remove(path.size() - 1);
        }
    }

    // check [start, end]
    public boolean check(char[] chars, int start, int end) {
        for (int i = 0; i < (end + 1 - start) / 2; i++)
            if (chars[start + i] != chars[end - i])
                return false;
        return true;
    }
}
