package org.review2025spring.ch04_string;

public class T5_repeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        char[] string = s.toCharArray();
        int len = string.length;
        int[] next = new int[len];

        int j = 0;
        for (int i = 1; i < len; i++) {
            while (j > 0 && string[i] != string[j])
                j = next[j - 1];
            if (string[i] == string[j])
                j++;
            next[i] = j;
        }

        return next[len - 1] != 0 && len % (len - next[len - 1]) == 0;
    }
}
