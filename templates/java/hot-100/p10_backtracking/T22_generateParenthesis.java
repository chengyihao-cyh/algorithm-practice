/**
 * Practice template for:
 * - 22. Generate Parentheses
 *   https://leetcode.cn/problems/generate-parentheses/
 */
import com.sun.security.auth.UnixNumericGroupPrincipal;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2025/11/7 13:20
 * @comment
 */
public class T22_generateParenthesis {
    List<Integer> path = new ArrayList<>();
    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backtracking(n, n);
        return res;
    }

    public void backtracking(int countL, int countR) {
        if (countR == 0) {
            if (countL == 0) {
                StringBuilder sb = new StringBuilder();
                for (Integer i : path) {
                    if (i == 0) {
                        sb.append("(");
                    } else {
                        sb.append(")");
                    }
                }
                res.add(sb.toString());
            }
            return;
        }

        if (countL >= 1) {
            path.add(0);
            backtracking(countL - 1, countR);
            path.remove(path.size() - 1);
        }
        if (countR >= 1 && countR - 1 >= countL) {
            path.add(1);
            backtracking(countL, countR - 1);
            path.remove(path.size() - 1);
        }
    }
}
