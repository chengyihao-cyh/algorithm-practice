/**
 * Practice template for:
 * - 131. Palindrome Partitioning
 *   https://leetcode.cn/problems/palindrome-partitioning/
 */
import java.util.ArrayList;
import java.util.List;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2025/11/7 17:43
 * @comment
 */
public class T131_partition {
    List<String> path = new ArrayList<>();
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {
        backtracking(s, 0);
        return res;
    }

    public void backtracking(String s, int startIdx) {
        if (startIdx == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIdx; i < s.length(); i++) {
            String sub = s.substring(startIdx, i + 1);
            if (isValid(sub)) {
                path.add(sub);
                backtracking(s, i + 1);
                path.remove(path.size() - 1);
            }
        }
    }

    public boolean isValid(String s) {
        if (s.isEmpty()) {
            return false;
        } else if (s.length() == 1) {
            return true;
        }
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
