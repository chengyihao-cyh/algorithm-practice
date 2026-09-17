package org.rereview2024summer.stack;

import java.util.*;

public class T3_isValid {
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();

        for (char ch : chars) {
            if (ch == '(') {
                stack.push(')');
            } else if (ch == '[') {
                stack.push(']');
            } else if (ch == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || stack.peek() != ch) {
                return false;
            } else {
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
