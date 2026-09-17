package org.review2025springAgain.ch04_string;

public class T4_search {
    public int search(String str_string, String str_patt) {
        char[] str = str_string.toCharArray();
        char[] patt = str_patt.toCharArray();
        int[] next = new int[patt.length];
        next[0] = 0;
        int i, j;

        j = 0;
        for (i  = 1; i < patt.length; i++) {
            while (j > 0 && patt[i] != patt[j])
                j = next[j - 1];
            if (patt[i] == patt[j])
                j++;
            next[i] = j;
        }

        j = 0;
        for (i  = 0; i < str.length; i++) {
            while (j > 0 && str[i] != patt[j])
                j = next[j - 1];
            if (str[i] == patt[j])
                j++;
            if (j == patt.length)
                return i - j + 1;
        }

        return -1;
    }
}
