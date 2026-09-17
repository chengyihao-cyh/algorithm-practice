package org.review2025springAgain.ch04_string;

import java.util.Arrays;

public class T2_reverseStr {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int len = s.length();
        int l, r;
        for (int i = 0; i < len; i += 2 * k) {
            l = i;
            r = Math.min(i + k - 1, len - 1);
            while (l < r) {
                char tmp = chars[l];
                chars[l] = chars[r];
                chars[r] = tmp;
                l++;
                r--;
            }
        }
        return new String(chars);
    }
}
