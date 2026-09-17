package org.learn2024spring.String;

public class KMP_Search {
    public int search (String str_string, String str_patt) {
        int[] next = bulid_next(str_patt);
        char[] string = str_string.toCharArray();
        char[] patt = str_patt.toCharArray();

        int i = 0, j = 0;
        int res = -1;
        while (i < string.length) {
            if (string[i] == patt[j]) {
                i++;
                j++;
            } else if (j > 0) {
                j = next[j - 1];
            } else {
                i++;
            }

            if (j == patt.length){
                res = i - j;
                break;
            }
        }
        return res;
    }
    public int[] bulid_next(String str_patt) {
        char[] patt = str_patt.toCharArray();

        int[] next = new int[str_patt.length()];
        int prefix_len = 0;
        int i = 1; // 0的前缀串长度必为0 不必判断

        while (i < patt.length) {
            if (patt[i] == patt[prefix_len]) {
                prefix_len++;
                next[i] = prefix_len;
                i++;
            } else {
                if (prefix_len != 0) {
                    prefix_len = next[prefix_len - 1];
                } else {
                    //next[i] = 0; // 没必要 默认为0
                    i++;
                }
            }
        }
        return next;
    }

    public int[] bulid_next2(String str_patt) {
        char[] patt = str_patt.toCharArray();

        int[] next = new int[str_patt.length()];
        int i = 1; // 0的前缀串长度必为0
        int j = 0;

        for (i = 1; i < patt.length; i++) {
            while (j > 0 && patt[i] != patt[j]) {
                j = next[j - 1];
            }
            // 回退后有两种可能 j==0 或 终于遇到和patt[j]一致的元素
            // 若j==0 说明此时最大相同前后缀长度已归零 直接将0赋给next[i]即可
            // 若终于遇到和patt[j]一致的元素 则说明最大相同前后缀长度增加1 此时即为获取到patt[i]后i位置的最大相同前后缀长度 将该长度赋给next[i]即可
            // 因此对next[i]的更新可以统一在next[i] = j 上
            if (patt[i] == patt[j]) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }


    public int strStr1(String haystack, String needle) {

        char[] string = haystack.toCharArray();
        char[] patt = needle.toCharArray();
        int res = -1;
        int[] next = new int[needle.length()];
        int i = 0, j = 0;

        // 维护 next 数组
        for (i = 1; i < patt.length; i++) {
            while (j > 0 && patt[i] != patt[j])
                j = next[j - 1];
            if (patt[i] == patt[j])
                j++;
            next[i] = j;
        }

        // 利用 next 数组匹配
        i = 0;
        j = 0;
        while(i < string.length) {
            if (string[i] ==patt[j]) {
                i++;
                j++;
            } else if (j > 0) {
                j = next[j - 1];
            } else {
                i++;
            }

            if (j == patt.length) {
                res = i - j;
                break;
            }
        }

        return res;
    }

    public int strStr2(String haystack, String needle) {

        char[] string = haystack.toCharArray();
        char[] patt = needle.toCharArray();
        int[] next = new int[patt.length];
        int i, j;

        // 维护 next 数组
        j = 0;
        for (i = 1; i < patt.length; i++) {
            while (j > 0 && patt[i] != patt[j])
                j = next[j - 1];
            if (patt[i] == patt[j])
                j++;
            next[i] = j;
        }

        // 利用 next 数组匹配
        j = 0;
        for (i = 0; i < string.length; i++) {
            while (j > 0 && string[i] != patt[j])
                j = next[j - 1];
            if (string[i] == patt[j])
                j++;
            if (j == patt.length)
                return i - j + 1;
        }
        return -1;
    }




}

















