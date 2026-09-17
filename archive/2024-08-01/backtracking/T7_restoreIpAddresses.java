package org.rereview2024summer.backtracking;

import java.util.ArrayList;
import java.util.List;

public class T7_restoreIpAddresses {
    List<String> path = new ArrayList<>();
    List<String> res = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        backtracking(s, 0, 0, 0);
        return res;
    }
    public void backtracking(String s, int startIdx, int pointNum, int sumLen) {
        if (pointNum == 3) {
            String lastNumStr = s.substring(startIdx);
            if (check(lastNumStr)) {
                StringBuilder builder = new StringBuilder();
                for (String numStr : path) {
                    builder.append(numStr);
                    builder.append(".");
                }
                builder.append(lastNumStr);
                res.add(builder.toString());
            }
            return;
        }

        for (int i = startIdx; i < Math.min(s.length(), i + 3); i++) {
            String numStr = s.substring(startIdx, i + 1);
            if (!check(numStr))
                break;
            if (numStr.length() < s.length() - sumLen - 3 * (3 - pointNum))
                continue;
            path.add(numStr);
            backtracking(s, i + 1, pointNum + 1, sumLen + numStr.length());
            path.remove(path.size() - 1);
        }

    }

    public boolean check(String s) {
        int len = s.length();
        if (len == 0 || len > 3)
            return false;
        if (s.charAt(0) == '0' && len > 1)
            return false;
        return Integer.parseInt(s) < 256;
    }
}
