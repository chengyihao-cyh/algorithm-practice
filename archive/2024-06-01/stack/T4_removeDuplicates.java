package org.review2024summer.stack;

import java.util.ArrayDeque;

public class T4_removeDuplicates {
    public String removeDuplicates_1(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!stack.isEmpty() && stack.peek() == ch) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }

        while (!stack.isEmpty())
            res.insert(0, stack.pop());

        return new String(res);
    }

    public String removeDuplicates_2(String s) {
        char[] res = s.toCharArray();
        int slow = 0, fast = 0;

        for (fast = 0; fast < res.length; fast++) {
            res[slow] = res[fast];
            if (slow > 0 && res[slow] == res[slow - 1])
                slow--;
            else
                slow++;
        }

        return new String(res, 0, slow);
    }
}
