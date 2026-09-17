package org.review2024summer.backtracking;
import java.util.ArrayList;
import java.util.List;

public class T7_restoreIpAddresses_bad {
    List<String> path = new ArrayList<>();
    List<String> res = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        backtracking(s, 0);
        return res;
    }
    public void backtracking(String s, int startIdx) {
        // 只有合法解才被放在path中
        if (path.size() == 4) {
            if (startIdx == s.length()) {
                StringBuilder builder = new StringBuilder();
                for (String num : path)
                    builder.append(num).append(".");
                builder.deleteCharAt(builder.length() - 1);
                res.add(builder.toString());
            }
            return;
        }
        for (int i = startIdx; i < Math.min(s.length(), startIdx + 3) && isValid(s.substring(startIdx, i + 1)); i++) {
            path.add(s.substring(startIdx, i + 1));
            backtracking(s, i + 1);
            path.remove(path.size() - 1);
        }

    }
    public boolean isValid(String s) {
        int num = Integer.parseInt(s);
        if (num > 255 )
            return false;
        return s.charAt(0) - '0' != 0 || s.length() == 1;
    }
}
