package org.review2025springAgain.ch04_string;

public class T4_strStr {
    public int strStr(String haystack, String needle) {
        char[] string = haystack.toCharArray();
        char[] patt = needle.toCharArray();
        int[] next = new int[patt.length];
        int i, j;

        j = 0;
        for (i = 1; i < patt.length; i++) {
            while (patt[i] != patt[j] && j > 0)
                j = next[j - 1];
            if (patt[i] == patt[j])
                j++;
            next[i] = j;
        }

        j = 0;
        for (i = 0; i < string.length; i++) {
            while (string[i] != patt[j] && j > 0)
                j = next[j - 1];
            if (string[i] == patt[j])
                j++;
            if (j == patt.length)
                return i - j + 1;
        }
        return -1;
    }
}
