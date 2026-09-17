package org.review2025spring.ch08_greedy;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2025/4/7 15:24
 * @comment
 */
public class T16_monotoneIncreasingDigits {
    public int monotoneIncreasingDigits(int n) {
        String s = String.valueOf(n);
        char[] chs = s.toCharArray();
        int begin = chs.length;
        for (int i = chs.length - 1; i >= 1; i--) {
            if (chs[i - 1] > chs[i]) {
                chs[i - 1]--;
                begin = i;
            }
        }
        for (int i = begin; i < chs.length; i++) {
            chs[i] = '9';
        }

        return Integer.parseInt(String.valueOf(chs));
    }
}
