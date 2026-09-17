package org.review2025spring.ch05_stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class T4_removeDuplicates {
    public String removeDuplicates(String s) {
        char[] chars = s.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();
        for (char ch : chars) {
            if (!stack.isEmpty() && ch == stack.peek()) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty())
            builder.insert(0, stack.pop());
        return builder.toString();
    }
}

















