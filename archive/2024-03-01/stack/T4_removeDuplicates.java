package org.learn2024spring.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class T4_removeDuplicates {
    public String removeDuplicates1(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!stack.isEmpty() && stack.peek() == ch)
                stack.pop();
            else
                stack.push(ch);
        }

        while (!stack.isEmpty())
            res.insert(0, stack.pop());

        return new String(res);
    }

    public String removeDuplicates2(String s) {

        StringBuilder res = new StringBuilder();
        int top = -1;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (top != -1 && res.charAt(top) == ch){
                res.deleteCharAt(top);
                top--;
            }
            else{
                res.append(ch);
                top++;
            }
        }
        return new String(res);
    }

    public String removeDuplicates3(String s) {

        char[] res = s.toCharArray();
        int slow = 0, fast = 0;

        for (fast = 0; fast < s.length(); fast++) {
            res[slow] = res[fast];
            if (slow > 0 && res[slow] == res[slow - 1])
                slow--;
            else
                slow++;
        }
        return new String(res, 0, slow);
    }

}

