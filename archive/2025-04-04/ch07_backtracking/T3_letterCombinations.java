package org.review2025spring.ch07_backtracking;

import java.util.ArrayList;
import java.util.List;

public class T3_letterCombinations {
    List<Character> path = new ArrayList<>();
    List<String> res = new ArrayList<>();
    String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return res;
        backtracking(digits.toCharArray(), 0);
        return res;
    }

    public void backtracking(char[] digits, int idx) {
        if (idx == digits.length) {
            StringBuilder builder = new StringBuilder();
            for (Character ch : path) {
                builder.append(ch);
            }
            res.add(builder.toString());
            return;
        }
        int nextNum = digits[idx] - '0';
        char[] nextStr = numString[nextNum].toCharArray();
        for (char ch : nextStr) {
            path.add(ch);
            backtracking(digits, idx + 1);
            path.remove(path.size() - 1);
        }
    }
}
