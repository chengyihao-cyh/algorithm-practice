package org.review2024summer.string;

import java.util.ArrayList;

public class T3_reverseWords {
//    public String reverseWords(String s) {
//        String[] splits = s.split(" ");
//        ArrayList<String> words = new ArrayList<>();
//        StringBuffer res = new StringBuffer();
//        for (String split : splits) {
//            if (!split.equals("")) {
//                words.add(0, split);
//                words.add(0, " ");
//            }
//        }
//        words.remove(0);
//        words.forEach(str -> res.append(str));
//        return new String(res);
//    }

    public String reverseWords(String s) {
        char[] chars = s.toCharArray();

        // step1 删空格
        // 删头尾空格
        int start = 0, end = chars.length - 1;
        while (start < end && chars[start] == ' ')
            start++;
        while (start < end && chars[end] == ' ')
            end--;
        end++;  // 让end指向末尾后的null

        // 删中间空格
        int slowIdx = start, fastIdx = start;
        for ( ; fastIdx < end; fastIdx++) {
            if (!(fastIdx > 1 && chars[fastIdx] == ' ' && chars[fastIdx - 1] == ' ')) {
              chars[slowIdx] = chars[fastIdx];
              slowIdx++;
            }
        }
        end = slowIdx;   // 此时end发生变化 要更新为slowIdx


        // step2 将[start, end)区间内字符串翻转
        reverseChars(chars, start, end);


        // step3 在每个单词内部翻转
        // 最后一次特殊处理 不统一在循环内 不爽
//        int left = start, right = start;
//        while (right < end) {
//            if (chars[right] == ' ') {
//                reverseChars(chars, left, right);
//                left = right + 1;
//            }
//            right++;
//        }
//        reverseChars(chars, left, right);

        // step3 在每个单词内部翻转
        // 把最后一次的处理统一在循环内
        int left = start, right = start;
        while (right <= end) {
            if (right == end || chars[right] == ' ') {
                reverseChars(chars, left, right);
                left = right + 1;
            }
            right++;
        }


        StringBuffer res = new StringBuffer();
        for (int i = start; i < end; i++)
            res.append(chars[i]);

        return new String(res);
    }

    public static void reverseChars(char[] chars, int start, int end) {
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

