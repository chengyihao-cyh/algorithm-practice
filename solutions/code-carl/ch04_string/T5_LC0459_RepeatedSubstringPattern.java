/**
 * Practice template for:
 * - LeetCode 459. Repeated Substring Pattern
 *   https://leetcode.cn/problems/repeated-substring-pattern/
 */
public class T5_LC0459_RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        char[] chars = s.toCharArray();
        int[] next = new int[chars.length];
        int j = 0;
        for (int i = 1; i < chars.length; i++) {
            while (j > 0 && chars[i] != chars[j])
                j = next[j - 1];
            if (chars[i] == chars[j])
                j++;
            next[i] = j;
        }
        int len = s.length() - next[s.length() - 1];
        return len <= s.length() / 2 && s.length() % len == 0;
    }
}
