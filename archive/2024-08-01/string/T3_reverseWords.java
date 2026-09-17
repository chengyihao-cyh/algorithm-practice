package org.rereview2024summer.string;

public class T3_reverseWords {
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int start = 0, end = chars.length - 1;

        // step1   delete head & tail's space
        while (start < chars.length && chars[start] == ' ')
            start++;
        while (end >= 0 && chars[end] == ' ')
            end--;
        end++;

        // step2   delete mid space
        int fast = start, slow = start;
        for ( ; fast < end; fast++) {
            if (!(fast > 1 &&chars[fast] == ' ' && chars[fast - 1] == ' ')) {
                chars[slow] = chars[fast];
                slow++;
            }
        }
        end = slow;

        // step3   reverse all string
        reverse(chars, start, end);

        // step4   reverse words
        int wordBegin = start;
        for (int i = start; i <= end; i++) {
            if (i == end || chars[i] == ' ') {
                reverse(chars, wordBegin, i);
                wordBegin = i + 1;
            }
        }

        return new String(chars, start, end - start);
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

