package org.rereview2024summer.stack;

import java.util.ArrayDeque;

public class T4_removeDuplicates {
    public String removeDuplicates_1(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            if (!stack.isEmpty() && stack.peek() == ch) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }

        StringBuilder res = new StringBuilder();
        for (Character ch : stack)
            res.insert(0, ch);
        return new String(res);
    }

    public String removeDuplicates_2(String s) {
        int slow = 0, fast = 0;
        char[] chars = s.toCharArray();
        for ( ; fast < chars.length; fast++) {
            chars[slow] = chars[fast];
            if (slow > 0 && chars[slow - 1] == chars[slow]) {
                slow--;
            } else {
                slow++;
            }
        }

        return new String(chars, 0, slow);
    }
}

















