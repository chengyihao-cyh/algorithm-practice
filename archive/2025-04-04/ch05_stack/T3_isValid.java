package org.review2025spring.ch05_stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class T3_isValid {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        char[] chars = s.toCharArray();

        for (char ch : chars) {
            if (ch == '(') {
                stack.push(')');
            } else if (ch == '[') {
                stack.push(']');
            } else if (ch == '{') {
                stack.push('}');
            } else {
                if (stack.isEmpty() || stack.pop() != ch)
                    return false;
            }
        }
        return stack.isEmpty();
    }
}
