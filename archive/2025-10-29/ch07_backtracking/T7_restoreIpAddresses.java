package org.review2025autumn.ch07_backtracking;

import java.util.ArrayList;
import java.util.List;

public class T7_restoreIpAddresses {
    List<String> path = new ArrayList<>();
    List<String> res = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        backtracking(s, 0);
        return res;
    }

    public void backtracking(String input, int startIdx) {
        if (path.size() == 4) {
            if (startIdx == input.length()) {
                String join = String.join(".", path);
                res.add(join);
            }
            return;
        }
        for (int i = startIdx; i < Math.min(startIdx + 3, input.length()); i++) {
            if (path.size() + input.length() - i < 4) {
                break;
            }

            String sub = input.substring(startIdx, i + 1);
            if (!isValid(sub)) {
                continue;
            }
            path.add(sub);
            backtracking(input, i + 1);
            path.remove(path.size() - 1);

        }
    }

    public boolean isValid(String sub) {
        if (sub.length() == 0 || sub.length() >= 4) {
            return false;
        }
        int val = Integer.parseInt(sub);
        if (val == 0 && sub.length() != 1 || sub.charAt(0) == '0' && sub.length() != 1 || val > 255) {
            return false;
        }
        return true;
    }
}
