package org.review2024summer.backtracking;
import java.util.ArrayList;
import java.util.List;

public class T7_restoreIpAddresses_good {
    List<String> path = new ArrayList<>();
    List<String> res = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        backtracking(s, 0 ,0);
        return res;
    }

    public void backtracking(String s, int startIdx, int pointNum) {
        if (pointNum == 3) {
            if (isValid(s.substring(startIdx))) {
                StringBuilder builder = new StringBuilder();
                for (String num : path)
                    builder.append(num).append(".");
                builder.append(s.substring(startIdx));
                res.add(builder.toString());
            }
            return;
        }
        for (int i = startIdx; i < Math.min(s.length(), startIdx + 3); i++) {
            if (isValid(s.substring(startIdx, i + 1))) {
                path.add(s.substring(startIdx, i + 1));
                pointNum++;
            } else {
                continue;
            }
            backtracking(s, i + 1, pointNum);
            pointNum--;
            path.remove(path.size() - 1);
        }

    }

    public boolean isValid(String s) {
        if (s.isEmpty() || s.length() > 3)
            return false;
        int num = Integer.parseInt(s);
        return num <= 255 && (s.charAt(0) - '0' != 0 || s.length() == 1);
    }
}
