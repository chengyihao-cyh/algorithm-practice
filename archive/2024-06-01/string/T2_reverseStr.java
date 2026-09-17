package org.review2024summer.string;

public class T2_reverseStr {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();

        for (int i = 0; i < s.length(); i += 2 * k) {
            int start = i;
            int end = Math.min(i + k - 1, s.length() - 1);
            while (start < end) {
                char tmp = chars[start];
                chars[start] = chars[end];
                chars[end] = tmp;
                start++;
                end--;
            }
        }
        return new String(chars);
    }
}
