package org.learn2024spring.stack;

import java.util.ArrayDeque;
import java.util.Deque;

class T3_isValid {
    public boolean isValid(String s) {

        if (s.length() % 2 == 1)
            return false;

        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(')
                stack.push(')');
            else if (ch == '[')
                stack.push(']');
            else if (ch == '{')
                stack.push('}');
            else if (stack.isEmpty() || stack.peek() != ch)
                return false;
            else
                stack.pop();
        }

        return stack.isEmpty();
    }
}