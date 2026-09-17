/**
 * Practice template for:
 * - 32. Longest Valid Parentheses
 *   https://leetcode.cn/problems/longest-valid-parentheses/
 */
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2025/11/7 14:42
 * @comment
 */
public class T32_longestValidParentheses {
    public int longestValidParentheses(String s) {
        if (s == null || s.isEmpty()) {
            throw new UnsupportedOperationException("TODO");
        }

        int maxLen = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }
        return maxLen;
    }
}
