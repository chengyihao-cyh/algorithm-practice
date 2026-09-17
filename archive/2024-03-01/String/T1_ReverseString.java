package org.learn2024spring.String;

public class T1_ReverseString {
    public void reverseString(char[] s) {
        int i = 0, j = s.length - 1;
        for (i = 0; i < s.length / 2; i++, j--) {
            char tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
        }
    }
}
