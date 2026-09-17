package org.review2025autumn.ch04_string;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2025/9/25 10:38
 * @comment
 */
public class T1_reverseStr {
    public void reverseString(char[] s) {
        int l = 0, r = s.length - 1;
        while (l < r) {
            char tmp = s[l];
            s[l] = s[r];
            s[r] = tmp;
            l++;
            r--;
        }
    }
}
