package org.review2024summer.backtracking;
import java.util.*;

public class T3_letterCombinations {
    List<Character> path = new ArrayList<>();
    List<String> res = new ArrayList<>();
    String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        backtracking(digits, 0);
        return res;
    }

    public void backtracking(String digits, int idx) {
        if (digits.equals(""))
            return;
        if (path.size() == digits.length()) {
            StringBuilder stringBuilder = new StringBuilder();
            for (char ch : path) {
                stringBuilder.append(ch);
            }
            res.add(stringBuilder.toString());
            return;
        }

        int currNum = digits.charAt(idx) - '0';
        String currString = numString[currNum];
        for (int i = 0; i < currString.length(); i++) {
            idx++;
            path.add(currString.charAt(i));
            backtracking(digits, idx);
            path.remove(path.size() - 1);
            idx--;
        }
    }
}
