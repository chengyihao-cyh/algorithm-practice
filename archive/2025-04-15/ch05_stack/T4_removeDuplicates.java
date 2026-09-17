package org.review2025springAgain.ch05_stack;

import java.util.Arrays;

public class T4_removeDuplicates {
    public String removeDuplicates(String s) {
        char[] chars = s.toCharArray();
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (j > 0 && chars[i] == chars[j - 1]) {
                j--;
            } else {
                chars[j] = chars[i];
                j++;
            }
        }
        return new String(chars).substring(0, j);
    }
}

















