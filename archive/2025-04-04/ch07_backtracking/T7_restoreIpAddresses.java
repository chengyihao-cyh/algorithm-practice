package org.review2025spring.ch07_backtracking;

import java.util.ArrayList;
import java.util.List;

public class T7_restoreIpAddresses {
    List<String> res = new ArrayList<>();
    List<String> path = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        backtracking(s, 0);
        return res;
    }

    public void backtracking(String s, int startIdx) {
        if (path.size() == 4) {
            if (startIdx == s.length()) {
                res.add(String.join(".", path));
            }
            return;
        }
        for (int i = startIdx; i < s.length() && i < startIdx + 3; i++) {
            if (path.size() + s.length() - startIdx < 4) {
                break;
            }
            String nextNum;
            if (!isValid(nextNum = s.substring(startIdx, i + 1))) {
                break;
            }
            path.add(nextNum);
            backtracking(s, i + 1);
            path.remove(path.size() - 1);
        }
    }

    public boolean isValid(String s) {
        if (s.length() <= 0 || s.length() > 3) return false;
        if (s.charAt(0) == '0' && s.length() != 1) return false;
        int val = Integer.parseInt(s);
        return val >= 0 && val <= 255;
    }

}
