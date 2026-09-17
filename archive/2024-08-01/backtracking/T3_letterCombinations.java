package org.rereview2024summer.backtracking;

import java.util.ArrayList;
import java.util.List;

public class T3_letterCombinations {
    List<String> res = new ArrayList<>();
    List<Character> path = new ArrayList<>();
    String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty())
            return res;
        backtracking(digits, 0);
        return res;
    }
    public void backtracking(String digits, int idx) {
        if (path.size() == digits.length()) {
            StringBuilder builder = new StringBuilder();
            for (char ch : path)
                builder.append(ch);
            res.add(builder.toString());
            return;
        }
        String str = map[digits.charAt(idx) - '0'];
        for (int i = 0; i < str.length(); i++) {
            path.add(str.charAt(i));
            backtracking(digits, idx + 1);
            path.remove(path.size() - 1);
        }
    }
}
