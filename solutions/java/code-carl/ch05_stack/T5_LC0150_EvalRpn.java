/**
 * Practice template for:
 * - LeetCode 150. Evaluate Reverse Polish Notation
 *   https://leetcode.cn/problems/evaluate-reverse-polish-notation/
 */
import java.util.ArrayDeque;
import java.util.Deque;

public class T5_LC0150_EvalRpn {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String token : tokens) {
            if (token.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (token.equals("-")) {
                stack.push(-stack.pop() + stack.pop());
            } else if (token.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (token.equals("/")) {
                Integer n1 = stack.pop();
                stack.push(stack.pop() / n1);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }
}
