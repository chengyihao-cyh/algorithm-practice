package org.review2025autumn.ch04_string;

public class T2_reverseStr {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int begin;
        for (begin = 0; begin < chars.length; begin += 2 * k) {
            reverse(chars, begin, Math.min(begin + k - 1, chars.length - 1));
        }

        return new String(chars);
    }

    public void reverse(char[] s, int l, int r) {
        while (l < r) {
            char tmp = s[l];
            s[l] = s[r];
            s[r] = tmp;
            l++;
            r--;
        }
    }
}
