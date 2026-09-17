package org.rereview2024summer.string;

public class T5_repeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        char[] patt = s.toCharArray();
        int[] next = new int[patt.length];

        int j = 0;
        for (int i = 1; i < patt.length; i++) {
            while (j > 0 && patt[i] != patt[j])
                j = next[j - 1];
            if (patt[i] == patt[j])
                j++;
            next[i] = j;
        }

        int subLen = patt.length - next[patt.length - 1];
        return subLen != 0 && subLen != patt.length && patt.length % subLen == 0;
    }
}
