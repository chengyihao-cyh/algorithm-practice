package org.review2025autumn.ch05_stack;

public class T4_removeDuplicates {
    public String removeDuplicates(String s) {
        char[] chars = s.toCharArray();
        int slow = 0, fast = 0;
        for (fast = 0;  fast < s.length(); fast++) {
            if (slow > 0 && chars[fast] == chars[slow - 1]) {
                slow--;
            } else {
                chars[slow] = chars[fast];
                slow++;
            }
        }
        return new String(chars, 0, slow);
    }
}

















