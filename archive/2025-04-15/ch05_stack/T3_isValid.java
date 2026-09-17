package org.review2025springAgain.ch05_stack;

import java.util.ArrayDeque;

public class T3_isValid {
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        ArrayDeque<Character> stack = new ArrayDeque<>();

        for (char ch : chars) {
            if (ch == '(') {
                stack.push(')');
            } else if (ch == '{') {
                stack.push('}');
            } else if (ch == '[') {
                stack.push(']');
            } else {
                if (stack.isEmpty() || stack.pop() != ch)
                    return false;
            }
        }
        return stack.isEmpty();
    }
}
