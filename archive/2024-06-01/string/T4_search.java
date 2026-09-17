package org.review2024summer.string;

public class T4_search {
    public int search (String str_string, String str_patt) {
        int[] next = bulid_next(str_patt);
        char[] string = str_string.toCharArray();
        char[] patt = str_patt.toCharArray();

        int i = 0, j = 0;
        int res = -1;
        while (i < string.length) {
            if (string[i] == patt[j]) {
                i++;
                j++;
                if (j == patt.length) {
                    res = i - j;
                    break;
                }
            } else if (j > 0) {
                j = next[j - 1];
            } else {
                j = 0;
                i++;
            }

        }

        return res;
    }

    public int[] bulid_next(String str_patt) {
        char[] patt = str_patt.toCharArray();
        int[] next = new int[patt.length];
        int prefix_len = 0;
        int i = 1;

        while (i < patt.length) {
            if (patt[i] == patt[prefix_len]) {
                prefix_len++;
                next[i] = prefix_len;
                i++;
            } else {
                if (prefix_len != 0) {
                    prefix_len = next[prefix_len - 1];
                } else {
                    next[i] = 0;
                    i++;
                }
            }
        }
        return next;
    }

}
