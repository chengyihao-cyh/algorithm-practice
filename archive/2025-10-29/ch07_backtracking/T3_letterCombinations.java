package org.review2025autumn.ch07_backtracking;

import java.util.ArrayList;
import java.util.List;

public class T3_letterCombinations {
    List<String> res = new ArrayList<>();
    List<Character> path = new ArrayList<>();
    String[] digitToCandidates = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        backtracking(digits, 0);
        return res;
    }

    public void backtracking(String digits, int idx) {
        if (path.size() == digits.length()) {
            StringBuilder sb = new StringBuilder();
            for (Character ch : path) {
                sb.append(ch);
            }
            res.add(sb.toString());
            return;
        }
        int digit = digits.charAt(idx) - '0';
        String candidates = digitToCandidates[digit];
        for (int i = 0; i < candidates.length(); i++) {
            path.add(candidates.charAt(i));
            backtracking(digits, idx + 1);
            path.remove(path.size() - 1);
        }
    }
}
