package org.review2025spring.ch04_string;

public class T3_reverseWords {
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int start = 0, end = chars.length - 1;

        // step1 删头尾
        while (start < s.length() && chars[start] == ' ')
            start++;
        while (end > 0 && chars[end] == ' ')
            end--;

        // step2 删中间冗余空格
        int slow = start, fast = start;
        for (fast = start; fast <= end; fast++) {
            if (!(chars[fast] == ' ' && chars[fast + 1] == ' ')) {
                chars[slow] = chars[fast];
                slow++;
            }
        }
        end = slow;

        // step3 翻转句子
        reverseString(chars, start, end);

        // step4 翻转句子中的单词
        int left = start, right = start;
        while (right <= end) {
            if (chars[right] == ' ' || right == end) {
                reverseString(chars, left, right);
                left = right + 1;
            }
            right++;
        }
        return null;
    }

    // 翻转 [start, end)
    public void reverseString(char[] s, int start, int end) {
        int left = start, right = end - 1;
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

