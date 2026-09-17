package org.review2025spring.ch04_string;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2025/2/24 17:06
 * @comment
 */
public class T1_reverseString {
    public void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        char tmp;
        while (left < right) {
            tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
            left++;
            right--;
        }
    }
}
