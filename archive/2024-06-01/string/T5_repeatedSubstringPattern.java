package org.review2024summer.string;

public class T5_repeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        char[] patt = s.toCharArray();
        int[] next = new int[patt.length];

        int j = 0;
        for (int i = 1; i < patt.length; i++) {
            while (patt[i] != patt[j] && j > 0)
                j = next[j - 1];
            if (patt[i] == patt[j])
                j++;
            next[i] = j;
        }

        int len = patt.length;
        int subLen = len - next[len - 1];
        return subLen != len && subLen != 0 && len % subLen == 0;
    }
}
