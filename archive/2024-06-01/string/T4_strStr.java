package org.review2024summer.string;

public class T4_strStr {
        public int strStr(String haystack, String needle) {
        char[] string = haystack.toCharArray();
        char[] patt = needle.toCharArray();
        int[] next = new int[patt.length];

        // step1 build next[]
        int j = 0;
        // 易错点：i要从1开始 不然会一开始就让j++错位到i后，导致死循环
        for (int i = 1; i < patt.length; i++) {
            while (patt[i] != patt[j] && j > 0)
                j = next[j - 1];
            if (patt[i] == patt[j])
                j++;
            next[i] = j;
        }

        // step2 matching by next[]
        j = 0;
        for (int i = 0; i < string.length; i++) {
            while (string[i] != patt[j] && j > 0)
                j = next[j - 1];
            if (string[i] == patt[j]) {
                j++;
                if (j == patt.length)
                    return i + 1 - j;
            }
        }

        return -1;
    }
}
