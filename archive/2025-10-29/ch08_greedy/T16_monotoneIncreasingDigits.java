package org.review2025autumn.ch08_greedy;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2025/4/7 15:24
 * @comment
 */
public class T16_monotoneIncreasingDigits {
    public int monotoneIncreasingDigits(int n) {
        char[] chars = String.valueOf(n).toCharArray();
        int begin = chars.length;

        for (int i = chars.length - 1; i >= 1; i--) {
            if (chars[i] < chars[i-1]) {
                chars[i-1]--;
                begin = i;
            }
        }
        for (int i = begin; i < chars.length; i++) {
            chars[i] = '9';
        }
        return Integer.parseInt(String.valueOf(chars));
    }
}
