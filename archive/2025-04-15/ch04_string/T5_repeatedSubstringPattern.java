package org.review2025springAgain.ch04_string;

public class T5_repeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        char[] str = s.toCharArray();
        int len = str.length;
        int[] next = new int[len];
        int j = 0;
        for (int i = 1; i < len; i++) {
            while (str[i] != str[j] && j > 0)
                j = next[j - 1];
            if (str[i] == str[j])
                j++;
            next[i] = j;
        }
        int k = len - next[len - 1];
        return k < len && len % k == 0 ;
    }
}
