/**
 * Practice template for:
 * - LeetCode 28. Find the Index of the First Occurrence in a String
 *   https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string/
 */
public class T4_LC0028_StrStr {
    public int strStr(String haystack, String needle) {
        char[] string = haystack.toCharArray();
        char[] patt = needle.toCharArray();
        int[] next = new int[patt.length];
        int j;

        j = 0;
        for (int i = 1; i < next.length; i++) {
            while (j > 0 && patt[i] != patt[j]) {
                j = next[j - 1];
            }
            if (patt[i] == patt[j]) {
                j++;
            }
            next[i] = j;
        }

        j = 0;
        for (int i = 0; i < string.length; i++) {
            while (j > 0 && string[i] != patt[j]) {
                j = next[j - 1];
            }
            if (string[i] == patt[j]) {
                j++;
                if (j == patt.length) {
                    return i - j + 1;
                }
            }
        }
        return -1;
    }
/*    public int strStr(String haystack, String needle) {
        char[] string = haystack.toCharArray();
        char[] patt = needle.toCharArray();
        int[] next = new int[patt.length];
        next[0] = 0;
        int i, j;

        j = 0;
        for (i = 1 ;i < patt.length; i++) {
            while (j > 0 && patt[i] != patt[j])
               j =  next[j - 1];
            if (patt[i] == patt[j])
                j++;
            next[i] = j;
        }

        j = 0;
        for (i  = 0; i < string.length; i ++) {
            while (j > 0 &&  string[i] != patt[j])
                j = next[j - 1];
            if (string[i] == patt[j])
                j++;
            if (j == patt.length)
                return i - j + 1;
        }
        return -1;
    }*/

}
