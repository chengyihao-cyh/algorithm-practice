package org.learn2024spring.String;

public class T2_ReverseStr {
    public String reverseStr1(String s, int k) {
        // java的字符串处理没c++那么自由，没有形参为start、end的reverse函数，只有整体翻转函数StringBuffer.reverse()
        // 因此采用字符数组处理较方便
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i += 2 * k) {
            if (i + k - 1 < chars.length) {
                // 前k段能完全翻转
                for (int start = i, end = i + k - 1; start < end; start++, end--) {
                    char tmp = chars[start];
                    chars[start] = chars[end];
                    chars[end] = tmp;
                }
            } else {
                // 前k段不足，就以最后元素为end
                for (int start = i, end = chars.length - 1; start < end; start++, end--) {
                    char tmp = chars[start];
                    chars[start] = chars[end];
                    chars[end] = tmp;
                }
            }
        }

        return new String(chars);
    }

    // 基于上一版本迭代
    public String reverseStr2(String s, int k) {
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i += 2 * k) {
            int start = i;
            int end = Math.min(i + k - 1, chars.length - 1);

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

