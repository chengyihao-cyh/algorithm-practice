package org.rereview2024summer.string;

public class T2_reverseStr {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int i = 0;
        for ( ; i < s.length(); i += 2 * k) {
            int start = i;
            int end = Math.min(i + k, s.length());
            reverse(chars, start, end);
        }
        return new String(chars);
    }

    // reverse [start, end)
    public void reverse(char[] chars, int start, int end) {
        int left = start, right = end - 1;
        while (left < right) {
            char tmp = chars[left];
            chars[left] = chars[right];
            chars[right] = tmp;
            left++;
            right--;
        }
    }
}
