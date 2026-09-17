/**
 * Practice template for:
 * - LeetCode 20. Valid Parentheses
 *   https://leetcode.cn/problems/valid-parentheses/
 */
import java.util.ArrayDeque;
import java.util.Deque;

public class T3_LC0020_IsValid {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        char[] input = s.toCharArray();
        for (char ch : input) {
            if (ch == '(') {
                stack.push(')');
            } else if (ch == '[') {
                stack.push(']');
            } else if (ch == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || stack.pop() != ch) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
