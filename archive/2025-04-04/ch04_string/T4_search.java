package org.review2025spring.ch04_string;

public class T4_search {
    public int search(String str_string, String str_patt) {
        char[] string = str_string.toCharArray();
        char[] patt = str_patt.toCharArray();
        int[] next = new int[patt.length];

        int j = 0;
        for (int i = 1; i < next.length; i++) {
            while (j > 0 && patt[j] != patt[i])
                j = next[j - 1];
            if (patt[j] == patt[i])
                j++;
            next[i] = j;
        }

        j = 0;
        for (int i = 0; i < string.length; i++) {
            while (j > 0 && string[i] != patt[j])
                j = next[j - 1];
            if (string[i] == patt[j]) {
                j++;
                if (j == patt.length)
                    return i + 1 - j;
            }
        }
        return -1;
    }

    public int search2(String str_string, String str_patt) {
        char[] string = str_string.toCharArray();
        char[] patt = str_patt.toCharArray();
        int[] next = new int[patt.length];

        int j = 0;
        for (int i = 0; i < patt.length; i++) {
            while (j > 0 && patt[i] != patt[j]) {
                j = next[j - 1];
            }
            if (patt[i] == patt[j]) {
                j++;
            }
            next[i] = j;
        }

        j = 0;
        for (int i = 0; i < string.length; i++) {
            while (j > 0 && string[i] != patt[j]) {
                j = next[j - 1];
            }
            if (string[i] == patt[j]) {
                j++;
                if (j == patt.length) {
                    return i - j + 1;
                }
            }
        }
        return -1;
    }
}




















